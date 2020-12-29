/**
 * Class implementing a factory for customer invoice (Debitorenrechnung) implementations
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */

package ch.groupone.swissqr.v1.business;

import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.BETRAG_INDEX;
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.DEBITORENRECHNUNGID_INDEX;
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.ZAHLUNGSEMPFAENGER_INDEX;
import static ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO.ZAHLUNGSPFLICHTIGER_INDEX;

import java.util.ArrayList;

import ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAO;
import ch.groupone.swissqr.v1.persistence.DebitorenRechnungDAOFactory;

public class DebitorenRechnungFactory {

	private static DebitorenRechnungFactory instance = null;
	private DebitorenRechnungDAO debitorenRechnungDAO = null;

	private DebitorenRechnungFactory() {

		this.debitorenRechnungDAO = DebitorenRechnungDAOFactory.getInstance().createDebitorenRechnungDAOMock();
	}

	public static DebitorenRechnungFactory getInstance() {
		if (instance == null) {
			instance = new DebitorenRechnungFactory();
		}

		return instance;
	}

	public DebitorenRechnung createDebitorenRechnung(double dBetrag, String zahlungsempfaenger, String zahlungspflichtiger, String iban) {
		return new BCDebitorenRechnungQRIBAN(dBetrag, zahlungsempfaenger, zahlungspflichtiger, iban);
	}
	
	public DebitorenRechnung createDebitorenRechnungWithDebitorenRechnungID(int debitorenRechnungID, double dBetrag, String zahlungsempfaenger, String zahlungspflichtiger, String iban) {
		return new BCDebitorenRechnungQRIBAN(debitorenRechnungID, dBetrag, zahlungsempfaenger, zahlungspflichtiger, iban);
	}

	public void saveDebitorenRechnung(DebitorenRechnung debitorenRechnung) {

		this.debitorenRechnungDAO.insertDebitorenRechnungAsArray(convertDebitorenRechnungToArray(debitorenRechnung));
	}

	public void deleteDebitorenRechnung(int debitorenRechnungID) {
		this.debitorenRechnungDAO.deleteDebitorenRechnung(debitorenRechnungID);
	}
	
	public void deleteAllDebitorenRechnung() {
		this.debitorenRechnungDAO.deleteAllDebitorenRechnung();
	}

	public DebitorenRechnung selectDebitorenRechnung(int debitorenRechnungID) {

		String[] debitorenRechnungData = this.debitorenRechnungDAO.selectDebitorenRechnungAsArray(debitorenRechnungID);
		return convertArrayToDebitorenRechnung(debitorenRechnungData);
	}

	public ArrayList<DebitorenRechnung> selectAllDebitorenRechnung() {

		ArrayList<DebitorenRechnung> debitorenRechnungen = new ArrayList<DebitorenRechnung>();

		ArrayList<String[]> debitorenRechnungenData = this.debitorenRechnungDAO.selectAllDebitorenRechnungAsArrayList();

		for (String[] data : debitorenRechnungenData) {
			debitorenRechnungen.add(convertArrayToDebitorenRechnung(data));
		}

		return debitorenRechnungen;
	}

	public String[] convertDebitorenRechnungToArray(DebitorenRechnung debitorenRechnung) {
		String[] debitorenRechnungData = new String[4];
		debitorenRechnungData[BETRAG_INDEX] = Double.toString(debitorenRechnung.getBetrag());
		debitorenRechnungData[ZAHLUNGSEMPFAENGER_INDEX] = debitorenRechnung.getZahlungsempfaenger();
		debitorenRechnungData[ZAHLUNGSPFLICHTIGER_INDEX] = debitorenRechnung.getZahlungspflichtiger();
		return debitorenRechnungData;
	}

	public DebitorenRechnung convertArrayToDebitorenRechnung(String[] debitorenRechnungData) {

		try {
			return createDebitorenRechnungWithDebitorenRechnungID(Integer.parseInt(debitorenRechnungData[DEBITORENRECHNUNGID_INDEX]),Double.parseDouble(debitorenRechnungData[DebitorenRechnungDAO.BETRAG_INDEX]), debitorenRechnungData[DebitorenRechnungDAO.ZAHLUNGSEMPFAENGER_INDEX], debitorenRechnungData[DebitorenRechnungDAO.ZAHLUNGSPFLICHTIGER_INDEX],
					"");

		} catch (Exception e) {
			return null;
		}
	}

}
