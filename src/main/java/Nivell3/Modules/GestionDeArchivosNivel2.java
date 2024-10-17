package Nivell3.Modules;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Nivell3.Main.Main.archivosTxt;
import static Nivell3.Main.Main.nombresArchivosOrdenados;


public class GestionDeArchivosNivel2 {

    static int nivel = 1;
    static String divisor = "\\";
    public GestionDeArchivosNivel2(){}

    public static ArrayList<String> totalDirectorios = new ArrayList<>();
    private static ArrayList<String> directorios = new ArrayList<>();



    public static void volcadoDeDirectorio() throws IndexOutOfBoundsException{

        for(int pos = 0; pos < totalDirectorios.size(); pos++) {

            File ruta = new File(totalDirectorios.get(pos));

            if (ruta.isDirectory()) {
                String[] listado = ruta.list();
                if(listado != null) {
                    directorios.addAll(List.of(listado));
                    recorrerDirectorios(ruta, pos);
                }
            }
            if (ruta.isFile()) {
                guardarArchivo(ruta.getName(), obtenerFechaUltimaModificacion(ruta));
                String[] extension = ruta.getName().split("\\.");
                try {
                    if (extension[1].equalsIgnoreCase("txt")) {
                        archivosTxt.add(new ArchivosTxtNivel2(ruta.getName(), ruta.getPath()));
                    }
                } catch (IndexOutOfBoundsException e) {
//                    System.out.println("archivo " + ruta.getName() + " sin una extension clara");
                }
            }

            removePath(pos);

        }

        if(!totalDirectorios.isEmpty()) {
            nivel--;
            volcadoDeDirectorio();
        }

    }

    private static void guardarDirectorio(String name, String fecha) {
        nombresArchivosOrdenados.add(name + ": [Directory]" + " (Level " + nivel + ")\n" + fecha);
    }

    private static void guardarArchivo(String name, String fecha) {
        nombresArchivosOrdenados.add(name + ": [File]" + " (Level " + nivel + ")\n" + fecha);
    }

    private static void removePath(int pos) {
        totalDirectorios.remove(pos);
    }

    private static String obtenerFechaUltimaModificacion(File file) {
        var fecha = new Date(file.lastModified());
        return fecha.toString();
    }


    private static void recorrerDirectorios(File file, int pos){

        for (String directorio : directorios) {
            totalDirectorios.add(totalDirectorios.get(pos) + divisor + directorio);
            guardarDirectorio(directorio, obtenerFechaUltimaModificacion(file));

        }
        directorios.clear();
    }

    public static void crearArchivo(String archivo, String nombre) {
        try{
            File file=new File(nombre);
            if(file.createNewFile()){
                System.out.println("Archivo " + file.getName() + " ya existente");
            }
            FileWriter fw= new FileWriter(nombre,true);
            fw.write(archivo);
            fw.write("\n------------------------------------------\n");
            fw.close();

        }catch(Exception e){
            System.out.println("Error inesperado" + e.getMessage());
        }

    }
}

