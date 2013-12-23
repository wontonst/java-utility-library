/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wontonst.util.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Templated thread safe producer-consumer list. NOT FINISHED IMPLEMENTING.
 *
 * @author RoyZheng
 */
public class BlockingList<T> implements List<T> {

    Semaphore sema = new Semaphore(1);
    Semaphore size = new Semaphore(0);
    List<T> data;

    public BlockingList(List<T> l) {
        this.data = l;
    }

    private void acquire() {
        try {
            sema.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(BlockingList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void release() {
        sema.release();
    }

    public void push(T o) {
        this.data.add(o);
    }
/*
    public T popInstant() throws Exception {
        acquire();
    }

    public T popBlocking() {
        acquire();

        release();
    }
*/
    @Override
    public int size() {
        acquire();
        int d = data.size();
        release();
        return d;
    }

    @Override
    public boolean isEmpty() {
        acquire();
        boolean ise = this.data.isEmpty();
        release();
        return ise;
    }

    @Override
    public boolean contains(Object o) {
        acquire();
        boolean d = this.data.contains(o);
        release();
        return d;
    }

    @Override
    public Iterator iterator() {
        return this.data.iterator();
    }

    @Override
    public Object[] toArray() {
        acquire();
        Object[] a = this.data.toArray();
        release();
        return a;
    }

    @Override
    public Object[] toArray(Object[] a) {
        acquire();
        Object[] al = this.data.toArray(a);
        release();
        return a;
    }

    @Override
    public boolean add(T e) {
        acquire();
        boolean a = this.data.add(e);
        release();
        return a;
    }

    @Override
    public boolean remove(Object o) {
        acquire();
        boolean a = this.data.remove(o);
        release();
        return a;
    }

    @Override
    public boolean containsAll(Collection c) {
        acquire();
        boolean a = this.data.containsAll(c);
        release();
        return a;
    }

    @Override
    public boolean addAll(Collection c) {
        acquire();
        boolean a = this.data.addAll(c);
        release();
        return a;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        acquire();
        boolean a = this.data.addAll(index, c);
        release();
        return a;
    }

    @Override
    public boolean removeAll(Collection c) {
        acquire();
        boolean a = this.removeAll(c);
        release();
        return a;
    }

    @Override
    public boolean retainAll(Collection c) {
        acquire();
        boolean a = this.removeAll(c);
        release();
        return a;
    }

    @Override
    public void clear() {
        acquire();
        this.data.clear();
        release();
    }

    @Override
    public T get(int index) {
        acquire();
        T a = this.data.get(index);
        release();
        return a;
    }

    @Override
    public T set(int index, T element) {
        acquire();
        T a = this.data.set(index, element);
        release();
        return a;
    }

    @Override
    public void add(int index, Object element) {
        acquire();
        this.data.add(index, (T) element);
        release();
    }

    @Override
    public T remove(int index) {
        acquire();
        T o = this.data.remove(index);
        release();
        return o;
    }

    @Override
    public int indexOf(Object o) {
        acquire();
        int i = this.data.indexOf(o);
        release();
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        acquire();
        int d = this.data.lastIndexOf(o);
        release();
        return d;
    }

    @Override
    public ListIterator listIterator() {
        return this.data.listIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return this.data.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        acquire();
        List sl = this.data.subList(fromIndex, toIndex);
        release();
        return sl;
    }
}
