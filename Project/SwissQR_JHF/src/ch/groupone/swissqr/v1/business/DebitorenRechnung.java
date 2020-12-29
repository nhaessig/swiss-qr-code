/**
 * Interface for customer invoices (Debitorenrechnungen) like DebitorenRechnungQRIBAN and DebitorenRechnungSCOR
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */

package ch.groupone.swissqr.v1.business;

public interface DebitorenRechnung {
	
	public int debitorenRechnungID();
	public double getBetrag();
	public String getZahlungsempfaenger();
	public String getZahlungspflichtiger();
	
	public void setBetrag(double betrag);
	public void setZahlungsempfaenger(String zahlungsempfaenger);
	public void setZahlungspflichtiger(String zahlungspflichtiger);
}
