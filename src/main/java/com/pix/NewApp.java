package com.pix;

import com.gui.NewAbertura;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class NewApp extends JFrame {

    public NewApp() {
        super("Banco XYZ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new NewAbertura());
        pack();
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new NewApp().setVisible(true);
            }
        });
    }
}
