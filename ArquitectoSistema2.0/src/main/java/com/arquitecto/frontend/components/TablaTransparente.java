/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Carlos Daniel
 */
public class TablaTransparente extends JTable {

    public TablaTransparente() {
        hacerTransparente();
    }

    private void hacerTransparente() {

        // Tabla
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer) getDefaultRenderer(Object.class)).setOpaque(false);
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setRowHeight(35);
        
        // Header
        getTableHeader().setOpaque(false);
        getTableHeader().setBackground(new Color(0, 0, 0, 0));
        
        // Header renderer transparente
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                label.setOpaque(false);
                return label;
            }
        });
    } 
    
   
}
