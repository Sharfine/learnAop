package com.sharfine.validate.thread;

/**
 * @author: Sharfine
 * @createTime: 2020/8/11 14:03
 */
public class TestThread implements Runnable {
    @Override
    public void run() {
        Test01 test01 = new Test01();
        test01.m();
    }


}
