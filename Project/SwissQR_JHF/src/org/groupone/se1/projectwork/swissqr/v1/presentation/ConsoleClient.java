package org.groupone.se1.projectwork.swissqr.v1.presentation;

import java.util.ArrayList;

import org.groupone.se1.projectwork.swissqr.v1.business.DebitorenRechnung;
import org.groupone.se1.projectwork.swissqr.v1.business.DebitorenRechnungFactory;

public class ConsoleClient {

	private DebitorenRechnungFactory debitorenRechnungFactory = null;

	public ConsoleClient() {
		debitorenRechnungFactory = DebitorenRechnungFactory.getInstance();
	}

	public void createDebitorenRechnung(double betrag, String zahlungsempfaenger, String zahlungspflichtiger,
			String iban) {

		debitorenRechnungFactory.saveDebitorenRechnung(debitorenRechnungFactory.createDebitorenRechnung(betrag,
				zahlungsempfaenger, zahlungspflichtiger, iban));
	}

	public void deleteDebitorenRechnung(int debitorenRechnungID) {

		debitorenRechnungFactory.deleteDebitorenRechnung(debitorenRechnungID);
	}

	public void displayDebitorRechnungOnConsole(DebitorenRechnung debitorenRechnung) {
		System.out.println("---DebitorenRechnung:---");
		System.out.println("\tBetrag: " + String.format("%.2f", debitorenRechnung.getBetrag()) + " CHF");
		System.out.println("\tZahlungsempfaenger: " + debitorenRechnung.getZahlungsempfaenger());
		System.out.println("\tZahlungspflichtiger: " + debitorenRechnung.getZahlungspflichtiger());
	}

	public void displayDebitorenRechnung(int debitorenRechnungID) {

		DebitorenRechnung debitorenRechnung = debitorenRechnungFactory.selectDebitorenRechnung(debitorenRechnungID);

		displayDebitorRechnungOnConsole(debitorenRechnung);
	}

	public void displayAllDebitorRechnungen() {
		ArrayList<DebitorenRechnung> debitorenRechnungen = debitorenRechnungFactory.selectAllDebitorenRechnung();

		for (DebitorenRechnung debitorenRechnung : debitorenRechnungen) {
			displayDebitorRechnungOnConsole(debitorenRechnung);
		}
	}
}
