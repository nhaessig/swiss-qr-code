
package ch.groupone.swissqr.v1.test.base;

/**
 * Base class for the testing of the SwissQRRechnungsManagerApp containing reused static variables and functions
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */
public class DebitorenRechnungTestBase {

	// Constants for values
	public final static String EXPECTED_BETRAG_1 = "12.55";
	public final static String EXPECTED_ZAHLUNGSEMPFAENGER_1 = "BormAg";
	public final static String EXPECTED_ZAHLUNGSPFLICHTIGER_1 = "Hans Meier";

	public final static String EXPECTED_BETRAG_2 = "42.00";
	public final static String EXPECTED_ZAHLUNGSEMPFAENGER_2 = "Susanne Reisser";
	public final static String EXPECTED_ZAHLUNGSPFLICHTIGER_2 = "SixFinance";

	public final static String EXPECTED_BETRAG_3 = "999.90";
	public final static String EXPECTED_ZAHLUNGSEMPFAENGER_3 = "Garry Gold";
	public final static String EXPECTED_ZAHLUNGSPFLICHTIGER_3 = "Las Miranda";
	
	// Helper function to create a DebitorRechnungsArray
	public static String[] createDebitorenRechnungAsArray(String betrag, String zahlungsempfaenger, String zahlungspflichtiger)
	{
		// debitorenRechnungId is set by the DAO, thats why it is created here as "0"
		String[] mediaDataAsArray = {"0", betrag, zahlungsempfaenger, zahlungspflichtiger};
		return mediaDataAsArray;
	}
}