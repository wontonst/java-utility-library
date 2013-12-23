/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wontonst.util.loading;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * Used for keeping track of the loading of components.
 *
 * @author RoyZheng
 */
public class MasterLoader {

    Map<Object, Integer> waits = Collections.synchronizedMap(new HashMap<Object, Integer>());
    LoadingBar gui;
    Semaphore done = new Semaphore(0);
    int leftToLoad = 0;

    public MasterLoader() {
    }

    public MasterLoader(LoadingBar gui) {
        this.gui = gui;
    }

    public void startLoadingBar() {
        if (this.gui == null) {
            return;
        }
        this.gui.showBar();
    }

    public void hideLoadingBar() {
        this.gui.hideBar();
    }

    /**
     * Register a new object with weight 1.
     *
     * @param o object that loads
     */
    public void register(Object o) {
        this.register(o, 1);
    }

    /**
     * Register a new object.
     *
     * @param o object that loads
     * @param weight weight used for loading bar
     */
    public void register(Object o, int weight) {
        if (this.waits.containsKey(o)) {
            return;
        }
        this.waits.put(o, weight);
        this.leftToLoad += weight;
    }

    public void finish(Object o) {
        this.finishPartial(o, this.waits.get(o));
    }

    public void finishPartial(Object o, int amount) {
        if (!this.waits.containsKey(o)) {
            return;
        }
        if (this.waits.get(o) == 0) {
            return;
        }
        int amt_left = this.waits.get(o);
        if (amt_left > amount) {
            amount = amt_left;
        }
        this.waits.put(o, amount);
        this.leftToLoad -= amount;
        if (this.isLoaded()) {
            this.loadingFinishedRelease();
        }
    }

    private void loadingFinishedRelease() {
        this.done.release(Integer.MAX_VALUE / 2);
    }

    public void waitUntilLoaded() throws InterruptedException {
        this.done.acquire();
        if (this.isLoaded()) {
            this.done.release();
        }
    }

    public boolean isLoaded() {
        return leftToLoad == 0;
    }
}
