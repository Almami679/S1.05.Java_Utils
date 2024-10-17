package Nivell3.Modules;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import static Nivell3.Modules.Encrypt.desencriptarDato;
import static Nivell3.Modules.Encrypt.encriptarDato;


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
        return desencriptarDato(path);

    }

    public static void modificarPropertie(ArchivosTxtNivel2 txt, int loop){
        try {
            prop.load(new FileReader(propertiesPathFile));

            if(loop > 0) {
                prop.setProperty("NAME_FILE_" + loop, encriptarDato(txt.getNombre()));
                prop.setProperty("PATH_FILE_" + loop, encriptarDato(txt.getPath()));

            } else {
                prop.setProperty("NAME_FILE", encriptarDato(txt.getNombre()));
                prop.setProperty("PATH_FILE", encriptarDato(txt.getPath()));
            }
            prop.store(new FileWriter(propertiesPathFile),"archivos txt encontrados");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
