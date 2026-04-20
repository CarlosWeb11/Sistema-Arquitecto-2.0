/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.renders;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Carlos Daniel
 */
public class ButtonRenderer extends  JToggleButton implements TableCellRenderer{
        public ButtonRenderer() {
        setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        // value es el estado (true=eliminar, false=agregar)
        boolean estado = (value != null && (boolean) value);
        setSelected(estado);
        
        if (estado) {
            setText("Eliminar");
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } else {
            setText("Agregar");
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
        }
        
        return this;
    }
    
}
