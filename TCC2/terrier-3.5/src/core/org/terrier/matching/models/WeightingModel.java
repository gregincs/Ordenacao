/*
 * Terrier - Terabyte Retriever 
 * Webpage: http://terrier.org 
 * Contact: terrier{a.}dcs.gla.ac.uk
 * University of Glasgow - School of Computing Science
 * http://www.gla.ac.uk/
 * 
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is WeightingModel.java.
 *
 * The Original Code is Copyright (C) 2004-2011 the University of Glasgow.
 * All Rights Reserved.
 *
 * Contributor(s):
 *   Gianni Amati <gba{a.}fub.it> (original author)
 *   Ben He <ben{a.}dcs.gla.ac.uk> 
 *   Vassilis Plachouras <vassilis{a.}dcs.gla.ac.uk>
 */
package org.terrier.matching.models;
import java.io.Serializable;

import org.terrier.matching.Model;
import org.terrier.querying.Request;
import org.terrier.structures.CollectionStatistics;
import org.terrier.structures.EntryStatistics;
import org.terrier.structures.postings.Posting;
/**
 * This class should be extended by the classes used
 * for weighting terms and documents.
 * @author Gianni Amati, Ben He, Vassilis Plachouras
  */
public abstract class WeightingModel implements Model, Serializable,Cloneable {
	private static final long serialVersionUID = 1L;
	/** The class used for computing the idf values.*/
	protected Idf i;
	/** The average length of documents in the collection.*/
	protected double averageDocumentLength;
	/** The term frequency in the query.*/
	protected double keyFrequency;
	/** The document frequency of the term in the collection.*/
	protected double documentFrequency;
	/** The term frequency in the collection.*/
	protected double termFrequency;
	/** The number of documents in the collection.*/
	protected double numberOfDocuments;
	/** The number of tokens in the collections. */
	protected double numberOfTokens;
	/** The parameter c. This defaults to 1.0, but should be set using in the constructor
	  * of each child weighting model to the sensible default for that weighting model. */
	protected double c = 1.0d;
	/** Number of unique terms in the collection */
	protected double numberOfUniqueTerms;	

	/** The number of distinct entries in the inverted file. This figure can be calculated
	  * as the sum of all Nt over all terms */
	protected double numberOfPointers;
	/**
	 * A default constructor that initialises the idf i attribute
	 */
	public WeightingModel() {
		i = new Idf();
	}

