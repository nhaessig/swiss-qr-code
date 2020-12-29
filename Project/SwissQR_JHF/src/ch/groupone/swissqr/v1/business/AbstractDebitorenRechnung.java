package ch.groupone.swissqr.v1.business;

public abstract class AbstractDebitorenRechnung implements DebitorenRechnung {

	private double betrag = 0.0;
	private String zahlungsempfaenger = "";
	private String zahlungspflichtiger = "";

	public AbstractDebitorenRechnung() {
		this.betrag = 0.0;
		this.zahlungsempfaenger = "";
		this.zahlungspflichtiger = "";
	}

	public AbstractDebitorenRechnung(double betrag, String zahlungsempfaenger, String zahlungspflichtiger) {
		this.betrag = betrag;
		this.zahlungsempfaenger = zahlungsempfaenger;
		this.zahlungspflichtiger = zahlungspflichtiger;
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
