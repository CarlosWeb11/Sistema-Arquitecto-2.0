/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author Carlos Daniel
 */
public class TabbedPaneTransparente extends JTabbedPane {
    public TabbedPaneTransparente() {
        hacerTransparente();
    }
    
    private void hacerTransparente() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        UIManager.put("TabbedPane.contentAreaColor", new Color(0, 0, 0, 0));
        UIManager.put("TabbedPane.background", new Color(0, 0, 0, 0));
    }
    
}
