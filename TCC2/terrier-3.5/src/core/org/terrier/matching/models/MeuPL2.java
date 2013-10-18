/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.terrier.matching.models;

import thesaurusPerfis.Perfil;

/**
 * This class implements the PL2 weighting model with perfil
 * @author Gianni Amati, Ben He, Vassilis Plachouras
 */
public class MeuPL2 extends WeightingModel{
    	private static final long serialVersionUID = 1L;
	/** 
	 * A default constructor. This must be followed 
	 * by specifying the c value.
	 */
	public MeuPL2() {
		super();
		c =1.0d;
	}
	/** 
	 * Constructs an instance of this class with the 
	 * specified value for the parameter c.
	 * @param c the term frequency normalisation parameter value.
	 */
	public MeuPL2(double c) {
		this();
		this.c = c;
	}
	/**
	 * Returns the name of the model.
	 * @return the name of the model
	 */
	public final String getInfo() {
		return "PL2c" + c;
	}
	/**
	 * Uses PL2 to compute a weight for a term in a document.
	 * @param tf The term frequency in the document
	 * @param docLength the document's length
	 * @return the score assigned to a document with the given 
	 *         tf and docLength, and other preset parameters
	 */
	public final double score(double tf, double docLength) {
		tf = tf * Perfil.pegaPesoPerfis();
                double TF =
			tf * Idf.log(1.0d + (c * averageDocumentLength) / docLength);
		double NORM = 1.0D / (TF + 1d);
		double f = (1.0D * termFrequency) / (1.0D * numberOfDocuments);
		return NORM
                        * Perfil.pegaPesoPerfis()
			* keyFrequency
			* (TF * Idf.log(1.0D / f)
				+ f * Idf.REC_LOG_2_OF_E
				+ 0.5d * Idf.log(2 * Math.PI * TF)
				+ TF * (Idf.log(TF) - Idf.REC_LOG_2_OF_E));
	}
	/**
	 * Uses PL2 to compute a weight for a term in a document.
	 * @param tf The term frequency in the document
	 * @param docLength the document's length
	 * @param n_t The document frequency of the term
	 * @param F_t the term frequency in the collection
	 * @param keyFrequency the term frequency in the query
	 * @return the score assigned by the weighting model PL2.
	 */
	public final double score(
		double tf,
		double docLength,
		double n_t,
		double F_t,
		double keyFrequency) {
                
                tf = tf * Perfil.pegaPesoPerfis();
                F_t = F_t * Perfil.pegaPesoPerfis();
            
                double TF = tf * Idf.log(1.0d + (c * averageDocumentLength) / docLength);
		double NORM = 1.0D / (TF + 1d);
		double f = F_t / numberOfDocuments;
		return NORM
                        * Perfil.pegaPesoPerfis()
			* keyFrequency
			* (TF * Idf.log(1d / f)
				+ f * Idf.REC_LOG_2_OF_E
				+ 0.5d * Idf.log(2 * Math.PI * TF)
				+ TF * (Idf.log(TF) - Idf.REC_LOG_2_OF_E));
	}
}
