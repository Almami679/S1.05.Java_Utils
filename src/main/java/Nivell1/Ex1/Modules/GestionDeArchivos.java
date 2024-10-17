package Nivell1.Ex1.Modules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static Nivell1.Ex1.Main.Main.nombresArchivosOrdenados;


public class GestionDeArchivos {
        static int nivel = 1;
        static String divisor = "\\";

        public GestionDeArchivos() {
        }

        public static ArrayList<String> totalDirectorios = new ArrayList<>();
        private static ArrayList<String> directorios = new ArrayList<>();


        public static void volcadoDeDirectorio() throws IndexOutOfBoundsException {

            for (int pos = 0; pos < totalDirectorios.size(); pos++) {

                File ruta = new File(totalDirectorios.get(pos));

                if (ruta.isDirectory()) {
                    String[] listado = ruta.list();
                    if (listado != null) {
                        nombresArchivosOrdenados.addAll(List.of(listado));
                    }
                }

            }

        }

}
