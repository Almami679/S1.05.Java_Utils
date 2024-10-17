package Nivell1.Ex2.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static Nivell1.Ex2.Modules.GestionDeArchivos.totalDirectorios;
import static Nivell1.Ex2.Modules.GestionDeArchivos.volcadoDeDirectorio;


public class Main {

    public static ArrayList<String> nombresArchivosOrdenados = new ArrayList<>();
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        totalDirectorios.add("C:\\Users\\almam\\OneDrive\\Documentos");
        volcadoDeDirectorio();
        Collections.sort(nombresArchivosOrdenados);
        for (String nombre : nombresArchivosOrdenados) {
            System.out.println(nombre);
        }
    }
    }
