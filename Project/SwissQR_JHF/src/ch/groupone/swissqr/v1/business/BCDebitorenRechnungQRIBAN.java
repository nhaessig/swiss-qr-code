package ch.groupone.swissqr.v1.business;

/**
 * Implementation class for a customer invoice (Derbitorenrechnung) with SwissQR-IBAN
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */
public class BCDebitorenRechnungQRIBAN extends AbstractDebitorenRechnung {

	private String qrIBAN = "";

	/**
	 *  Constructor for an BCDebitorenRechnungQRIBAN calls super constructor
	 *  @param double betrag 
	 *  @param String zahlungsempfaenger
	 *  @param String zahlungspflichtiger
	 *  @param String qrIBAN
	 */
	public BCDebitorenRechnungQRIBAN(double betrag, String zahlungsempfaenger, String zahlungspflichtiger ,String qrIBAN) {
		super(betrag, zahlungsempfaenger, zahlungspflichtiger);

		setQrIBAN(qrIBAN);
	}
	
	/**
	 *  Constructor for an AbstractDebitorenRechnung which also sets the Id,  calls super constructor, should be taken when creating from persistence 
	 *  @param int debitorenRechnungID
	 *  @param double betrag 
	 *  @param String zahlungsempfaenger
	 *  @param String zahlungspflichtiger
	 */
	public BCDebitorenRechnungQRIBAN(int debitorenRechnungID, double betrag, String zahlungsempfaenger, String zahlungspflichtiger ,String qrIBAN) {
		super(debitorenRechnungID, betrag, zahlungsempfaenger,	 zahlungspflichtiger);

		setQrIBAN(qrIBAN);
	}

	/**
	 * Public setter function to setQrIBAN as String
	 * @param String qrIBAN
	 */
	public void setQrIBAN(String qrIBAN) {
		this.qrIBAN = qrIBAN;
	}

	/**
	 * Public getter function to getIsbn returns qrIBAN as String
	 * @return qrIBAN
	 */
	public final String getIsbn() {
		return qrIBAN;
	}
}
