
package com.wontonst.util.threading;

/**
 *
 * @author RoyZheng
 */
public abstract class ThreadedObject implements Runnable {

    boolean threadRunning = false;
    Thread mythread;

    public boolean isRunning() {
        return this.threadRunning;
    }

    public void startThread() {
        if (this.threadRunning) {
            return;
        }
        this.threadRunning = true;
        this.mythread = new Thread(this);
        this.mythread.start();
    }

    public void stopThread() {
        this.threadRunning = false;
    }

    @Override
    public void run() {
        while (this.threadRunning) {
            this.perform();
        }
    }

    protected abstract void perform();
}