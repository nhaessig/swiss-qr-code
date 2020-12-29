package ch.groupone.swissqr.v1.persistence;

import java.util.ArrayList;

public interface DebitorenRechnungDAO {
	
	public final static int BETRAG_INDEX = 0;	
	public final static int ZAHLUNGSEMPFAENGER_INDEX = 1;
	public final static int ZAHLUNGSPFLICHTIGER_INDEX = 2;
	
	public void insertDebitorenRechnungAsArray(String[] debitorenRechnungData);

	public String[] selectDebitorenRechnungAsArray(int debitorenRechnungID);
	
	public ArrayList<String[]> selectAllDebitorenRechnungAsArrayList();
	
	public void deleteDebitorenRechnung(int debitorenRechnungID);

}
