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
public class MeuBM25 extends WeightingModel{
    private static final long serialVersionUID = 1L;

	/** The constant k_1.*/
	private double k_1 = 1.2d;
	
	/** The constant k_3.*/
	private double k_3 = 8d;
	
	/** The parameter b.*/
	private double b;
	
	/** A default constructor.*/
	public MeuBM25() {
		super();
		b=0.75d;
	}
	/**
	 * Returns the name of the model.
	 * @return the name of the model
	 */
	public final String getInfo() {
		return "BM25b"+b;
	}
	/**
	 * Uses BM25 to compute a weight for a term in a document.
	 * @param tf The term frequency in the document
	 * @param docLength the document's length
	 * @return the score assigned to a document with the given 
	 *         tf and docLength, and other preset parameters
	 */
	public double score(double tf, double docLength) {
	    tf = tf * Perfil.pegaPesoPerfis();
            double K = k_1 * ((1 - b) + b * docLength / averageDocumentLength) + tf;
	    return Perfil.pegaPesoPerfis() * ((tf * (k_3 + 1d) * keyFrequency / ((k_3 + keyFrequency) * K))
	            * Idf.log((numberOfDocuments - documentFrequency + 0.5d) / (documentFrequency + 0.5d)));
	}
	/**
	 * Uses BM25 to compute a weight for a term in a document.
	 * @param tf The term frequency in the document
	 * @param docLength the document's length
	 * @param n_t The document frequency of the term
	 * @param F_t the term frequency in the collection
	 * @param keyFrequency the term frequency in the query
	 * @return the score assigned by the weighting model BM25.
	 */
	public double score(
		double tf,
		double docLength,
		double n_t,
		double F_t,
		double keyFrequency) {
            tf = tf * Perfil.pegaPesoPerfis();
	    double K = k_1 * ((1 - b) + b * docLength / averageDocumentLength) + tf;
	    return Perfil.pegaPesoPerfis() * (Idf.log((numberOfDocuments - n_t + 0.5d) / (n_t+ 0.5d)) *
			((k_1 + 1d) * tf / (K + tf)) *
			((k_3+1)*keyFrequency/(k_3+keyFrequency)));
	}

	/**
	 * Sets the b parameter to BM25 ranking formula
	 * @param _b the b parameter value to use.
	 */
	public void setParameter(double _b) {
	    this.b = _b;
	}


	/**
	 * Returns the b parameter to the BM25 ranking formula as set by setParameter()
	 */
	public double getParameter() {
	    return this.b;
	}
}
