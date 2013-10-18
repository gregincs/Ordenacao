/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thesaurusPerfis;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.terrier.applications.desktop.DesktopTerrier;

/**
 *
 * @author greg
 */
public class Perfil {

    public static double perfil;
    
    /**
     * faz a chamada para o peso da automotiva
     *
     * @return peso
     */
    public static double pesoEngAutomotiva() {
        return PesoPerfil.determinaPesoAuto();
    }
    
    public static double pesoEngEletronica(){
        return PesoPerfil.determinaPesoEle();
    }
    
    public static double pesoEngEnergia(){
        return PesoPerfil.determinaPesoEne();
    }
    
    public static double pesoEngSoftware(){
        return PesoPerfil.determinaPesoSof();
    }
    
    public static double pesoSemPerfil(){
        return PesoPerfil.semPerfil();
    }

    public static double pegaPesoPerfis() {
        switch (DesktopTerrier.pegaIndicePerfil()) {
            //sem perfil
            case 0:
                return perfil = pesoSemPerfil();
            //sem pefil
            case 1:
                return perfil = pesoSemPerfil();
            //engenharia automotiva
            case 2:
                return perfil = pesoEngAutomotiva();
            //engenharia eletronica
            case 3:
                return perfil = pesoEngEletronica();
            //engenharia de energia
            case 4: 
                return perfil = pesoEngEnergia();
            //engenharia de software
            case 5:
                return perfil = pesoEngSoftware();
        }
        return perfil;
    }
}
