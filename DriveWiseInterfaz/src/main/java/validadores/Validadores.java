/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JoseH
 */
public class Validadores {
    
    public boolean validarNumSerie(String numSerie) {
        /*
        String patronPlaca = "^[A-Z]{3}-\\d{3}$";
        Pattern pattern = Pattern.compile(patronPlaca);
        Matcher matcher = pattern.matcher(numSerie);
        
        if (matcher.matches()){
            return true;
        }
        
        return false;*/
        return true; //EL FORMATO CAMBIA SEGUN LA MARCA
    }

    public boolean validarString(String cadena){
        String patronString = "^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(patronString);
        Matcher matcher = pattern.matcher(cadena);
        
        if (matcher.matches()){
            return true;
        }
        
        return false;
    }
    
    public boolean validarRfc(String rfc){
        /*
        String patronString = "^[A-Z]{3}\\d{3}$";
        Pattern pattern = Pattern.compile(patronString);
        Matcher matcher = pattern.matcher(rfc);
        
        if (matcher.matches()){
            return true;
        }
        
        return false;*/
        return true; //EL FORMATO CAMBIA SEGUN EL PAIS
    }
    
}
