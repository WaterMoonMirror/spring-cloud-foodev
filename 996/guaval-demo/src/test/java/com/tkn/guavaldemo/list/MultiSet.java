package com.tkn.guavaldemo.list;

import com.google.common.collect.HashMultiset;
import com.google.common.primitives.Chars;
import org.junit.jupiter.api.Test;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/12 12:29
 * @description:
 */
public class MultiSet {
    private final String caseString="水调歌头\n" +
            "作者：苏轼\n" +
            "　　丙辰中秋，欢饮达旦，大醉，作此篇，兼怀子由。\n" +
            "　　明月几时有，把酒问青天。不知天上宫阙，今夕是何年。我欲乘风归去，又恐琼楼玉宇，高处不胜寒。起舞弄清影，何似在人间。\n" +
            "　　转朱阁，低绮户，照无眠。不应有恨，何事长向别时圆？人有悲欢离合，月有阴晴圆缺，此事古难全。但愿人长久，千里共婵娟。";
        @Test
        public void handle(){
            // 字符串转字节
            final char[] chars = caseString.toCharArray();
            // 创建multiset
            final HashMultiset<Object> multiset = HashMultiset.create();
            // 循环添加元素
            Chars.asList(chars).stream().forEach(v->{
                multiset.add(v);
            });
            System.out.println("size: "+multiset.size());
            System.out.println("count: "+multiset.count('不'));

        }

}
