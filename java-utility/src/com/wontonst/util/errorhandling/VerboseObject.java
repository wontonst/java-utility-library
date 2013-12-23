/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wontonst.util.errorhandling;

/**
 * Class that prints to the console.
 * @author RoyZheng
 */
public class VerboseObject implements IPrinter {

    int verbose = 1;
    String name = "";

    public VerboseObject() {
    }

    public VerboseObject(String name) {
        this.name = name;
    }

    public void print(String s) {
        if (this.verbose != 0) {
            System.out.print((name.isEmpty() ? "" : name+": ") + s);
        }
    }

    public void println(String s) {
        this.print(s + "\n");
    }

    public void setVerbosity(int i) {
        this.verbose = i;
    }
}
