/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import org.springframework.stereotype.Component;

/**
 *
 * @author Carlos Daniel
 */

@Component
public class BotonPrimario extends JButton {
    
    private String texto;
    
    public BotonPrimario() {
        configurarEstilo();
    }
    
    public BotonPrimario(String texto) {
        this.texto = texto;
        configurarEstilo();
    }
    
    private void configurarEstilo() {
         // Color azul brillante del fondo
        setBackground(new Color(30, 120, 255));
        setForeground(Color.WHITE);

        // Fuente
        setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Quitar bordes y efectos default de Swing
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(true);

        // Cursor de manita al pasar encima
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Padding interno
        setMargin(new Insets(8, 16, 8, 16));

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
