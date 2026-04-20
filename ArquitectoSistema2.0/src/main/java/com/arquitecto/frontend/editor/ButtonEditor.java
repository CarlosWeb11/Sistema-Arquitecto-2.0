/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.editor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Carlos Daniel
 */
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JToggleButton button;
    private JTable table;
    private int currentRow;
    private int currentColumn;
    private boolean currentValue;
    private boolean[] estados;
    public ButtonEditor(JTable table, boolean[] estados) {
        this.estados = estados;
        this.table = table;
        button = new JToggleButton();
        button.setOpaque(true);
        button.addActionListener(this);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        
        this.currentRow = row;
        this.currentColumn = column;
        
        if (value instanceof Boolean) {
            currentValue = (Boolean) value;
            button.setSelected(currentValue);
        }
        
        // Actualizar texto y color según estado
        if (button.isSelected()) {
            button.setText("Eliminar");
            button.setBackground(Color.RED);
            button.setForeground(Color.WHITE);
        } else {
            button.setText("Agregar");
            button.setBackground(Color.GREEN);
            button.setForeground(Color.BLACK);
        }
        
        return button;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        currentValue = button.isSelected();
        
        // Actualizar la tabla
        table.setValueAt(currentValue, currentRow, table.getColumnCount() - 1);
        
        // 🔴 ACTUALIZAR EL ARREGLO ORIGINAL 🔴
        if (currentRow < estados.length) {
            estados[currentRow] = currentValue;
        }
        
        // Mostrar en consola
        if (currentValue) {
            System.out.println("AGREGAR - Fila: " + currentRow);
        } else {
            System.out.println("ELIMINAR - Fila: " + currentRow);
        }
        
        fireEditingStopped();
    }
    
    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }
    
    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;  // La celda es editable (se puede hacer clic)
    }
    
}
