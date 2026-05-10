package com.practice.multithreading;

public class RunnableExample {
    static class TradeTask implements Runnable {
        private String tradeName;
        private int durationMs;

        TradeTask(String tradeName, int durationMs) {
            this.tradeName = tradeName;
            this.durationMs = durationMs;
        }

        @Override
        public void run() {
            System.out.println("START: " + tradeName
                    + " [thread: " + Thread.currentThread().getName() + "]");
            try { Thread.sleep(durationMs); } catch (InterruptedException e) {}
            System.out.println("DONE:  " + tradeName + " after " + durationMs + "ms");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Old style — using a class
        Thread t1 = new Thread(new TradeTask("AAPL Buy Order",  1000));
        Thread t2 = new Thread(new TradeTask("MSFT Sell Order",  700));

        // Modern style — using a lambda (same thing, less code)
        Thread t3 = new Thread(() -> {
            System.out.println("START: GOOGL Limit Order [lambda thread]");
            try { Thread.sleep(500); } catch (InterruptedException e) {}
            System.out.println("DONE:  GOOGL Limit Order");
        });

        t1.start();
        t2.start();
        t3.start();

        // Wait for all to finish before main exits
        t1.join();
        t2.join();
        t3.join();

        System.out.println("All trades submitted.");
    }
}
