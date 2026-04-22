/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Daniel
 */
public class PanelFondo extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Gradiente radial del centro hacia las esquinas
        RadialGradientPaint gradiente = new RadialGradientPaint(
            getWidth() / 2f, getHeight() / 2f,  // centro
            getWidth() * 0.8f,                   // radio
            new float[]{0f, 1f},                 // posiciones
            new Color[]{
                new Color(38, 38, 45),           // centro más claro
                new Color(15, 15, 18)            // bordes más oscuros
            }
        );
        
        g2d.setPaint(gradiente);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    
}
