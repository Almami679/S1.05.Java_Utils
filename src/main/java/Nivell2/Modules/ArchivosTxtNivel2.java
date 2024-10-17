package Nivell2.Modules;

import java.io.Serializable;


public class ArchivosTxtNivel2 implements Serializable {

    String nombre;
    String path;

    public ArchivosTxtNivel2(String nombre, String path) {
        this.nombre = nombre;
        this.path = path;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPath() {
        return this.path;
    }


}
