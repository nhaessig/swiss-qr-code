package org.groupone.se1.projectwork.swissqr.v1.business;

import java.util.ArrayList;

import org.groupone.se1.projectwork.swissqr.v1.persistence.DebitorenRechnungDAO;
import org.groupone.se1.projectwork.swissqr.v1.persistence.DebitorenRechnungDAOFactory;

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

	public DebitorenRechnung createDebitorenRechnung(double dBetrag, String iban) {
		return new BCDebitorenRechnungQRIBAN(dBetrag, iban);
	}

	public void saveDebitorenRechnung(DebitorenRechnung debitorenRechnung) {

		this.debitorenRechnungDAO.insertDebitorenRechnungAsArray(convertDebitorenRechnungToArray(debitorenRechnung));
	}

	public void deleteDebitorenRechnung(int debitorenRechnungID) {
		this.debitorenRechnungDAO.deleteDebitorenRechnung(debitorenRechnungID);
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
		String[] debitorenRechnungData = new String[1];
		debitorenRechnungData[DebitorenRechnungDAO.BETRAG_INDEX] = Double.toString(debitorenRechnung.getBetrag());
		return debitorenRechnungData;
	}

	public DebitorenRechnung convertArrayToDebitorenRechnung(String[] debitorenRechnungData) {

		try {
			return createDebitorenRechnung(Double.parseDouble(debitorenRechnungData[DebitorenRechnungDAO.BETRAG_INDEX]),
					"");

		} catch (Exception e) {
			return null;
		}
	}

}