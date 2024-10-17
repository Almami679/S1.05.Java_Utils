package Nivell1.Ex3.Main;

import java.util.ArrayList;
import java.util.Scanner;

import static Nivell1.Ex3.Modules.GestionDeArchivos.totalDirectorios;
import static Nivell1.Ex3.Modules.GestionDeArchivos.volcadoDeDirectorio;

public class Main {

    public static ArrayList<String> nombresArchivosOrdenados = new ArrayList<>();
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        totalDirectorios.add("C:\\Users\\almam\\OneDrive\\Documentos");
        volcadoDeDirectorio();

    }
}
