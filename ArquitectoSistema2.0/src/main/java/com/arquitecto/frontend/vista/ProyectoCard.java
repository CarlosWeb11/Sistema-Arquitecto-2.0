/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.vista;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Daniel
 */
public class ProyectoCard extends JPanel {

    public ProyectoCard(String nombre, String fecha, String presupuesto) {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Info
        JLabel lblNombre = new JLabel(nombre);
        JLabel lblFecha = new JLabel("Última modificación: " + fecha);
        JLabel lblPresupuesto = new JLabel("Presupuesto: " + presupuesto);

        JPanel info = new JPanel(new GridLayout(3, 1));
        info.add(lblNombre);
        info.add(lblFecha);
        info.add(lblPresupuesto);

        // Botones
        JButton btnEditar = new JButton(new FlatSVGIcon("icons/editar.svg", 16, 16));
        JButton btnEliminar = new JButton(new FlatSVGIcon("icons/eliminar.svg", 16, 16));

        JPanel acciones = new JPanel();
        acciones.add(btnEditar);
        acciones.add(btnEliminar);

        add(info, BorderLayout.CENTER);
        add(acciones, BorderLayout.EAST);
    }

}
