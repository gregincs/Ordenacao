/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thesaurusPerfis;

import java.util.ArrayList;
import org.terrier.applications.desktop.DesktopTerrier;

/**
 *
 * @author greg
 */
public class PesoPerfil {

    public static double peso;

    public static double getPeso() {
        return peso;
    }

    public static void setPeso(double peso) {
        PesoPerfil.peso = peso;
    }

    /**
     * determina peso da automotiva
     *
     * @return double peso
     */
    public static double determinaPesoAuto() {
        
        for(int i = 0; i < KnowledgeAreas.areas.size(); i++){
            System.out.println(DesktopTerrier.getJComboRankClass().getSelectedIndex());
            System.out.println(DesktopTerrier.allocateWModel());
            //System.out.println(KnowledgeAreas.areas.get(i));
            //System.out.println("esta aqui dentro de areas");
            for(int j = 0; j < KnowledgeAreas.areas.get(i).size(); j++){
                //System.out.println("esta aqui dentro de matematica");
                if(KnowledgeAreas.areas.get(i).get(j).contains(DesktopTerrier.pegarConsulta())){
                    //System.out.println("esta no contains");
                    if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.matematica)){
                    //    System.out.println("esta dentro de areas -> matematica");
                        //peso = 1.23;
                        peso = 100;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.fisica)){
                        //peso = 1.15;
                        peso = 1;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.quimica)){
                        peso = 1;
                        //peso = 1.06;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.computacao)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engProducao)){
                        peso = 1;
                        //peso = 1.03;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engSanitaria)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engEletrica)){
                        peso = 1;
                        //peso = 1.06;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engMecanica)){
                        peso = 1000;
                        //peso = 1.25;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engenharia)){
                        peso = 10;
                        //peso = 1.17;
                    }
                }
            }
        }

        return peso;
    
    }

    public static double semPerfil() {
        if (DesktopTerrier.pegaIndicePerfil() == 0 || DesktopTerrier.pegaIndicePerfil() == 1) {
            peso = 1;
        }
        return peso;
    }

    /**
     * determina o peso das areas de conhecimento para a engenharia eletronica
     *
     * @return double peso
     */
    public static double determinaPesoEle() {

            for(int i = 0; i < KnowledgeAreas.areas.size(); i++){
            //System.out.println(KnowledgeAreas.areas.get(i));
            //System.out.println("esta aqui dentro de areas");
            for(int j = 0; j < KnowledgeAreas.areas.get(i).size(); j++){
              //  System.out.println("esta aqui dentro de matematica");
                if(KnowledgeAreas.areas.get(i).get(j).contains(DesktopTerrier.pegarConsulta())){
                //    System.out.println("esta no contains");
                    if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.matematica)){
                  //      System.out.println("esta dentro de areas -> matematica");
                        peso = 10;
                        //peso = 1.17;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.fisica)){
                        peso = 1;
                        //peso = 1.13;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.quimica)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.computacao)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engProducao)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engSanitaria)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engEletrica)){
                        peso = 1000;
                        //peso = 1.36;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engMecanica)){
                        //peso = 1.06;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engenharia)){
                        peso = 100;
                        //peso = 1.19;
                    }
                }
            }
        }
       
        return peso;

    }

    /**
     * determina o peso das areas de conhecimento para a engenharia de energia
     *
     * @return double peso
     */
    public static double determinaPesoEne() {

        for(int i = 0; i < KnowledgeAreas.areas.size(); i++){
        //System.out.println(KnowledgeAreas.areas.get(i));
        //System.out.println("esta aqui dentro de areas");
            for(int j = 0; j < KnowledgeAreas.areas.get(i).size(); j++){
          //  System.out.println("esta aqui dentro de matematica");
                if(KnowledgeAreas.areas.get(i).get(j).contains(DesktopTerrier.pegarConsulta())){
            //        System.out.println("esta no contains");
                    if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.matematica)){
              //          System.out.println("esta dentro de areas -> matematica");
                        peso = 1000;
                        //peso = 1.19;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.fisica)){
                        peso = 1;
                        //peso = 1.14;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.quimica)){
                        peso = 1;
                        //peso = 1.10;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.computacao)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engProducao)){
                        peso = 1;
                        //peso = 1.04;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engSanitaria)){
                        peso = 1;
                        //peso = 1.08;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engEletrica)){
                        peso = 1;
                        //peso = 1.08;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engMecanica)){
                        peso = 100;
                        //peso = 1.18;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engenharia)){
                        peso = 10;
                        //peso = 1.16;
                    }
                }
            }
        }
       
        return peso;
    
    }

    /**
     * determina o peso das areas de conhecimento para a engenharia de software
     *
     * @return double peso
     */
    public static double determinaPesoSof() {
        
        for(int i = 0; i < KnowledgeAreas.areas.size(); i++){
        //System.out.println(KnowledgeAreas.areas.get(i));
        //System.out.println("esta aqui dentro de areas");
            for(int j = 0; j < KnowledgeAreas.areas.get(i).size(); j++){
              //  System.out.println("esta aqui dentro de matematica");
                if(KnowledgeAreas.areas.get(i).get(j).contains(DesktopTerrier.pegarConsulta())){
                    //System.out.println("esta no contains");
                    if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.matematica)){
                        //System.out.println("esta dentro de areas -> matematica");
                        peso = 10;
                        //peso = 1.14;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.fisica)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.quimica)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.computacao)){
                        peso = 1000;
                        //peso = 1.55;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engProducao)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engSanitaria)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engEletrica)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engMecanica)){
                        peso = 1;
                        //peso = 1.02;
                    } else if(KnowledgeAreas.areas.get(i).equals(KnowledgeAreas.engenharia)){
                        peso = 100;
                        //peso = 1.18;
                    }
                }
            }
        }
       
        return peso;
        
    }
}
