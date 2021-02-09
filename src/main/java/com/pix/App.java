package com.pix;

import java.util.Collection;
import java.util.Map;

import com.bancocentral.Pix;
import com.bancocentral.PortalTransparencia;
import com.gui.*;
import javax.swing.JFrame;
import javax.swing.text.StyledEditorKit;

import com.pessoa.Cliente;
import com.pessoa.ClientePessoaFisica;
import com.pessoa.ClientePessoaJuridica;
import com.backend.*;
import com.banco.*;

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
