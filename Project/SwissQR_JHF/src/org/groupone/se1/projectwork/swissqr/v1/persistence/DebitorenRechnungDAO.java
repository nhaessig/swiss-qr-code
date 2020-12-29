package org.groupone.se1.projectwork.swissqr.v1.persistence;

import java.util.ArrayList;

public interface DebitorenRechnungDAO {

	public void insertDebitorenRechnungAsArrayList(ArrayList<String> debitorenRechnungData);

	public ArrayList<String> selectDebitorenRechnungAsArrayList(int debitorenRechnungID);
	
	public void deleteDebitorenRechnung(int debitorenRechnungID);

}
