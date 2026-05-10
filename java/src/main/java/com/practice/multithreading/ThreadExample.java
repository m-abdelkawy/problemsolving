package com.practice.multithreading;

public class ThreadExample {
    static class MyThread extends Thread{
        private String taskName;
        public MyThread(String taskName) {
            this.taskName = taskName;
        }
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(taskName + " - step " + i + " [" + Thread.currentThread().getName()+ "]");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread("Trade processor");
        MyThread t2 = new MyThread("Risk Calculator");
        MyThread t3 = new MyThread("Report Generator");

        t1.start();
        t2.start();
        t3.start();
    }
}
