/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.terrier.matching.models;

import org.terrier.applications.desktop.DesktopTerrier;
import org.terrier.querying.Request;
import org.terrier.querying.parser.Query;
import thesaurusPerfis.Perfil;

/**
 *
 * @author greg
 */
public class MeuDFI0 extends WeightingModel {

	private static final long serialVersionUID = 1L;
        
	@Override
	public String getInfo() {
		return "MeuDFI0";
	}

	@Override
	public double score(double tf, double docLength)
	{
                tf = tf * Perfil.pegaPesoPerfis();
                final double eij = Perfil.pegaPesoPerfis() * super.termFrequency * (docLength / super.numberOfTokens);
                //return Perfil.pegaPesoPerfis() * keyFrequency * Idf.log(1+ (tf - eij)/Math.sqrt(eij) );
                return keyFrequency * Idf.log(1+ (tf - eij)/Math.sqrt(eij) );
           
        }

	@Override
	public double score(double tf, double docLength, double n_t, double F_t,
			double keyFrequency) 
	{   
                tf = tf * Perfil.pegaPesoPerfis();
                F_t = F_t*Perfil.pegaPesoPerfis();
                final double eij =  F_t * (docLength / super.numberOfTokens);
		return Perfil.pegaPesoPerfis() * keyFrequency * Idf.log(1+ (tf - eij)/Math.sqrt(eij) );   
                //return keyFrequency * Idf.log(1+ (tf - eij)/Math.sqrt(eij) );
        }

}
