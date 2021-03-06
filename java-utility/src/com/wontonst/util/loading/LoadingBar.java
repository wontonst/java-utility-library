/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wontonst.util.loading;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * @brief Simple graphical loading bar.
 * @author YiWei Roy Zheng
 */
public class LoadingBar extends JFrame {

    public Color color = Color.RED;
    public static final Integer width = 890;
    public static final Integer height = 60;
    Integer current;///<current progress
    Integer max;///<needed for completion

    public LoadingBar() {
        this.current = 0;
        this.max = 100;
        this.construct();
    }

    public LoadingBar(int curr, int max) {
        this.current = curr;
        this.max = max;
        this.construct();
    }

    public LoadingBar(int max) {
        this.current = 0;
        this.max = max;
        this.construct();
    }
    private boolean percent = false;

    /**
     * Get the value of percent
     *
     * @return the value of percent
     */
    public boolean isPercent() {
        return percent;
    }

    /**
     * Set the value of percent
     *
     * @param percent new value of percent
     */
    public void setPercent(boolean percent) {
        this.percent = percent;
    }

    public void construct() {
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(LoadingBar.width + 15, LoadingBar.height + 38);
        this.setLocation();
        this.repaint();
    }

    public void showBar() {
        this.setVisible(true);
    }

    public void hideBar() {
        this.setVisible(false);
    }

    private void setLocation() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setLocation((int) (dim.getWidth() / 2 - LoadingBar.width / 2), (int) (dim.getHeight() / 2 - LoadingBar.height / 2));
    }

    /**
     * Increase by 1.
     */
    public void increase() {
        this.increase(1);
    }

    public void increase(Integer num) {
        this.current += num;
        if (this.current >= this.max) {
            System.out.println("Warning: attempting to increase loading bar beyond 100%");
            this.current = max;
        }
        this.repaint();
    }

    public int getCurrent() {
        return this.current;
    }

    public double getCurrentAsPercent() {
        return this.current * 100 / this.max;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.BLACK);
        g2.fillRect(8, 39, this.width, this.height);
        g2.setColor(Color.WHITE);
        g2.fillRect(13, 43, this.width - 10, this.height - 10);
        g2.setColor(this.color);
        g2.fillRect(13, 43, ((this.width - 10) * this.current) / this.max, this.height - 10);
        g2.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.PLAIN, 18);
        g2.setFont(font);
        if (this.isPercent()) {
            g2.drawString(Integer.toString(100 * this.current / this.max) + "/" + 100, 375, 75);
        } else {
            g2.drawString(Integer.toString(this.current) + "/" + Integer.toString(this.max), 375, 75);
        }
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    public static void main(String[] args) {
        LoadingBar bar = new LoadingBar(200);
        bar.setPercent(true);
        for (int i = 0; i != 20; i++) {
            try {
                Thread.sleep(1000);
                bar.increase(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoadingBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
