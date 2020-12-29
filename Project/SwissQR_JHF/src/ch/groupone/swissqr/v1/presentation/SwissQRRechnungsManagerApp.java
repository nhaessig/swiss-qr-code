/**
 * Class containing the main function for the SwissQRRechnungsManagerApp
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas H�ssig
 */


package ch.groupone.swissqr.v1.presentation;

public class SwissQRRechnungsManagerApp {

	public static void main(String[] args) {

		ConsoleClient consoleClient = new ConsoleClient();

		consoleClient.createDebitorenRechnung(120.25, "MonoAg", "Hans Meier", "CH4431999123000889012");
		consoleClient.createDebitorenRechnung(10.50, "MonoAg", "Six Fiance", "CH4231998124010859023");

		consoleClient.displayAllDebitorRechnungen();

		consoleClient.deleteDebitorenRechnung(2);

		consoleClient.createDebitorenRechnung(23.00, "MonoAg", "Treuhand +", "CH4131998124010159011");

		consoleClient.displayDebitorenRechnung(3);
		consoleClient.displayAllDebitorRechnungen();
		
		consoleClient.deleteAllDebitorenRechnung();
		
		consoleClient.createDebitorenRechnung(120.25, "MonoAg", "Hans Meier", "CH4431999123000889012");
		consoleClient.createDebitorenRechnung(10.50, "MonoAg", "Six Fiance", "CH4231998124010859023");
		consoleClient.deleteAllDebitorenRechnung();
		
		
		consoleClient.createDebitorenRechnung(120.25, "MonoAg", "Hans Meier", "CH4431999123000889012");
		consoleClient.createDebitorenRechnung(10.50, "MonoAg", "Six Fiance", "CH4231998124010859023");
		consoleClient.displayAllDebitorRechnungen();
	}

}
