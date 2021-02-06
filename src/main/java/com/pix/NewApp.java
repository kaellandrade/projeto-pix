package com.pix;

import com.gui.Abertura;
import javax.swing.JFrame;

public class NewApp {
    public static void main(String[] args) {
        Abertura abertura = new Abertura();
        abertura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        abertura.setVisible(true);
    }
}       