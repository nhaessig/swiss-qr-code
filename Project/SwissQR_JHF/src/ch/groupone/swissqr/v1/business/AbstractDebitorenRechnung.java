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
	
	public final double getBetrag() {
		return this.betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}
	
	public final String getZahlungsempfaenger() {
		return this.zahlungsempfaenger;
	}

	public void setZahlungsempfaenger(String zahlungsempfaenger) {
		this.zahlungsempfaenger = zahlungsempfaenger;
	}
	
	public final String getZahlungspflichtiger() {
		return this.zahlungspflichtiger;
	}

	public void setZahlungspflichtiger(String zahlungspflichtiger) {
		this.zahlungspflichtiger = zahlungspflichtiger;
	}
}
