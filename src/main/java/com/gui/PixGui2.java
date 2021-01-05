/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

/**
 *
 * @author kaell
 */
//JLabels com textos e icones
import java.awt.FlowLayout; // especifica como os componentes são organizados
import javax.swing.JFrame; // fornece recursos básicos de janela
import javax.swing.JLabel; // exibe texto e imagens
import javax.swing.SwingConstants; // constantes comuns utilizadas com swing
import javax.swing.Icon; // interface utilizada para manipular imagens
import javax.swing.ImageIcon; // carrega imagens


public class PixGui2 extends JFrame {
    private final JLabel label1; // apenas com texto
    private final JLabel label2; // construido com texto e icones
    private final JLabel label3; // com texto e icone adicionados

    //    construtor LabelFrame adiciona Jlabels a JFrame
    public PixGui2(){
        super("Testando JLabel");
        setLayout(new FlowLayout()); // configura o layout de frame

    //  construtor Jlabel1 com um arquivo de string
    label1 = new JLabel("Label com texto");
    label1.setToolTipText("Este é o label 1");
    add(label1); // adiciona o label1 ao JFrame

    //    Construtor Jlabel com string, Icon e argumentos de alinhamento
    Icon banco = new ImageIcon("../projeto-pix/imgs/bcb.png");
    label2 = new JLabel("Label com texto e imagem", banco, SwingConstants.LEFT);
    label2.setToolTipText("Este é o label 2");
    add(label2); // adciona o label 2

    label3 = new JLabel(); // Construtor Jlabel sem argumentos
    label3.setText("Label com icone e texto em baixo");
    label3.setIcon(banco); // adiciona o icon ao label
    label3.setHorizontalTextPosition(SwingConstants.CENTER);
    label3.setVerticalTextPosition(SwingConstants.BOTTOM);
    label3.setToolTipText("Este é o label3");
    add(label3); //adicina o label 3
    }
}
