/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.threads;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new Work());
        th1.start();
        Work1 th2 = new Work1();
        th2.start();
        for (int i = 0; i < 100000; i++) {
            //Thread.sleep(1000);
            System.out.println("------main--------" + i);
        }
    }
}

class Work implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("*****work*******" + i);
        }
    }

}

class Work1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("================work1=======" + i);
        }
    }
    
}
