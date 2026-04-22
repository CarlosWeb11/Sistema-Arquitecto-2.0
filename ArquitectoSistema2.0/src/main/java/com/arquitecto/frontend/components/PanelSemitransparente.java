/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Daniel
 */
public class PanelSemitransparente extends JPanel{
    private int alpha;
    private int radio;
    
    public PanelSemitransparente(int alpha, int radio) {
        this.alpha = alpha;
        this.radio = radio;
        setOpaque(false); // ✅ Necesario para que funcione la transparencia
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    super.paintComponent(g); // ✅ Primero
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);
    
    // Solo esta línea, con el alpha correcto
    g2d.setColor(new Color(38, 38, 42, alpha));
    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
    
    
    }
    
}
