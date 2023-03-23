package com.formacom;

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


        }while(! opcion.equals("6"));
    }
}
