package Cifrado_DES;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gussr
 */
public class Cifrado {
    String resultadoC="";
String resultadoD="";
    public String Cifrar(File archivo, String key) throws Exception{
    if(archivo ==null){
    mensajeAyuda();
    System.exit(1);
    }

    SecretKey clave = new SecretKeySpec((key).getBytes(),"DES");
    Cipher cifrado = Cipher.getInstance("DES/ECB/PKCS5Padding");
    cifrado.init(Cipher.ENCRYPT_MODE, clave);
        System.out.println(clave);
    mostrarBytes(clave.getEncoded());
    byte [] buffer=new byte[1000];
    byte [] bufferCifrado;
    FileInputStream in = new FileInputStream(archivo);
    FileOutputStream out = new FileOutputStream(archivo+".cifrado");
    int bytesleidos = in.read(buffer,0, 1000);
    while(bytesleidos != -1){
    bufferCifrado = cifrado.update(buffer,0,bytesleidos);
    out.write(bufferCifrado);
    bytesleidos = in.read(buffer, 0, 1000);
    bufferCifrado = cifrado.doFinal();
    out.write(bufferCifrado);
    in.close();
    out.close();
    resultadoC = new String(bufferCifrado,java.nio.charset.StandardCharsets.UTF_8);

    }

return resultadoC;
}
    public String Descifrar (File archivo, String key) throws Exception{

    if(archivo ==null){
    mensajeAyuda();
    System.exit(1);
    }

    SecretKey clave = new SecretKeySpec((key).getBytes(),"DES");
    Cipher cifrado = Cipher.getInstance("DES/ECB/PKCS5Padding");
    cifrado.init(Cipher.DECRYPT_MODE, clave);
        System.out.println(clave);
    mostrarBytes(clave.getEncoded());
    byte [] buffer=new byte[1000];
    byte[] bufferPlano;
    FileInputStream in = new FileInputStream(archivo);
    FileOutputStream out = new FileOutputStream(archivo+".decifrado");
    int bytesleidos = in.read(buffer,0, 1000);
    while(bytesleidos != -1){
    bufferPlano = cifrado.update(buffer,0,bytesleidos);
    out.write(bufferPlano);
    bytesleidos = in.read(buffer,0,100);
    bufferPlano = cifrado.doFinal();
    in.close();
    out.close();    
    System.out.println(bufferPlano);
    resultadoD = new String(bufferPlano,java.nio.charset.StandardCharsets.UTF_8);
    }
    
    return resultadoD;

}

    private static void mensajeAyuda() {
    System.out.println("Ejemplo de un cifrado DES para archivos de txt");
    System.out.println("Cuidado la llave solo puede ser de 8 caracteres");
    System.out.println("Compruebe que esta cargado el archivo");    }
    private static void mostrarBytes(byte[] buffer) {
        System.out.write(buffer,0,buffer.length);
    }
}
