package controlador;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import modelo.*;

public class Negocio implements interfaces.INterfac {

    @Override
    public List<Artefacto> listArtefac() {

        List<Artefacto> lis = new ArrayList();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT a.nomart\n"
                    + "FROM artefacto a";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Artefacto a = new Artefacto();
                a.setNomart(rs.getString(1));
                lis.add(a);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;

    }

    @Override
    public int registrarVenta(Ventas ep) {

        int resp = 0;
        Connection conn = null;

        try {

            String sql = "insert into venta (codart,cliente,meses) values (?,?,?)";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);

            st.setInt(1, ep.getCodart());
            st.setString(2, ep.getNomcli());
            st.setInt(3, ep.getMeses());

            resp = st.executeUpdate();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Producto ya comprado, elija otra");

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e2) {

            }
        }

        return resp;
    }

    @Override
    public List<Artefacto_Venta> listVentas(String nro1, String nro2) {

        List<Artefacto_Venta> lis = new ArrayList<>();
        Connection conn = null;

        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT v.nrofac,v.cliente,a.nomart,a.preart,v.meses\n"
                    + "FROM venta v, artefacto a\n"
                    + "WHERE v.codart = a.codart \n"
                    + "AND v.nrofac BETWEEN ? AND ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nro1);
            st.setString(2, nro2);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Artefacto_Venta a = new Artefacto_Venta();
                a.setNroventa(rs.getInt(1));
                a.setNomcli(rs.getString(2));
                a.setNomart(rs.getString(3));
                a.setPrecio(rs.getInt(4));
                a.setMeses(rs.getInt(5));
                lis.add(a);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {

            }
        }

        return lis;

    }

    @Override
    public List<Artefacto> devolvercodArt(String nom) {

        List<Artefacto> lis = new ArrayList();
        Connection conn = null;

        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT a.codart FROM artefacto a WHERE a.nomart=?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nom);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Artefacto a = new Artefacto();
                a.setCodart(rs.getInt(1));

                lis.add(a);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {

                    conn.close();
                }
            } catch (Exception e2) {

            }
        }

        return lis;

    }

}
