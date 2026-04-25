/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Carlos Daniel
 */
public class BotonSecundario extends JButton{
   public BotonSecundario() {
        configurarEstilo();
    }
    
    public BotonSecundario(String texto) {
        super(texto);
        configurarEstilo();
    }
    
    public BotonSecundario(String texto, String rutaSvg) {
        super(texto);
        configurarEstilo();
        configurarIcono(rutaSvg);
    }
    
    private void configurarEstilo() {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setForeground(Color.WHITE);
        setMargin(new Insets(8, 16, 8, 16));
        setIconTextGap(8); // espacio entre icono y texto
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Segoe UI", Font.BOLD, 15));
    }
    
    private void configurarIcono(String rutaSvg) {
    FlatSVGIcon icono = new FlatSVGIcon(rutaSvg, 16, 16);
    icono.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE)); // ✅
    setIcon(icono);
}
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(new Color(255, 255, 255, 15));
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
        
        g2d.setColor(new Color(255, 255, 255, 40));
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 12, 12);
        
        super.paintComponent(g);
    }
    
}
