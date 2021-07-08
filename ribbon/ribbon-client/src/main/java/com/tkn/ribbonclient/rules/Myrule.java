package com.tkn.ribbonclient.rules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.SneakyThrows;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/7 16:47
 * @description: hash一致性rule
 */
public class Myrule extends AbstractLoadBalancerRule implements IRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        // 硬核获取HttpServletRequest
        final HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        String uri = request.getServletPath() + "?" + request.getQueryString();
        return route(uri.hashCode(), getLoadBalancer().getAllServers());
    }

    // 获取hash中的server
    public Server route(int hashid, List<Server> addressList) {
        if (CollectionUtils.isEmpty(addressList)) {
            return null;
        }
        TreeMap<Long, Server> address = new TreeMap<>();
        addressList.stream().forEach(server -> {
            // 虚化10个节点
            for (int i = 0; i < 10; i++) {
                Long hash = hash(server.getId() + i);
                address.put(hash, server);
            }
        });
        // 顺时针获取最前面的节点
        final Long hash = hash(String.valueOf(hashid));
        final SortedMap<Long, Server> serverSortedMap = address.tailMap(hash);
        // 如果为空获取第一个
        if (serverSortedMap.isEmpty()) {
            return address.firstEntry().getValue();
        }
        return serverSortedMap.get(serverSortedMap.firstKey());

    }

    @SneakyThrows
    public Long hash(String key) {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        final byte[] bytes = key.getBytes("UTF-8");
        md5.update(bytes);
        final byte[] digest = md5.digest();
        long hashCode = ((long) (digest[2] & 0xFF << 16))
                | ((long) (digest[1] & 0xFF << 8))
                | ((long) (digest[0] & 0xFF));

        return hashCode & 0xffffffffL;
    }
}
