package ch.groupone.swissqr.v1.test.business;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.groupone.swissqr.v1.business.DebitorenRechnung;
import ch.groupone.swissqr.v1.business.DebitorenRechnungFactory;

import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_BETRAG_1;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_BETRAG_2;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_BETRAG_3;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSEMPFAENGER_1;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSEMPFAENGER_2;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSEMPFAENGER_3;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSPFLICHTIGER_1;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSPFLICHTIGER_2;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSPFLICHTIGER_3;
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.BETRAG_INDEX;
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.ZAHLUNGSEMPFAENGER_INDEX;
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.ZAHLUNGSPFLICHTIGER_INDEX;

/**
 * Test class for SwissQRRechnungsManagerApp business logic Please note that all
 * accounting specific terms are written in German because it is an exclusive
 * project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */
public class DebitorenRechnungFactoryTest {

	// Class members
	private DebitorenRechnungFactory debitorenRechnungFactory = null;

	@BeforeEach
	void setUp() throws Exception {
		debitorenRechnungFactory = DebitorenRechnungFactory.getInstance();
	}

	// Test if DebitorenRechnungFactory creates and saves DebitorenRechnung as
	// expected
	@Test
	public void testCreateAndSaveDebitorenRechnungAsArray() {

		DebitorenRechnung debitorenRechnung1 = debitorenRechnungFactory.createDebitorenRechnung(
				Double.parseDouble(EXPECTED_BETRAG_1), EXPECTED_ZAHLUNGSEMPFAENGER_1, EXPECTED_ZAHLUNGSPFLICHTIGER_1,
				"");
		DebitorenRechnung debitorenRechnung2 = debitorenRechnungFactory.createDebitorenRechnung(
				Double.parseDouble(EXPECTED_BETRAG_2), EXPECTED_ZAHLUNGSEMPFAENGER_2, EXPECTED_ZAHLUNGSPFLICHTIGER_2,
				"");
		DebitorenRechnung debitorenRechnung3 = debitorenRechnungFactory.createDebitorenRechnung(
				Double.parseDouble(EXPECTED_BETRAG_3), EXPECTED_ZAHLUNGSEMPFAENGER_3, EXPECTED_ZAHLUNGSPFLICHTIGER_3,
				"");

		DebitorenRechnung[] debitorenRechnungen = { debitorenRechnung1, debitorenRechnung2, debitorenRechnung3 };

		for (int i = 0; i < debitorenRechnungen.length; i++) {

			debitorenRechnungFactory.saveDebitorenRechnung(debitorenRechnungen[i]);

			assertEquals(debitorenRechnungen[i].getBetrag(),
					debitorenRechnungFactory.selectDebitorenRechnung(i + 1).getBetrag());
			assertTrue("Expected zahlungsempfaenger to be the same", debitorenRechnungen[i].getZahlungsempfaenger()
					.equals(debitorenRechnungFactory.selectDebitorenRechnung(i + 1).getZahlungsempfaenger()));
			assertTrue("Expected zahlungspflichtiger to be the same", debitorenRechnungen[i].getZahlungspflichtiger()
					.equals(debitorenRechnungFactory.selectDebitorenRechnung(i + 1).getZahlungspflichtiger()));
		}
	}

	// Test if array is correctly converted to debitorenRechnungData
	@Test
	public void testArrayToDebitorenRechnung() {

		String givenDebitorenRechnungID = "42";
		String[] debitorenRechnungData = { givenDebitorenRechnungID, EXPECTED_BETRAG_1, EXPECTED_ZAHLUNGSEMPFAENGER_1,
				EXPECTED_ZAHLUNGSPFLICHTIGER_1, "" };

		DebitorenRechnung debitorenRechnung = debitorenRechnungFactory
				.convertArrayToDebitorenRechnung(debitorenRechnungData);
		
		assertEquals(debitorenRechnung.getDebitorenRechnungID(),
				Integer.parseInt(givenDebitorenRechnungID));
		assertEquals(debitorenRechnung.getBetrag(),
				Double.parseDouble(EXPECTED_BETRAG_1));
		assertEquals(debitorenRechnung.getZahlungsempfaenger(),
				EXPECTED_ZAHLUNGSEMPFAENGER_1);
		assertEquals(debitorenRechnung.getZahlungspflichtiger(),
				EXPECTED_ZAHLUNGSPFLICHTIGER_1);
	}

	// Test if debitorenRechnungData is correctly converted to array
	@Test
	public void testConvertDebitorenRechnungToArray() {
		DebitorenRechnung debitorenRechnung = debitorenRechnungFactory
				.createDebitorenRechnung(Double.parseDouble(EXPECTED_BETRAG_2), EXPECTED_ZAHLUNGSEMPFAENGER_2, EXPECTED_ZAHLUNGSPFLICHTIGER_2,
				"");
		
		String[] debitorenRechnungData =  debitorenRechnungFactory.convertDebitorenRechnungToArray(debitorenRechnung);
		
		assertEquals(Double.parseDouble(debitorenRechnungData[BETRAG_INDEX]),debitorenRechnung.getBetrag());
		assertEquals(debitorenRechnungData[ZAHLUNGSEMPFAENGER_INDEX],debitorenRechnung.getZahlungsempfaenger());
		assertEquals(debitorenRechnungData[ZAHLUNGSPFLICHTIGER_INDEX],debitorenRechnung.getZahlungspflichtiger());
	}

}
