package ch.groupone.swissqr.v1.presentation;

import java.util.Random;

/**
 * Class containing the main function for the SwissQRRechnungsManagerApp Please
 * note that all accounting specific terms are written in German because it is
 * an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */
public class SwissQRRechnungsManagerApp {

	// Some test data for showcase
	private static final String[] zahlungsempfaengerOrPflichtigerArray = { "MonoAg", "Rudolf Meier", "Six Finance",
			"Treuhand +", "Las Miranda" };
	private static final double[] betragArray = { 100.0, 55.55, 32.15, 10.25, 5.00 };
	private static final String[] qrIbanArray = { "CH4431999123000889012", "CH4231998124010859023",
			"CH4131998124010159011", "CH3131928164016159016 +", "CH2139998124010159019" };

	// function to generate and save test data
	private static void generateTestData(int amount, ConsoleClient consoleClient) {
		Random rand = new Random();

		// please note that all test arrays must have the same size
		int testarraysize = zahlungsempfaengerOrPflichtigerArray.length;

		for (int i = 0; i < amount; i++) {

			consoleClient.createDebitorenRechnung(betragArray[rand.nextInt(testarraysize)],
					zahlungsempfaengerOrPflichtigerArray[rand.nextInt(testarraysize)],
					zahlungsempfaengerOrPflichtigerArray[rand.nextInt(testarraysize)],
					qrIbanArray[rand.nextInt(testarraysize)]);
		}
	}

	/**
	 * Main method of the SwissQRRechnungsManagerApp
	 * 
	 * @param String[] args
	 */
	public static void main(String[] args) {

		ConsoleClient consoleClient = new ConsoleClient();

		// Console Client with testdata
		generateTestData(10, consoleClient);

		consoleClient.displayAllDebitorRechnungen();
		consoleClient.displaySeperator();

		consoleClient.displayDebitorenRechnung(3);
		consoleClient.displaySeperator();

		consoleClient.deleteDebitorenRechnung(3);

		consoleClient.displayAllDebitorRechnungen();
		consoleClient.displaySeperator();

		generateTestData(1, consoleClient);
		consoleClient.displayAllDebitorRechnungen();

		consoleClient.displaySeperator();
		consoleClient.deleteAllDebitorenRechnung();
		consoleClient.displaySeperator();

		consoleClient.displaySeperator();
		consoleClient.displayDebitorenRechnung(1);
		consoleClient.displaySeperator();
	}

}
