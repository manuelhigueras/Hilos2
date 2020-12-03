/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threads.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Fichero implements Runnable{
    
    private File archivo;
        
    public Fichero(String name){
        File url = new File("src/main/java/com/datosFichero");
        this.archivo = new File(url,name);
    }
    
    public void existeFile(){
        //CONDICIONES DEL DIR 
        if(! this.archivo.exists() ){
            System.out.println("no existe. Ya se ha creado");
            try {
                this.archivo.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else{
            System.out.printf("El directorio %s, ya existe", this.archivo.getName());
        }
    }
    
    public void numeroAlDoscientos() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(this.archivo);
            //Escribiendo en el fichero
            int cont = 2;
            while(cont <= 200){
                fw.write(""+cont+"\n");
                cont = cont + 2;
            }
            fw.close();
        }
        catch(IOException e){
            System.out.println("No se ha podido escribir");
        }
        finally {
            if(fw != null) 
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public void numerosDelCuatroAlDos(){
        int cont = 400;
        
        while(cont >= 200){
            if(cont % 2 == 0){
                cont -= 1; 
            }
            else{
                cont -= 2;
            }
            System.out.println(cont);
        }
        
    }

    @Override
    public void run() {
        existeFile();
        numeroAlDoscientos();
    }
    
}
