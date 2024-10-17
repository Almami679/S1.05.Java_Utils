package Nivell1.Ex4.Modules;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static Nivell1.Ex4.Main.Main.archivosTxt;
import static Nivell1.Ex4.Main.Main.nombresArchivosOrdenados;


public class GestionDeArchivos {
    static int nivel = 1;
    static String divisor = "\\";
    public GestionDeArchivos(){}

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
                        archivosTxt.add(new ArchivosTxt(ruta.getName(), ruta.getPath()));
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("archivo " + ruta.getName() + " sin una extension clara");
                }

            }

            removePath(pos);
            Collections.sort(nombresArchivosOrdenados);
            for (String nombre : nombresArchivosOrdenados) {
                crearArchivo(nombre);
            }
            nombresArchivosOrdenados.clear();

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

    public static void crearArchivo(String archivo) {
        try{
            File file=new File("Historial_de_Archivos.txt");
            if(file.createNewFile()){
                System.out.println("Archivo " + file.getName() + " actualizado");
            }
            FileWriter fw= new FileWriter("Historial_de_Archivos.txt",true);
            fw.write(archivo);
            fw.write("\n------------------------------------------\n");
            fw.close();

        }catch(Exception e){
            System.out.println("Error inesperado" + e.getMessage());
        }

    }
}
