package com.campusland.utils.conexiones.conexionbdmysql;

import com.campusland.utils.Configuracion;

import java.sql.Connection;

public class ConexionBDMysql {
    private static String url = Configuracion.obtenerValor("db.url");
    private static String user = Configuracion.obtenerValor("db.username");
    private static String password = Configuracion.obtenerValor("db.password");
    private static Connection conn ;
    public static Connection getConnexion() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = java.sql.DriverManager.getConnection(url, user, password);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
