package com.hj.util;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author huangjie
 * @time 2019-06-05 16:00
 */
public class AtomicTest {


    /**
     * //比较设置 参数依次为：期望值 写入新值 期望时间戳 新时间戳
     * public boolean compareAndSet(V expectedReference,V
     * newReference,int expectedStamp,int newStamp)
     * //获得当前对象引用
     * public V getReference()
     * //获得当前时间戳
     * public int getStamp()
     * //设置当前对象引用和时间戳
     * public void set(V newReference, int newStamp)
     */
    private final LinkedTransferQueue<Integer> linkedTransferQueue = new LinkedTransferQueue<Integer>();


    public void test () throws InterruptedException {
        Integer a = 123;



        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(a, 1);

        int stamp = atomicStampedReference.getStamp();

        atomicStampedReference.compareAndSet(a, a++, stamp, stamp+1);


        /**
         * // 将元素转移给消费者，如果需要的话等待。
         *     // 更准确地说，如果存在一个消费者已经等待接收它（在 take 或timed poll（long，TimeUnit）poll）中，则立即传送指定的元素，否则等待直到元素由消费者接收。
         */
        linkedTransferQueue.transfer(1);

        /**
         * // 如果可能，立即将元素转移给等待的消费者。
         *     // 更确切地说，如果存在消费者已经等待接收它（在 take 或 timed poll（long，TimeUnit）poll）中，则立即传送指定的元素，否则返回 false。
         */
        boolean b = linkedTransferQueue.tryTransfer(1);

        linkedTransferQueue.tryTransfer(1,10, TimeUnit.SECONDS);

        // 返回等待消费者人数的估计值
        linkedTransferQueue.getWaitingConsumerCount();

    }
}
