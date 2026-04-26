/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Carlos Daniel
 */
public class BotonLista extends JButton{
    private boolean hover = false;
    
    public BotonLista(String texto) {
        super(texto);
        configurarEstilo();
        configurarHover();
    }
    
    private void configurarEstilo() {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setHorizontalAlignment(SwingConstants.LEFT);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setForeground(Color.WHITE);
    }
    
    private void configurarHover() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (hover) {
            // Azul muy oscuro al pasar el cursor
            g2d.setColor(new Color(20, 40, 80, 150));
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
        }
        
        super.paintComponent(g);
    }
    
}
