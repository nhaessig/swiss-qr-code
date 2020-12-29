package ch.groupone.swissqr.v1.business;

public interface DebitorenRechnung {
	
	public void setBetrag(double betrag);
	public void setZahlungsempfaenger(String zahlungsempfaenger);
	public void setZahlungspflichtiger(String zahlungspflichtiger);

	public double getBetrag();
	public String getZahlungsempfaenger();
	public String getZahlungspflichtiger();
}
