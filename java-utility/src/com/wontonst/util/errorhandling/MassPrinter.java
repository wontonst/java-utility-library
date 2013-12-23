/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wontonst.util.errorhandling;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Thread safe printer that prints out to multiple printers. Contains methods of
 * identifying printers and printing to those only.
 *
 * @author RoyZheng
 */
public class MassPrinter implements IPrinter {

    class InternalPrinter {

        InternalPrinter(IPrinter i) {
            this.printer = i;
            this.hasCategory = false;
        }

        InternalPrinter(IPrinter i, int type) {
            this.printer = i;
            this.category = type;
            this.hasCategory = true;
        }
        IPrinter printer;
        boolean hasCategory;
        int category;
    }
    List<InternalPrinter> ip;

    /**
     * Create using a list of printers. Note that this does not allow the
     * addition of identification.
     *
     * @param printerlist list of printers to print to
     */
    public MassPrinter(List<IPrinter> printerlist) {
        this.ip = new ArrayList<InternalPrinter>();
        for (IPrinter i : printerlist) {
            this.ip.add(new InternalPrinter(i));
        }
    }

    public MassPrinter() {
        this.ip = new ArrayList<InternalPrinter>();
    }

    /**
     * Add a new printer to print messages to.
     *
     * @param i the printer to print to
     */
    public void addPrinter(IPrinter i) {
        this.ip.add(new InternalPrinter(i));
    }

    /**
     * Add a new printer to print messages to and tag it with a category.
     *
     * @param i the printer to print to
     * @param category category of the printer
     */
    public void addPrinter(IPrinter i, int category) {
        this.ip.add(new InternalPrinter(i, category));
    }

    /**
     * Print the string to all printers with the integer identifiers.
     *
     * @param s string to print
     * @param types list of printer id to print to
     */
    public void println(String s, List<Integer> types) {
        this.print(s + "\n", types);
    }

    /**
     * Print the string to all printers with the integer identifiers.
     *
     * @param s string to print
     * @param types list of printer id to print to
     */
    public void print(String s, List<Integer> types) {
        for (Integer i : types) {
            this.print(s, i);
        }
    }

    /**
     * Print the string to all printers with the printer identifier.
     *
     * @param s string to print
     * @param type id of printers to print
     */
    public void print(String s, int type) {
        InternalPrinter[] arr = (InternalPrinter[]) this.ip.toArray(new InternalPrinter[this.ip.size()]);
        for (InternalPrinter i : arr) {
            if (i.category == type) {
                i.printer.print(s);
            }
        }
    }

    /**
     * Print the string to all printers with the printer identifier.
     *
     * @param s string to print
     * @param type id of printers to print
     */
    public void println(String s, int type) {
        this.print(s + "\n", type);
    }

    /**
     * Prints on all printers the given string
     *
     * @param s string to print
     */
    @Override
    public void print(String s) {
        InternalPrinter[] arr = (InternalPrinter[]) this.ip.toArray(new InternalPrinter[this.ip.size()]);
        for (InternalPrinter i : arr) {
            i.printer.print(s);
        }
    }

    /**
     * Prints on all printers the given string
     *
     * @param s string to print
     */
    @Override
    public void println(String s) {
        InternalPrinter[] arr = (InternalPrinter[]) this.ip.toArray(new InternalPrinter[this.ip.size()]);
        for (InternalPrinter i : arr) {
            i.printer.println(s);
        }
    }
}
