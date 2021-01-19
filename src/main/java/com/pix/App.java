package com.pix;

import javax.swing.JFrame;

import com.bancocentral.GravarDados;
import com.bancocentral.LerClientes;

import com.gui.*;

public class App {
    public static void main(String[] args) {
        /*
        // JOptionPane
        PixGui gui = new PixGui();
        gui.mostraChave();

        // JFrame (usando janelas)
        PixGui2 lababelFrame = new PixGui2();
        PixGui2 labelFrame = new PixGui2();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(300, 200);
        labelFrame.setVisible(true);
        */

        // Imprime todos os clientes intanciados a partir do arquivo CSV.

        Cliente a = LerClientes.recuperarClientesObj().get(0); //primeiro cliente
        Cliente b = LerClientes.recuperarClientesObj().get(1); // segundo cliente

        // Antes da tranferencia
        System.out.println(a);
        System.out.println(b);

        // Transferindo
        a.getConta().transferir(b.getConta(), 100);

        // Depois da tranferencia
        System.out.println(a);
        System.out.println(b);
        // grava um novo cliente no arquivo CSV
        GravarDados.cadastrarCliente(
                "PF,CC,Maria santos silva,sil@hotmail.com,00321222107190,+5572909211204,3nl46boi2hasdfasy8bjl535,0066,0031,Andre,456,1212");
    }
}
