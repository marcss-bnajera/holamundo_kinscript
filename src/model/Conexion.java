package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;
    private Connection conexion;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/DBconexionGuitarras?useSSL=false";
    private static final String user = "quinto";
    private static final String password = "admin";
    private static final String driver = "com.mysql.jdbc.Driver";

    public Conexion(){
        conectar();
    }

    public void conectar(){
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(URL, user, password);
            System.out.println("model.Conexion exitosa");
        }catch (ClassNotFoundException|InstantiationException|
                IllegalAccessException|SQLException ex) {
            System.out.println("Error al conectar");
            ex.printStackTrace();
        }
    }

    public static Conexion getInstancia() {
        if ( instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }
        } catch (SQLException eX) {
            eX.printStackTrace();
        }
        return conexion;
    }
}