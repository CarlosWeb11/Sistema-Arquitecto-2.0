/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.service;

import com.arquitecto.DAO.MaterialDAO;
import com.arquitecto.model.Material;
import java.util.List;

/**
 *
 * @author Carlos Daniel
 */
public class MaterialService {
     private MaterialDAO dao = new MaterialDAO();

    // 🔵 GUARDAR
    public void guardar(Material c) {

        if (c.getNombre() == null || c.getNombre().isEmpty()) {
            System.out.println("El nombre es obligatorio");
            return;
        }
        dao.insertar(c);
    }

    // 🟢 LISTAR
    public List<Material> listar() {
        return dao.listar();
    }

    // 🟡 ACTUALIZAR
    public void actualizar(Material c) {

        if (c.getId() == 0) {
            System.out.println("ID inválido");
            return;
        }

        dao.actualizar(c);
    }

    // 🔴 ELIMINAR
    public void eliminar(int id) {

        if (id <= 0) {
            System.out.println("ID inválido");
            return;
        }

        dao.eliminar(id);
    }
    
}
