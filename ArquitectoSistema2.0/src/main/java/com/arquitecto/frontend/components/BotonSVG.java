/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Carlos Daniel
 */
public class BotonSVG extends JButton{

    String imagen;
    int size;
    public BotonSVG(String imagen, int size) {
        this.imagen = imagen;
        this.size = size;
        editarBoton();
    }
    
    
    public void editarBoton() {
        FlatSVGIcon icono = new FlatSVGIcon("icons/"+imagen+".svg", size, size); // ancho, alto
        setIcon(icono);
        setText("");
        setBorderPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(icono.getIconWidth(), icono.getIconHeight()));
    }
    
}
