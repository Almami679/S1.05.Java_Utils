package Nivell1.Ex2.Modules;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static Nivell1.Ex2.Main.Main.nombresArchivosOrdenados;

public class GestionDeArchivos {
    static int nivel = 1;
    static String divisor = "\\";

    public static ArrayList<String> totalDirectorios = new ArrayList<>();
    private static ArrayList<String> directorios = new ArrayList<>();


    public static void volcadoDeDirectorio() throws IndexOutOfBoundsException {

        for (int pos = 0; pos < totalDirectorios.size(); pos++) {

            File ruta = new File(totalDirectorios.get(pos));

            if (ruta.isDirectory()) {
                String[] listado = ruta.list();
                if (listado != null) {
                    directorios.addAll(List.of(listado));
                    recorrerDirectorios(ruta, pos);
                }
            }
            if (ruta.isFile()) {
                guardarArchivo(ruta.getName(), obtenerFechaUltimaModificacion(ruta));

            }

            removePath(pos);
            imprimirArchivos();
            nombresArchivosOrdenados.clear();

        }

        if (!totalDirectorios.isEmpty()) {
            nivel--;
            volcadoDeDirectorio();
        }

    }

    private static void guardarDirectorio(String name, String fecha) {
        nombresArchivosOrdenados.add("------------------------------------------\n" +
                                    name + ": [Directory]" + " (Level " + nivel + ")\n" + fecha);
    }

    private static void guardarArchivo(String name, String fecha) {
        nombresArchivosOrdenados.add("------------------------------------------\n" +
                                    name + ": [File]" + " (Level " + nivel + ")\n" + fecha);
    }

    private static void removePath(int pos) {
        totalDirectorios.remove(pos);
    }

    private static String obtenerFechaUltimaModificacion(File file) {
        var fecha = new Date(file.lastModified());
        return fecha.toString();
    }


    private static void recorrerDirectorios(File file, int pos) {

        for (String directorio : directorios) {
            totalDirectorios.add(totalDirectorios.get(pos) + divisor + directorio);
            guardarDirectorio(directorio, obtenerFechaUltimaModificacion(file));

        }
        directorios.clear();
    }

    private static void imprimirArchivos() {
        Collections.sort(nombresArchivosOrdenados);
        for (String nombre : nombresArchivosOrdenados) {
            System.out.println(nombre);
        }
    }
}
