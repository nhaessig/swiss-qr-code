package ch.groupone.swissqr.v1.test.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO;
import ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAOFactory;
import ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase;

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
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.DEBITORENRECHNUNGID_INDEX;
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.ZAHLUNGSEMPFAENGER_INDEX;
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.ZAHLUNGSPFLICHTIGER_INDEX;

/**
 * Test class for SwissQRRechnungsManagerApp persistence logic
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */
public class DebitorenRechnungDAOTest {

	// Class members
	private DebitorenRechnungDAOFactory debitorenRechnungDAOFactory = null;
	private DebitorenRechnungDAO debitorenRechnungDAO = null;

	@BeforeEach
	void setUp() throws Exception {
		//Getting the singletons
		debitorenRechnungDAOFactory = DebitorenRechnungDAOFactory.getInstance();
		debitorenRechnungDAO = debitorenRechnungDAOFactory.createDebitorenRechnungDAOMock();
	}

	// Check if the proper debitorenRechnungsId is set after saving in memory
	@Test
	public void testIfDebitorenIdIsSetAfterInsert() {

		String[] debitorenRechnungData_Inserted = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(
				EXPECTED_BETRAG_1, EXPECTED_ZAHLUNGSEMPFAENGER_1, EXPECTED_ZAHLUNGSPFLICHTIGER_1);
		String[] debitorenRechnungData_NotInserted = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_1, EXPECTED_ZAHLUNGSEMPFAENGER_1, EXPECTED_ZAHLUNGSPFLICHTIGER_1);

		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_Inserted);

		assertEquals("Expected to be 0", Integer.parseInt(debitorenRechnungData_NotInserted[DEBITORENRECHNUNGID_INDEX]), 0);
		assertEquals("Expected to be 1", Integer.parseInt(debitorenRechnungData_Inserted[DEBITORENRECHNUNGID_INDEX]), 1);

	}

	// Check if single debitorenRechnungData is properly inserted in memory and selected from memory
	@Test
	public void testInsertAndSelectDebitorenRechnungAsArray() {

		String[] debitorenRechnungData_1 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_1,
				EXPECTED_ZAHLUNGSEMPFAENGER_1, EXPECTED_ZAHLUNGSPFLICHTIGER_1);
		String[] debitorenRechnungData_2 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_2,
				EXPECTED_ZAHLUNGSEMPFAENGER_2, EXPECTED_ZAHLUNGSPFLICHTIGER_2);
		String[] debitorenRechnungData_3 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_3,
				EXPECTED_ZAHLUNGSEMPFAENGER_3, EXPECTED_ZAHLUNGSPFLICHTIGER_3);

		String[][] expectedDebitorenRechnungen = { debitorenRechnungData_1, debitorenRechnungData_2,
				debitorenRechnungData_3 };

		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_1);
		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_2);
		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_3);

		for (int i = 0; i < expectedDebitorenRechnungen.length; i++) {

			String[] dDebitorenRechnungenToTest = debitorenRechnungDAO.selectDebitorenRechnungAsArray(i + 1);

			assertNotNull("Expected to exist", dDebitorenRechnungenToTest);
			assertTrue("Expected Betrag to be the same",
					expectedDebitorenRechnungen[i][BETRAG_INDEX].equals(dDebitorenRechnungenToTest[BETRAG_INDEX]));
			assertTrue("Expected Zahlungspflichtiger to be the same",
					expectedDebitorenRechnungen[i][ZAHLUNGSPFLICHTIGER_INDEX]
							.equals(dDebitorenRechnungenToTest[ZAHLUNGSPFLICHTIGER_INDEX]));
			assertTrue("Expected Zahlungsempfaenger to be the same",
					expectedDebitorenRechnungen[i][ZAHLUNGSEMPFAENGER_INDEX]
							.equals(dDebitorenRechnungenToTest[ZAHLUNGSEMPFAENGER_INDEX]));
			assertTrue("Expected PrimeryId to be the same", expectedDebitorenRechnungen[i][DEBITORENRECHNUNGID_INDEX]
					.equals(dDebitorenRechnungenToTest[DEBITORENRECHNUNGID_INDEX]));
			assertTrue("Expected PrimeryId to be 2",
					dDebitorenRechnungenToTest[DEBITORENRECHNUNGID_INDEX].equals(Integer.toString(i + 1)));
		}
	}

	// Test if the selectAllDebitorenRechnungAsArrayList returns the correct values
	@Test
	public void testSelectAllDebitorenRechnungAsArrayList() {

		String[] debitorenRechnungData_1 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_1,
				EXPECTED_ZAHLUNGSEMPFAENGER_1, EXPECTED_ZAHLUNGSPFLICHTIGER_1);
		String[] debitorenRechnungData_2 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_2,
				EXPECTED_ZAHLUNGSEMPFAENGER_2, EXPECTED_ZAHLUNGSPFLICHTIGER_2);
		String[] debitorenRechnungData_3 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_3,
				EXPECTED_ZAHLUNGSEMPFAENGER_3, EXPECTED_ZAHLUNGSPFLICHTIGER_3);

		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_1);
		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_2);
		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_3);

		ArrayList<String[]> selectedDebitorRechnungData = debitorenRechnungDAO.selectAllDebitorenRechnungAsArrayList();

		assertEquals("Expected to be 3", selectedDebitorRechnungData.size(), 3);
		assertTrue("Expected Betrag to be the same",
				debitorenRechnungData_1[BETRAG_INDEX].equals(selectedDebitorRechnungData.get(0)[BETRAG_INDEX]));
		assertTrue("Expected Zahlungspflichtiger to be the same", debitorenRechnungData_2[ZAHLUNGSPFLICHTIGER_INDEX]
				.equals(selectedDebitorRechnungData.get(1)[ZAHLUNGSPFLICHTIGER_INDEX]));
		assertTrue("Expected Zahlungsempfaenger to be the same", debitorenRechnungData_3[ZAHLUNGSEMPFAENGER_INDEX]
				.equals(selectedDebitorRechnungData.get(2)[ZAHLUNGSEMPFAENGER_INDEX]));
	}

	// Test for deleting single entries
	@Test
	public void testDeleteDebitorenRechnung() {
		String[] debitorenRechnungData_1 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_1,
				EXPECTED_ZAHLUNGSEMPFAENGER_1, EXPECTED_ZAHLUNGSPFLICHTIGER_1);
		String[] debitorenRechnungData_2 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_2,
				EXPECTED_ZAHLUNGSEMPFAENGER_2, EXPECTED_ZAHLUNGSPFLICHTIGER_2);
		String[] debitorenRechnungData_3 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_3,
				EXPECTED_ZAHLUNGSEMPFAENGER_3, EXPECTED_ZAHLUNGSPFLICHTIGER_3);

		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_1);
		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_2);
		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_3);

		debitorenRechnungDAO.deleteDebitorenRechnung(2);

		assertEquals("Expected size to be 2", debitorenRechnungDAO.selectAllDebitorenRechnungAsArrayList().size(), 2);
		assertNull("Expected to be deleted", debitorenRechnungDAO.selectDebitorenRechnungAsArray(2));
	}

	// Test for deleting all entries
	@Test
	public void testDeleteAllDebitorenRechnung() {

		String[] debitorenRechnungData_1 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_1,
				EXPECTED_ZAHLUNGSEMPFAENGER_1, EXPECTED_ZAHLUNGSPFLICHTIGER_1);
		String[] debitorenRechnungData_2 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_2,
				EXPECTED_ZAHLUNGSEMPFAENGER_2, EXPECTED_ZAHLUNGSPFLICHTIGER_2);
		String[] debitorenRechnungData_3 = DebitorenRechnungTestBase.createDebitorenRechnungAsArray(EXPECTED_BETRAG_3,
				EXPECTED_ZAHLUNGSEMPFAENGER_3, EXPECTED_ZAHLUNGSPFLICHTIGER_3);

		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_1);
		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_2);
		debitorenRechnungDAO.insertDebitorenRechnungAsArray(debitorenRechnungData_3);

		debitorenRechnungDAO.deleteAllDebitorenRechnung();

		assertEquals("Expected to be empty", debitorenRechnungDAO.selectAllDebitorenRechnungAsArrayList().size(), 0);
	}

}
