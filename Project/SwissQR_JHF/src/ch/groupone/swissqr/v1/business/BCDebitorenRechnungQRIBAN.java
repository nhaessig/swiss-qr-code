/**
 * Implementation class for a customer invoice (Derbitorenrechnung) with SwissQR-IBAN
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */

package ch.groupone.swissqr.v1.business;

public class BCDebitorenRechnungQRIBAN extends AbstractDebitorenRechnung {

	private String qrIBAN = "";

	public BCDebitorenRechnungQRIBAN(double betrag, String zahlungsempfaenger, String zahlungspflichtiger ,String qrIBAN) {
		super(betrag, zahlungsempfaenger, zahlungspflichtiger);

		setQrIBAN(qrIBAN);
	}
	
	public BCDebitorenRechnungQRIBAN(int debitorenRechnungID, double betrag, String zahlungsempfaenger, String zahlungspflichtiger ,String qrIBAN) {
		super(debitorenRechnungID, betrag, zahlungsempfaenger, zahlungspflichtiger);

		setQrIBAN(qrIBAN);
	}

	public void setQrIBAN(String qrIBAN) {
		this.qrIBAN = qrIBAN;
	}

	public final String getIsbn() {
		return qrIBAN;
	}
}
