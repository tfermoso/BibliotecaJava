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

    public void addLibro(String titulo,String codigo,String genero){
        String consulta="insert into libros (titulo,codigo,genero) values (?,?,?)";
        int idLibro=0;
        Connection conn=Conexion.conectar();
        try {
            PreparedStatement stm=conn.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,titulo);
            stm.setString(2,codigo);
            stm.setString(3,genero);
            int affectedRows=stm.executeUpdate();
            if(affectedRows>0){
                ResultSet rs=stm.getGeneratedKeys();
                if(rs.next()){
                    idLibro=rs.getInt(1);
                    Libro libro=new Libro(idLibro,titulo,codigo,genero);
                    this.libros.add(libro);
                }
            }else{
                System.out.println("Error al insertar");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)  {
       Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.toString());
    }
}
