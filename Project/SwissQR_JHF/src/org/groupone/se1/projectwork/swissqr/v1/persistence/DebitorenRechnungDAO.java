package org.groupone.se1.projectwork.swissqr.v1.persistence;

import java.util.ArrayList;

public interface DebitorenRechnungDAO {
	
	public final static int BETRAG_INDEX = 0;	
	
	public void insertDebitorenRechnungAsArray(String[] debitorenRechnungData);

	public String[] selectDebitorenRechnungAsArray(int debitorenRechnungID);
	
	public ArrayList<String[]> selectAllDebitorenRechnungAsArrayList();
	
	public void deleteDebitorenRechnung(int debitorenRechnungID);

}
