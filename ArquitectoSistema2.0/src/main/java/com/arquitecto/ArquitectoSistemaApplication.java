/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto;

import com.formdev.flatlaf.FlatDarkLaf;
import database.database;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author Carlos Daniel
 */
@SpringBootApplication
public class ArquitectoSistemaApplication {
    public static void main(String[] args) {


        // Tema
        FlatDarkLaf.setup();

        // Spring con UI habilitada
        ConfigurableApplicationContext context
                = new SpringApplicationBuilder(ArquitectoSistemaApplication.class)
                        .headless(false)
                        .run(args);

        // Mostrar ventana
        java.awt.EventQueue.invokeLater(() -> {
            context.getBean(com.arquitecto.frontend.vista.VentanaPrincipal.class)
                    .setVisible(true);
        });
    }

}
