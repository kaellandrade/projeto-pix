package com.pix;

import com.gui.NewAbertura;
import java.text.ParseException;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws ParseException {
        NewAbertura interfaceGrafica = new NewAbertura();
        interfaceGrafica.interfaceGrafica();
        //interfaceGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //qinterfaceGrafica.setSize(400,800);
        //interfaceGrafica.setResizable(true);
        //interfaceGrafica.setVisible(true);
    }
}
