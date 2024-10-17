package Nivell1.Ex4.Main;


import Nivell1.Ex4.Modules.ArchivosTxt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static Nivell1.Ex4.Modules.ArchivosTxt.leerArchivo;
import static Nivell1.Ex4.Modules.GestionDeArchivos.totalDirectorios;
import static Nivell1.Ex4.Modules.GestionDeArchivos.volcadoDeDirectorio;


public class Main {

    public static ArrayList<String> nombresArchivosOrdenados = new ArrayList<>();
    public static ArrayList<ArchivosTxt> archivosTxt = new ArrayList<>();
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        boolean salir = false;


        totalDirectorios.add("C:\\Users\\almam\\OneDrive\\Documentos");
        volcadoDeDirectorio();
        Collections.sort(nombresArchivosOrdenados);

        if (!archivosTxt.isEmpty()) {
            do {
                System.out.println("Se han encontrado estos ficheros");
                for (int pos = 0; pos < archivosTxt.size(); pos++) {
                    System.out.println("[" + (pos + 1) + "] " + archivosTxt.get(pos).getNombre());
                }
                System.out.println("Cual quieres abrir?\npara salir presiona [0]");
                opcion = (input.nextInt() - 1);
                if(opcion == -1) {
                    salir = true;
                }else {
                    leerArchivo(archivosTxt.get(opcion).getPath());

                }
            } while (!salir);
        }
        else{
            System.out.println("No se han encontrado archivos txt");
        }
    }
}