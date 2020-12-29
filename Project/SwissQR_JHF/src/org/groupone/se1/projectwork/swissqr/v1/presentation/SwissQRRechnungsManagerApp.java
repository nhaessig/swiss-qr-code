package org.groupone.se1.projectwork.swissqr.v1.presentation;

public class SwissQRRechnungsManagerApp {

	public static void main(String[] args) {

		ConsoleClient consoleClient = new ConsoleClient();
		
		consoleClient.createDebitorenRechnung(120.25, "CH4431999123000889012");
		consoleClient.createDebitorenRechnung(10.50, "CH4231998124010859023");
		
		consoleClient.displayAllDebitorRechnungen();
		
		consoleClient.deleteDebitorenRechnung(2);
		
		consoleClient.displayAllDebitorRechnungen();
	}

}
