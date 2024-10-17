package Nivell3.Modules;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Encrypt {

    public Encrypt() {
    }

    private static String LLAVE_CLAVE = "ITAcademyJavaMatins";

    public static SecretKeySpec crearClaveDeBits(String key) {

        SecretKeySpec output = null;

        try {
            byte [] cadena = key.getBytes("UTF-8");
            MessageDigest msg = MessageDigest.getInstance("SHA-1");
            cadena = Arrays.copyOf(cadena, 16);
            output = new SecretKeySpec(cadena, "AES");


        } catch (Exception e) {

        }
        return output;
    }

    public static String encriptarDato(String dato){
        String encriptado = null;
        try{
            SecretKeySpec secretKeySpec = crearClaveDeBits(LLAVE_CLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte [] cadena = dato.getBytes("UTF-8");
            byte [] encriptada = cipher.doFinal(cadena);
            encriptado = Base64.getEncoder().encodeToString(encriptada);
        } catch(Exception e){

        }
        return encriptado;
    }

    public static String desencriptarDato(String datoEncriptado){
        String desencriptado = null;
        try{
            SecretKeySpec secretKeySpec = crearClaveDeBits(LLAVE_CLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte [] cadena = Base64.getDecoder().decode(datoEncriptado);
            byte [] desencriptada = cipher.doFinal(cadena);
            desencriptado = new String(desencriptada);
        } catch(Exception e){

        }
        return desencriptado;
    }

}








































