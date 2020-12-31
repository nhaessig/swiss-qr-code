package ch.groupone.swissqr.v1.business;

/**
 * Interface for customer invoices (Debitorenrechnungen) like DebitorenRechnungQRIBAN and DebitorenRechnungSCOR
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas H�ssig
 */
public interface DebitorenRechnung {
	
	/**
	 * Getter function to get debitorenRechnungID as int
	 * @return debitorenRechnungID
	 */
	public int getDebitorenRechnungID();
	
	/**
	 * Getter function to get betrag as double
	 * @return betrag
	 */
	public double getBetrag();
	
	/**
	 * Getter function to get zahlungsempf�nger as String
	 * @return zahlungsEmpfaenger
	 */
	public String getZahlungsempfaenger();
	
	/**
	 * Getter function get zahlungspflichtiger as String
	 * @return zahlungsPflichtiger
	 */
	public String getZahlungspflichtiger();
	
	/**
	 * Setter function set betrag as double
	 * @param double betrag
	 */
	public void setBetrag(double betrag);
	
	/**
	 * Setter function set zahlungsempfaenger as String
	 * @param String zahlungsEmpfaenger
	 */
	public void setZahlungsempfaenger(String zahlungsempfaenger);
	
	/**
	 * Setter function set zahlungsspflichtiger as String
	 * @param zahlungspflichtiger
	 */
	public void setZahlungspflichtiger(String zahlungspflichtiger);
}
