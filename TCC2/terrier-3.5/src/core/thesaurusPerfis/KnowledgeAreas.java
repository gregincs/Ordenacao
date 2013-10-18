/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thesaurusPerfis;

//import com.sun.org.apache.xpath.internal.operations.String;
import java.util.ArrayList;

/**
 *
 * @author greg
 */
public class KnowledgeAreas {

    public static ArrayList< ArrayList<String> > areas = new ArrayList< ArrayList<String> >();
    public static ArrayList matematica = new ArrayList<String>();
    public static ArrayList fisica = new ArrayList<String>();
    public static ArrayList quimica = new ArrayList<String>();
    public static ArrayList computacao = new ArrayList<String>();
    public static ArrayList engProducao = new ArrayList<String>();
    public static ArrayList engSanitaria = new ArrayList<String>();
    public static ArrayList engEletrica = new ArrayList<String>();
    public static ArrayList engMecanica = new ArrayList<String>();
    public static ArrayList engenharia = new ArrayList<String>();    
    

    public static ArrayList getKnowledgeArea() {
        return areas;
    }

    public static void setKnowledgeArea(ArrayList areas) {
        KnowledgeAreas.areas = areas;
    }
    
    public static ArrayList getMatematica() {
        return matematica;
    }

    public static void setMatematica(ArrayList matematica) {
        KnowledgeAreas.matematica = matematica;
    }

    public static ArrayList<String> getFisica() {
        return fisica;
    }

    public static void setFisica(ArrayList<String> fisica) {
        KnowledgeAreas.fisica = fisica;
    }

    public static ArrayList<String> getQuimica() {
        return quimica;
    }

    public static void setQuimica(ArrayList<String> quimica) {
        KnowledgeAreas.quimica = quimica;
    }

    public static ArrayList<String> getComputacao() {
        return computacao;
    }

    public static void setComputacao(ArrayList<String> computacao) {
        KnowledgeAreas.computacao = computacao;
    }

    public static ArrayList<String> getEngProducao() {
        return engProducao;
    }

    public static void setEngProducao(ArrayList<String> engProducao) {
        KnowledgeAreas.engProducao = engProducao;
    }

    public static ArrayList<String> getEngSanitaria() {
        return engSanitaria;
    }

    public static void setEngSanitaria(ArrayList<String> engSanitaria) {
        KnowledgeAreas.engSanitaria = engSanitaria;
    }

    public static ArrayList<String> getEngMecanica() {
        return engMecanica;
    }

    public static void setEngMecanica(ArrayList<String> engMecanica) {
        KnowledgeAreas.engMecanica = engMecanica;
    }

    public static ArrayList<String> getEngenharia() {
        return engenharia;
    }

    public static ArrayList getEngEletrica() {
        return engEletrica;
    }

    public static void setEngEletrica(ArrayList engEletrica) {
        KnowledgeAreas.engEletrica = engEletrica;
    }

    public static void setEngenharia(ArrayList<String> engenharia) {
        KnowledgeAreas.engenharia = engenharia;
    }
    
    
    
    public void adicionaTermosMatematica() {
        matematica.add("matematica");
        matematica.add("html");
        matematica.add("terrier");
        matematica.add("documentarion");
        matematica.add("configuring");
    }
    
    public void adicionaTermosFisica() {
        fisica.add("index");
        fisica.add("trec");
        fisica.add("properties");
        fisica.add("installing");
    }
    
    public void adicionaTermosQuimica() {
        quimica.add("quimica");
        quimica.add("components");
        quimica.add("class");
        quimica.add("method");
    }
    
    public void adicionaTermosComp() {
        computacao.add("computacao");
        computacao.add("model");
        computacao.add("weight");
        computacao.add("match");
    }
    
    public void adicionaTermosEngProd() {
        engProducao.add("language");
        engProducao.add("guide");
        engProducao.add("results");
        engProducao.add("hadoop");
    }
    
    public void adicionaTermosEngSan() {
        engSanitaria.add("web");
        engSanitaria.add("develop");
        engSanitaria.add("implements");
        engSanitaria.add("forum");
    }
    
    public void adicionaTermosEngEle(){
        engEletrica.add("basic");
        engEletrica.add("retrieval");
        engEletrica.add("extend");
        engEletrica.add("serial");
    }
    
    public void adicionaTermosEngMec() {
        engMecanica.add("wiki");
        engMecanica.add("plataform");
        engMecanica.add("structures");
        engMecanica.add("utility");
    }
    
    public void adicionaTermosEng() {      
        engenharia.add("sort");
        engenharia.add("evaluation");
        engenharia.add("desktop");
        engenharia.add("application");
    }

    public void adicionaAreasConhecmento(){
        areas.add(matematica);
        areas.add(fisica);
        areas.add(quimica);
        areas.add(computacao);
        areas.add(engProducao);
        areas.add(engSanitaria);
        areas.add(engEletrica);
        areas.add(engMecanica);
        areas.add(engenharia);
    }
    /*
     OBTUSO
     RASO
     RETO
     COMPLEMENTARES
     SUPLEMENTARES
     (Geometria)
     */
    public KnowledgeAreas() {
        adicionaAreasConhecmento();
        adicionaTermosMatematica();
        adicionaTermosFisica();
        adicionaTermosQuimica();
        adicionaTermosComp();
        adicionaTermosEngProd();
        adicionaTermosEngSan();
        adicionaTermosEngEle();
        adicionaTermosEngMec();
        adicionaTermosEng();
    }
}
