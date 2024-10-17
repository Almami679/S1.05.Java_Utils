package Nivell1.Ex4.Modules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

public class ArchivosTxt implements Serializable {

    String nombre;
    String path;

    public ArchivosTxt(String nombre, String path) {
        this.nombre = nombre;
        this.path = path;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPath() {
        return this.path;
    }

    public static void leerArchivo(String path) {
        try {
            File fichero = new File(path);
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error inesperado" + e.getMessage());
        }
    }

}