	/** Clone this weighting model */
	public Object clone() {
		try{
			WeightingModel newModel = (WeightingModel)super.clone();
			newModel.i = (Idf)this.i.clone();
			return newModel;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

        //estamos quase la
	/**
	 * Returns the name of the model.
	 * @return java.lang.String
	 */
	public abstract String getInfo();
	/**
	 * prepare
	 */
	public void prepare()
	{
		averageDocumentLength = cs.getAverageDocumentLength();
		numberOfDocuments = (double)cs.getNumberOfDocuments();
		i.setNumberOfDocuments(numberOfDocuments);
		numberOfTokens = (double)cs.getNumberOfTokens();
		numberOfUniqueTerms = (double)cs.getNumberOfUniqueTerms();
		numberOfPointers = (double)cs.getNumberOfPointers();
		documentFrequency = (double)getOverflowed(es.getDocumentFrequency());
		termFrequency = (double)getOverflowed(es.getFrequency());		
	}
	/**
	 * Returns overflow
	 * @param o
	 * @return overflow
	 */
	public static long getOverflowed(int o)
	{		
		return o < 0 ? (o - Integer.MIN_VALUE) + (long)Integer.MAX_VALUE + 1l : (long)o;
	}
	/**
	 * Returns score
	 * @param p
	 * @return score
	 */
	public double score(Posting p)
	{
		return this.score(p.getFrequency(), p.getDocumentLength());
	}
	
	CollectionStatistics cs;
	/**
	 * Sets collection statistics
	 * @param _cs
	 */
	public void setCollectionStatistics(CollectionStatistics _cs)
	{
		cs = _cs;
	}
	EntryStatistics es;
	/**
	 * Sets entry statistics.
	 * @param _es
	 */
	public void setEntryStatistics(EntryStatistics _es)
	{
		es = _es;
	}
	
	Request rq;
	/**
	 * Sets request
	 * @param _rq
	 */
	public void setRequest(Request _rq)
	{
		rq = _rq;
	}
	
	
	/**
	 * This method provides the contract for implementing weighting models.
	 * @param tf The term frequency in the document
	 * @param docLength the document's length
	 * @return the score assigned to a document with the given tf 
	 * and docLength, and other preset parameters
	 */
	public abstract double score(double tf, double docLength);
	/**
	 * This method provides the contract for implementing weighting models.
	 * @param tf The term frequency in the document
	 * @param docLength the document's length
	 * @param n_t The document frequency of the term
	 * @param F_t the term frequency in the collection
	 * @param _keyFrequency the term frequency in the query
	 * @return the score returned by the implemented weighting model.
	 */
	public abstract double score(
		double tf,
		double docLength,
		double n_t,
		double F_t,
		double _keyFrequency);
	/**
	 * Sets the average length of documents in the collection.
	 * @param avgDocLength The documents' average length.
	 * @deprecated Use setCollectionStatistics(CollectionStatistics)
	 */
	public void setAverageDocumentLength(double avgDocLength) {
		averageDocumentLength = avgDocLength;
	}
	/**
	 * Sets the c value
	 * @param _c the term frequency normalisation parameter value.
	 */
	public void setParameter(double _c) {
		this.c = _c;
	}


	/**
	 * Returns the parameter as set by setParameter()
	 */
	public double getParameter() {
		return this.c;
	}

	/**
	 * Sets the document frequency of the term in the collection.
	 * @param docFreq the document frequency of the term in the collection.
	 * @deprecated Use setEntryStatistics(EntryStatistics)
	 */
	public void setDocumentFrequency(double docFreq) {
		documentFrequency = docFreq;
	}
	/**
	 * Sets the term's frequency in the query.
	 * @param keyFreq the term's frequency in the query.
	 */
	public void setKeyFrequency(double keyFreq) {
		keyFrequency = keyFreq;
	}
	
	
	
	/**
	 * Set the number of tokens in the collection.
	 * @param value The number of tokens in the collection.
	 * @deprecated Use setCollectionStatistics(CollectionStatistics)
	 */
	public void setNumberOfTokens(double value){
		this.numberOfTokens = value;
	}
	/**
	 * Sets the number of documents in the collection.
	 * @param numOfDocs the number of documents in the collection.
	 * @deprecated Use setCollectionStatistics(CollectionStatistics)
	 */
	public void setNumberOfDocuments(double numOfDocs) {
		numberOfDocuments = numOfDocs;
		i.setNumberOfDocuments(numOfDocs);
	}
	/**
	 * Sets the term's frequency in the collection.
	 * @param termFreq the term's frequency in the collection.
	 * @deprecated Use setEntryStatistics(EntryStatistics)
	 */
	public void setTermFrequency(double termFreq) {
		termFrequency = termFreq;
	}
	/**
	 * Set the number of unique terms in the collection.
	 * @deprecated Use setCollectionStatistics(CollectionStatistics)
	 */
	public void setNumberOfUniqueTerms(double number) {
		numberOfUniqueTerms = number;
	}
	/**
	 * Set the number of pointers in the collection.
	 * @deprecated Use setCollectionStatistics(CollectionStatistics)
	 */
	public void setNumberOfPointers(double number) {
		numberOfPointers = number;
	}
	/**
	* This method provides the contract for implementing the 
	* Stirling formula for the power series.
	* @param n The parameter of the Stirling formula.
	* @param m The parameter of the Stirling formula.
	* @return the approximation of the power series
	*/
	public double stirlingPower(double n, double m) {
		double dif = n - m;
		return (m + 0.5d) * Idf.log(n / m) + dif * Idf.log(n);
	}
}
