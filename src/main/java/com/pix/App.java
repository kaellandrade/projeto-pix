package com.pix;

import com.gui.*;
import javax.swing.JFrame;

import com.backend.*;

public class App {
    public static void main(String[] args) {
        // popularDados();
        Abertura abertura = new Abertura();
        abertura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        abertura.setVisible(true);
    }

    /**
     * Captura os clientes do JSON e serializa-os. Basta executá-lo uma vez;
     */
    public static void popularDados() {
        CriaDataBase.abrirArquivo();
        CriaDataBase.populaDados();
        CriaDataBase.fechaArquivo();
    }
}
