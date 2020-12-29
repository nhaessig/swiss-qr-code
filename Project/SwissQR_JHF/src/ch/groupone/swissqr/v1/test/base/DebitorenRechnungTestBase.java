package ch.groupone.swissqr.v1.test.base;

public class DebitorenRechnungTestBase {

	public final static String EXPECTED_BETRAG_1 = "12.55";
	public final static String EXPECTED_ZAHLUNGSEMPFAENGER_1 = "BormAg";
	public final static String EXPECTED_ZAHLUNGSPFLICHTIGER_1 = "Hans Meier";

	public final static String EXPECTED_BETRAG_2 = "42.00";
	public final static String EXPECTED_ZAHLUNGSEMPFAENGER_2 = "Susanne Reisser";
	public final static String EXPECTED_ZAHLUNGSPFLICHTIGER_2 = "SixFinance";

	public final static String EXPECTED_BETRAG_3 = "999.90";
	public final static String EXPECTED_ZAHLUNGSEMPFAENGER_3 = "Garry Gold";
	public final static String EXPECTED_ZAHLUNGSPFLICHTIGER_3 = "Las Miranda";
	
	
	public static String[] createDebitorenRechnungAsArray(String betrag, String zahlungsempfaenger, String zahlungspflichtiger)
	{
		String[] mediaDataAsArray = {"0", betrag, zahlungsempfaenger, zahlungspflichtiger};
		return mediaDataAsArray;
	}
}