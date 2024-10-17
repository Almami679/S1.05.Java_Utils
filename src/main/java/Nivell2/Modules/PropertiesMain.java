package Nivell2.Modules;

import java.io.*;
import java.util.Properties;

public final class PropertiesMain {

    private static final Properties prop= new Properties();

    public PropertiesMain(){}

    private static final String propertiesPathFile = "resources" + File.separator + "config.properties";

    public static String obtenerProperties(){
        String path = "C:"; //valor por defecto

        try {
            prop.load(new FileReader(propertiesPathFile));

            path = (String) prop.get("ABSOLUTE_PATH");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return path;

    }

    public static void modificarPropertie(ArchivosTxtNivel2 txt, int loop){
        try {
            prop.load(new FileReader(propertiesPathFile));

            if(loop > 0) {
                prop.setProperty("NAME_FILE_" + loop, txt.getNombre());
                prop.setProperty("PATH_FILE_" + loop, txt.getPath());

            } else {
                prop.setProperty("NAME_FILE", txt.getNombre());
                prop.setProperty("PATH_FILE", txt.getPath());
            }
            prop.store(new FileWriter(propertiesPathFile),"archivos txt encontrados");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
