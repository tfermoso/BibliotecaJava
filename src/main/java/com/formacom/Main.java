package com.formacom;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] argumentos){
        Biblioteca biblioteca=new Biblioteca();
        Scanner leer = new Scanner(System.in);
        String MENU= """
                App Biblioteca
                1. Lista todos los libros.
                2. Buscar un libro por código
                3. Buscar libros por género
                4. Añadir libro a la biblioteca
                5. Eliminar libro de la biblioteca
                6. Salir
                """;
        String opcion="";
        do{
            System.out.println(MENU);
            opcion=leer.nextLine();
            switch (opcion){
                case "1":
                    System.out.println(biblioteca.toString());
                    break;
                case "2":
                    System.out.println("Introduce género:");
                    String genero=leer.nextLine();
                    List<Libro> libroList=biblioteca.searchLibrosByGenero(genero);
                    if(libroList.size()>0){
                        libroList.forEach(libro->{
                            System.out.println(libro.toString());
                        });
                    }else{
                        System.out.println("No hay libros del género "+genero);
                    }

                    break;

            }

        }while(! opcion.equals("6"));
    }
}
