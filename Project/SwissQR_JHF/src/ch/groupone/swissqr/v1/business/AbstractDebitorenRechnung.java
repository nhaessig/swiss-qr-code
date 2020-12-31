/**
 * Parent class for customer invoices (Debitorenrechnungen) like DebitorenRechnungQRIBAN and DebitorenRechnungSCOR
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */

package ch.groupone.swissqr.v1.business;

public abstract class AbstractDebitorenRechnung implements DebitorenRechnung {

	private int debitorenRechnungID = 0;
	private double betrag = 0.0;
	private String zahlungsempfaenger = "";
	private String zahlungspflichtiger = "";

	public AbstractDebitorenRechnung() {
		this.debitorenRechnungID = 0;
		this.betrag = 0.0;
		this.zahlungsempfaenger = "";
		this.zahlungspflichtiger = "";
	}

	public AbstractDebitorenRechnung(double betrag, String zahlungsempfaenger, String zahlungspflichtiger) {
		this.debitorenRechnungID = 0;
		this.betrag = betrag;
		this.zahlungsempfaenger = zahlungsempfaenger;
		this.zahlungspflichtiger = zahlungspflichtiger;
	}
	
	public AbstractDebitorenRechnung(int debitorenRechnungID, double betrag, String zahlungsempfaenger, String zahlungspflichtiger) {
		this.debitorenRechnungID = debitorenRechnungID;
		this.betrag = betrag;
		this.zahlungsempfaenger = zahlungsempfaenger;
		this.zahlungspflichtiger = zahlungspflichtiger;
	}

	public final int debitorenRechnungID() {
		return this.debitorenRechnungID;
	}
	
	/**
	 * Public getter function returns betrag as double
	 * @return double betrag
	 */
	public final double getBetrag() {
		return this.betrag;
	}

	/**
	 * Public setter function set the betrag as double
	 * @param double betrag
	 */
	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}
	
	/**
	 * Public getter function getZahlungsempfaenger returns zahlungsempfaenger as String
	 * @return zahlungsempfaenger
	 */
	public final String getZahlungsempfaenger() {
		return this.zahlungsempfaenger;
	}
	
	/**
	 * Public setter function setZahlungsempfaenger as String
	 * @param String zahlungsempfaenger
	 */
	public void setZahlungsempfaenger(String zahlungsempfaenger) {
		this.zahlungsempfaenger = zahlungsempfaenger;
	}
	
	/**
	 * Public getter function to getZahlungspflichtiger returns zahlungspflichtiger as String
	 * @return zahlungspflichtiger
	 */
	public final String getZahlungspflichtiger() {
		return this.zahlungspflichtiger;
	}
	
	/**
	 * Public setter function to setZahlungspflichtiger as String
	 * @param String zahlungspflichtiger
	 */
	public void setZahlungspflichtiger(String zahlungspflichtiger) {
		this.zahlungspflichtiger = zahlungspflichtiger;
	}
}
