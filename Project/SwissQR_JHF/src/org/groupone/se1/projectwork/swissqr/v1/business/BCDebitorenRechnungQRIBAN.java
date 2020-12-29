package org.groupone.se1.projectwork.swissqr.v1.business;

public class BCDebitorenRechnungQRIBAN extends AbstractDebitorenRechnung {

	private String qrIBAN = "";

	public BCDebitorenRechnungQRIBAN(double betrag, String qrIBAN) {
		super(betrag);

		setQrIBAN(qrIBAN);
	}

	public void setQrIBAN(String qrIBAN) {
		this.qrIBAN = qrIBAN;
	}

	public final String getIsbn() {
		return qrIBAN;
	}
}
