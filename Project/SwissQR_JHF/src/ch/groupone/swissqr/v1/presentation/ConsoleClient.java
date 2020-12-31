package ch.groupone.swissqr.v1.presentation;

import java.util.ArrayList;

import ch.groupone.swissqr.v1.business.DebitorenRechnung;
import ch.groupone.swissqr.v1.business.DebitorenRechnungFactory;

/**
 * Class implementing a console client as main in-/output for the
 * SwissQRRechnungsManagerApp Please note that all accounting specific terms are
 * written in German because it is an exclusive project for accounting in
 * Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */
public class ConsoleClient {

	// Singleton DebitorenFactory to use
	private DebitorenRechnungFactory debitorenRechnungFactory = null;

	/**
	 * Default Constructor for th Console Client
	 */
	public ConsoleClient() {
		debitorenRechnungFactory = DebitorenRechnungFactory.getInstance();
	}

	/**
	 * Creates a new DebitorenRechnung and saves it with the listet attributes
	 * 
	 * @param double betrag
	 * @param String zahlungsempfaenger
	 * @param String zahlungspflichtiger
	 * @param String iban
	 */
	public void createDebitorenRechnung(double betrag, String zahlungsempfaenger, String zahlungspflichtiger,
			String iban) {

		debitorenRechnungFactory.saveDebitorenRechnung(debitorenRechnungFactory.createDebitorenRechnung(betrag,
				zahlungsempfaenger, zahlungspflichtiger, iban));
	}

	/**
	 * Deletes the DebitorenRechnung with the given id
	 * 
	 * @param int debitorenRechnungID
	 */
	public void deleteDebitorenRechnung(int debitorenRechnungID) {

		debitorenRechnungFactory.deleteDebitorenRechnung(debitorenRechnungID);
	}

	/**
	 * Deletes all existing debitorenRechnungen
	 */
	public void deleteAllDebitorenRechnung() {

		debitorenRechnungFactory.deleteAllDebitorenRechnung();
	}

	/**
	 * Helper function to display a single Debitorenrechnung on the console
	 * 
	 * @param DebitorenRechnung debitorenRechnung
	 */
	public void displayDebitorRechnungOnConsole(DebitorenRechnung debitorenRechnung) {

		try {
			System.out.println("---DebitorenRechnung:---ID:" + debitorenRechnung.getDebitorenRechnungID());
			System.out.println("\tBetrag: " + String.format("%.2f", debitorenRechnung.getBetrag()) + " CHF");
			System.out.println("\tZahlungsempfaenger: " + debitorenRechnung.getZahlungsempfaenger());
			System.out.println("\tZahlungspflichtiger: " + debitorenRechnung.getZahlungspflichtiger());

		} catch (Exception e) {
			System.out.println("Invalid or nonexisting debitorrechnung");
		}

	}

	/**
	 * Helper function to show a separator
	 */
	public void displaySeperator() {
		System.out.println("-------------------------------------------------------------------------------------");
	}

	/**
	 * Displays the DebitorenRechnung with the given id
	 * 
	 * @param int debitorenRechnungID
	 */
	public void displayDebitorenRechnung(int debitorenRechnungID) {

		DebitorenRechnung debitorenRechnung = debitorenRechnungFactory.selectDebitorenRechnung(debitorenRechnungID);

		displayDebitorRechnungOnConsole(debitorenRechnung);
	}

	/**
	 * Displays all existing DebitorenRechnungen
	 */
	public void displayAllDebitorRechnungen() {
		ArrayList<DebitorenRechnung> debitorenRechnungen = debitorenRechnungFactory.selectAllDebitorenRechnung();

		for (DebitorenRechnung debitorenRechnung : debitorenRechnungen) {
			displayDebitorRechnungOnConsole(debitorenRechnung);
		}
	}
}
