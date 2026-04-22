/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import java.awt.Color;
import javax.swing.JScrollPane;

/**
 *
 * @author Carlos Daniel
 */
public class ScrollPanelTransparente extends JScrollPane {

    public ScrollPanelTransparente() {
        hacerTransparente();
    }

    private void hacerTransparente() {
    setOpaque(false);                           
    getViewport().setOpaque(false);             
    getViewport().setBackground(new Color(0,0,0,0));
    setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
    
}
