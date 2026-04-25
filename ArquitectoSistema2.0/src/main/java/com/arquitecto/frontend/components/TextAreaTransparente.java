/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.components;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JTextArea;

/**
 *
 * @author Carlos Daniel
 */
public class TextAreaTransparente extends JTextArea  {

    public TextAreaTransparente() throws HeadlessException{
            hacerCambios();
    }
    
    private void hacerCambios() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
    }
}
