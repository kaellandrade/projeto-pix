package com.pix;

import com.gui.Abertura;
import java.text.ParseException;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws ParseException {
        Abertura cadastroTela = new Abertura();
        cadastroTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadastroTela.setSize(430, 520);
        cadastroTela.setResizable(false);
        cadastroTela.setVisible(true);
    }
}
