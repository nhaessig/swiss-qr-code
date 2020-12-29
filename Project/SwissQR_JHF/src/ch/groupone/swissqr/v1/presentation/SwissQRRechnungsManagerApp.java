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
	}

}
