package org.groupone.se1.projectwork.swissqr.v1.persistence;

import java.util.ArrayList;
import java.util.HashMap;

public class DebitorenRechnungDAOMock implements DebitorenRechnungDAO {

	private HashMap<String, ArrayList<String>> debitorenRechnungList = null;
	private int insertCounter = 0;

	public DebitorenRechnungDAOMock() {
		this.debitorenRechnungList = new HashMap<String, ArrayList<String>>();
		this.insertCounter = 0;
	}

	public void insertDebitorenRechnungAsArrayList(ArrayList<String> debitorenRechnungData) {

		this.insertCounter++;
		this.debitorenRechnungList.put(Integer.toString(insertCounter), debitorenRechnungData);
	}

	public ArrayList<String> selectDebitorenRechnungAsArrayList(int debitorenRechnungID) {

		return debitorenRechnungList.get(Integer.toString(debitorenRechnungID));
	}

	public void deleteDebitorenRechnung(int debitorenRechnungID) {

		debitorenRechnungList.remove(Integer.toString(debitorenRechnungID));
	}

}
