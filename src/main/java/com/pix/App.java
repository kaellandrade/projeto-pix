package com.pix;

import com.gui.Abertura;
import java.text.ParseException;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws ParseException {
        Abertura interfaceGrafica = new Abertura();
        //interfaceGrafica.InterfaceGraficaGBL();
        interfaceGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfaceGrafica.setSize(400,800);
        interfaceGrafica.setResizable(true);
        interfaceGrafica.setVisible(true);
    }
}
