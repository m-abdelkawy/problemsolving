package com.practice.multithreading;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}
