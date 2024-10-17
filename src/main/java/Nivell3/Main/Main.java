package Nivell3.Main;

import Nivell3.Modules.ArchivosTxtNivel2;

import java.util.ArrayList;
import java.util.Collections;

import static Nivell3.Modules.GestionDeArchivosNivel2.*;
import static Nivell3.Modules.PropertiesMain.modificarPropertie;
import static Nivell3.Modules.PropertiesMain.obtenerProperties;


public class Main {

    public static ArrayList<String> nombresArchivosOrdenados = new ArrayList<>();
    public static ArrayList<ArchivosTxtNivel2> archivosTxt = new ArrayList<>();
    public static String path;

    public static void main(String[] args) {
        int loop = 0;

        path = obtenerProperties();

        totalDirectorios.add(path);
        volcadoDeDirectorio();
        Collections.sort(nombresArchivosOrdenados);

        for(ArchivosTxtNivel2 txt : archivosTxt) {
            crearArchivo(txt.getPath(), "Historial_de_DocumentosTxt.txt");
            modificarPropertie(txt, loop);
            loop++;

        }

    }
}
