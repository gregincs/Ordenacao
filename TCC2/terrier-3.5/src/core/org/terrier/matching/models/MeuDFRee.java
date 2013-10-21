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
public class MeuDFRee extends WeightingModel {

    private static final long serialVersionUID = 1L;
    /**
     * model name
     */
    private static final String name = "DFRee";

    /**
     * A default constructor to make this model.
     */
    public MeuDFRee() {
        super();
    }

    /**
     * Returns the name of the model, in this case "DFRee"
     *
     * @return the name of the model
     */
    public final String getInfo() {
        return name;
    }

    /**
     * Uses DFRee to compute a weight for a term in a document.
     *
     * @param tf The term frequency of the term in the document
     * @param docLength the document's length
     * @return the score assigned to a document with the given tf and docLength,
     * and other preset parameters
     */
    public final double score(double tf, double docLength) {
        /**
         * DFRee model with the log normalisation function.
         */
        tf = tf * Perfil.pegaPesoPerfis();
        double prior = tf / docLength;
        double posterior = (tf + 1d) / (docLength + 1);
        double InvPriorCollection = numberOfTokens / termFrequency;
        //double alpha = 1d/docLength; //0 <= alpha <= posterior


        double norm = tf * Idf.log(posterior / prior);

        return keyFrequency * norm * (tf * (-Idf.log(prior * InvPriorCollection))
                + (tf + 1d) * (+Idf.log(posterior * InvPriorCollection))
                + 0.5 * Idf.log(posterior / prior));
    }

    /**
     * Uses DFRee to compute a weight for a term in a document.
     *
     * @param tf The term frequency of the term in the document
     * @param docLength the document's length
     * @param documentFrequency The document frequency of the term (ignored)
     * @param termFrequency the term frequency in the collection (ignored)
     * @param keyFrequency the term frequency in the query (ignored).
     * @return the score assigned by the weighting model DFRee.
     */
    public final double score(
            double tf,
            double docLength,
            double documentFrequency,
            double termFrequency,
            double keyFrequency) {
        /**
         * DFRee model with the log normalisation function.
         */
        tf = Perfil.pegaPesoPerfis();
        double prior = tf / docLength;
        double posterior = (tf + 1d) / (docLength + 1);
        double InvPriorCollection = numberOfTokens / termFrequency;
        //double alpha = 1d/docLength; //0 <= alpha <= posterior


        double norm = tf * Idf.log(posterior / prior);

        return keyFrequency * norm * (tf * (-Idf.log(prior * InvPriorCollection))
                + (tf + 1d) * (+Idf.log(posterior * InvPriorCollection))
                + 0.5 * Idf.log(posterior / prior));
    }
}
