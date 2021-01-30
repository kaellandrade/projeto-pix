package com.gui;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class NewAbertura extends JPanel {
    
    GridBagLayout layout;

    public NewAbertura() {
        interfaceGrafica();
    }

    public void interfaceGrafica() {
        setPreferredSize(new Dimension(300,500));
        layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Saldo"), gbc);

    }
}
