package ch.groupone.swissqr.v1.test.business;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.groupone.swissqr.v1.business.DebitorenRechnung;
import ch.groupone.swissqr.v1.business.DebitorenRechnungFactory;
import ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase;

import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.BETRAG_INDEX;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_BETRAG_1;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_BETRAG_2;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_BETRAG_3;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSEMPFAENGER_1;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSEMPFAENGER_2;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSEMPFAENGER_3;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSPFLICHTIGER_1;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSPFLICHTIGER_2;
import static ch.groupone.swissqr.v1.test.base.DebitorenRechnungTestBase.EXPECTED_ZAHLUNGSPFLICHTIGER_3;

/**
 * Test class for SwissQRRechnungsManagerApp business logic
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */
public class DebitorenRechnungFactoryTest {

	private DebitorenRechnungFactory debitorenRechnungFactory = null;


	@BeforeEach
	void setUp() throws Exception {
		debitorenRechnungFactory = DebitorenRechnungFactory.getInstance();
	}
	
	@Test
	public void testCreateDebitorenRechnungAsArray() {
		
		DebitorenRechnung debitorenRechnung = debitorenRechnungFactory.createDebitorenRechnung(Double.parseDouble(EXPECTED_BETRAG_1), EXPECTED_ZAHLUNGSEMPFAENGER_1, EXPECTED_ZAHLUNGSPFLICHTIGER_1, "");
		assertEquals(debitorenRechnung.getBetrag(), Double.parseDouble(EXPECTED_BETRAG_1));
		assertEquals(debitorenRechnung.getDebitorenRechnungID(), 0);
		assertTrue("Expected zahlungsempfaenger to be the same", debitorenRechnung.getZahlungsempfaenger().equals(EXPECTED_ZAHLUNGSEMPFAENGER_1));
		assertTrue("Expected zahlungspflichtiger to be the same", debitorenRechnung.getZahlungspflichtiger().equals(EXPECTED_ZAHLUNGSPFLICHTIGER_1));	
	}
	
	@Test
	public void testConvertDebitorenRechnungToArray() {
	}
	
	
	@Test
	public void testSelectAllDebitorenRechnungAsArrayList() {
	}
	
	@Test
	public void testDeleteDebitorenRechnung() {
	}
	
	
	@Test
	public void testDeleteAllDebitorenRechnung()
	{
		
	}
	
}
