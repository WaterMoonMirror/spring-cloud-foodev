package com.tkn.guavaldemo.concurrency;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/12 16:08
 * @description: 并发编程是一个难题，但是一个强大而简单的抽象可以显著的简化并发的编写。出于这样的考虑，Guava 定义了 ListenableFuture接口并继承了JDK concurrent包下的Future 接口。
 */
public class ListenableFutureTest {

    public static void main(String[] args) {
        // create ListeningExecutorService
        final ListeningExecutorService listeningDecorator = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1));
        final ListenableFuture<String> future = listeningDecorator.submit(new Callable<String>() {

            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public String call() throws Exception {
                return "this is  ListeningExecutorService  submit";
            }
        });
        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("onSuccess:"+result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("onFailure:"+t.getMessage());
            }
        });

    }
}
