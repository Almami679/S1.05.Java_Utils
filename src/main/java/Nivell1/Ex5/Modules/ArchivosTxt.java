package Nivell1.Ex5.Modules;

import java.io.*;

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

    public static void serializarObjeto(ArchivosTxt archivo){
        try{
            ObjectOutputStream escribiendo_archivo =
                    new ObjectOutputStream(
                            new FileOutputStream("C:\\Users\\almam\\Downloads\\documento_txt.ser"));

            escribiendo_archivo.writeObject(archivo);
            System.out.println("Archivo " + archivo.getNombre() + " serializado.");
            escribiendo_archivo.close();

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deserializarObjeto(){
        try{
            ObjectInputStream contenido_recuperado =
                    new ObjectInputStream(
                            new FileInputStream("C:\\Users\\almam\\Downloads\\documento_txt.ser"));

            ArchivosTxt contenido = (ArchivosTxt) contenido_recuperado.readObject();

            System.out.println("Archivo deserializado:\n" + contenido);

            contenido_recuperado.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
