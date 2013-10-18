/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.terrier.matching.models;

import thesaurusPerfis.Perfil;

/**
 *
 * @author greg
 */
public class MeuDLH extends WeightingModel{
    private static final long serialVersionUID = 1L;
	private double k = 0.5d;
	/** 
	 * A default constructor.
	 */
	public MeuDLH() {
		super();
	}
	
	/**
	 * Returns the name of the model.
	 * @return the name of the model
	 */
	public final String getInfo() {
		return "DLH";
	}
	/**
	 * Uses DLH to compute a weight for a term in a document.
	 * @param tf The term frequency in the document
	 * @param docLength the document's length
	 * @return the score assigned to a document with the given 
	 *         tf and docLength, and other preset parameters
	 */
	public final double score(double tf, double docLength) {
                tf = Perfil.pegaPesoPerfis() * tf;
                double f  = tf/docLength ;
  		return 
			 keyFrequency
			* Perfil.pegaPesoPerfis()
                        * (tf*Idf.log ((tf* averageDocumentLength/docLength) *
					( numberOfDocuments/termFrequency) )
			   + (docLength -tf) * Idf.log (1d -f) 
			   + 0.5d* Idf.log(2d*Math.PI*tf*(1d-f)))
			   /(tf + k);
	}
	/**
	 * Uses DLH to compute a weight for a term in a document.
	 * @param tf The term frequency in the document
	 * @param docLength the document's length
	 * @param n_t The document frequency of the term
	 * @param F_t the term frequency in the collection
	 * @param keyFrequency the term frequency in the query
	 * @return the score assigned by the weighting model DLH.
	 */
	public final double score(
		double tf,
		double docLength,
		double n_t,
		double F_t,
		double keyFrequency) {
                tf = Perfil.pegaPesoPerfis();
		double f  = tf/docLength ;
  		return 
			 keyFrequency
			* Perfil.pegaPesoPerfis()
                        * (tf*Idf.log ((tf* averageDocumentLength/docLength) *( numberOfDocuments/F_t) )
			   + (docLength -tf) * Idf.log (1d -f) 
			   + 0.5d* Idf.log(2d*Math.PI*tf*(1d-f)))
			   /(tf + k);
	}
}
