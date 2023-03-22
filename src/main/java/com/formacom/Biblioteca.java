package com.formacom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                '}';
    }

    public Biblioteca() {
        this.libros=new ArrayList<>();
        Connection conn=Conexion.conectar();
        if(conn!=null){
            String consulta="select * from libros";
            try {
                Statement stm=conn.createStatement();
                ResultSet rs=stm.executeQuery(consulta);
                while(rs.next()){
                    Libro libro=new Libro();
                    libro.setId(rs.getInt("idlibro"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setCodigo(rs.getString("codigo"));
                    libro.setGenero(rs.getString("genero"));
                    this.libros.add(libro);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Error al conectarse a la BBDD");
        }
    }

    public static void main(String[] args)  {
       Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.toString());
    }
}
