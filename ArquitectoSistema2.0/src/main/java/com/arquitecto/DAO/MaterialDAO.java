package com.arquitecto.DAO;

import com.arquitecto.model.Material;
import database.database;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class MaterialDAO {

    public void insertar(Material c) {
        String sql = "INSERT INTO CATEGORIAMATERIAL"
                + "(CAT_NOMBRE, CAT_UNIDAD1, CAT_PU, CAT_UNIDAD2, CAT_PU2, CAT_CATEGORIA, CAT_PESO_TEORICO) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getUnidad1());
            ps.setDouble(3, c.getPu());
            ps.setString(4, c.getUnidad2());
            ps.setDouble(5, c.getPu2());
            ps.setString(6, c.getCategoria());
            ps.setDouble(7, c.getPeso_teorico()); // ✅
            ps.executeUpdate();
            System.out.println("Guardado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Material> listar() {
        List<Material> lista = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIAMATERIAL";

        try (Connection conn = database.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Material c = new Material();
                c.setId(rs.getInt("CAT_ID"));
                c.setNombre(rs.getString("CAT_NOMBRE"));
                c.setUnidad1(rs.getString("CAT_UNIDAD1"));
                c.setPu(rs.getDouble("CAT_PU"));
                c.setUnidad2(rs.getString("CAT_UNIDAD2"));
                c.setPu2(rs.getDouble("CAT_PU2"));
                c.setPeso_teorico(rs.getDouble("CAT_PESO_TEORICO")); // ✅
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM CATEGORIAMATERIAL WHERE CAT_ID = ?";
        try (Connection conn = database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Material c) {
        String sql = "UPDATE CATEGORIAMATERIAL SET "
                + "CAT_NOMBRE = ?, "
                + "CAT_UNIDAD1 = ?, "
                + "CAT_PU = ?, "
                + "CAT_UNIDAD2 = ?, "
                + "CAT_PU2 = ?, "
                + "CAT_PESO_TEORICO = ? " // ✅
                + "WHERE CAT_ID = ?";

        try (Connection conn = database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getUnidad1());
            ps.setDouble(3, c.getPu());
            ps.setString(4, c.getUnidad2());
            ps.setDouble(5, c.getPu2());
            ps.setDouble(6, c.getPeso_teorico()); // ✅
            ps.setInt(7, c.getId());
            ps.executeUpdate();
            System.out.println("Actualizado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarTodo() {
        String sql = "DELETE FROM CATEGORIAMATERIAL";
        try (Connection conn = database.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Material> listarCategoria(String categoria) {
        List<Material> lista = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIAMATERIAL WHERE CAT_CATEGORIA = ?";

        try (Connection conn = database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, categoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Material c = new Material();
                    c.setId(rs.getInt("CAT_ID"));
                    c.setNombre(rs.getString("CAT_NOMBRE"));
                    c.setUnidad1(rs.getString("CAT_UNIDAD1"));
                    c.setPu(rs.getDouble("CAT_PU"));
                    c.setUnidad2(rs.getString("CAT_UNIDAD2"));
                    c.setPu2(rs.getDouble("CAT_PU2"));
                    c.setCategoria(rs.getString("CAT_CATEGORIA"));
                    c.setPeso_teorico(rs.getDouble("CAT_PESO_TEORICO")); // ✅
                    lista.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Material buscarPorNombre(String nombre) {
    String sql = "SELECT * FROM CATEGORIAMATERIAL WHERE CAT_NOMBRE = ?";
    try (Connection conn = database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nombre);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Material c = new Material();
                c.setId(rs.getInt("CAT_ID"));
                c.setNombre(rs.getString("CAT_NOMBRE"));
                c.setUnidad1(rs.getString("CAT_UNIDAD1"));
                c.setPu(rs.getDouble("CAT_PU"));
                c.setUnidad2(rs.getString("CAT_UNIDAD2"));
                c.setPu2(rs.getDouble("CAT_PU2"));
                c.setCategoria(rs.getString("CAT_CATEGORIA"));
                c.setPeso_teorico(rs.getDouble("CAT_PESO_TEORICO"));
                return c;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // si no encuentra nada
}
}