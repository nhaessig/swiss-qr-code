/**
 * Class implementing a mock implementation for the interface DebitorenRechnungDAO using a HashMap as in-memory data storage.
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 *  
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */

package ch.groupone.swissqr.v1.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DebitorenRechnungDAOMock implements DebitorenRechnungDAO {

	private HashMap<String,String[]> debitorenRechnungList = null;
	private int insertCounter = 0;

	public DebitorenRechnungDAOMock() {
		this.debitorenRechnungList = new HashMap<String, String[]>();
		this.insertCounter = 0;
	}

	public void insertDebitorenRechnungAsArray(String[] debitorenRechnungData) {

		this.insertCounter++;
		debitorenRechnungData[DEBITORENRECHNUNGID_INDEX] = Integer.toString(insertCounter);
		this.debitorenRechnungList.put(Integer.toString(insertCounter), debitorenRechnungData);
	}

	public String[] selectDebitorenRechnungAsArray(int debitorenRechnungID) {

		return debitorenRechnungList.get(Integer.toString(debitorenRechnungID));
	}

	public ArrayList<String[]> selectAllDebitorenRechnungAsArrayList()
	{
		ArrayList<String[]> debitorenRechnungen = new ArrayList<String[]>();
		
		Map<String, String[]> map = debitorenRechnungList;
		Iterator<Map.Entry<String, String[]>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<String, String[]> entry = entries.next();
		    debitorenRechnungen.add(entry.getValue());
		}
			
		return debitorenRechnungen; 
	}
	
	public void deleteDebitorenRechnung(int debitorenRechnungID) {

		debitorenRechnungList.remove(Integer.toString(debitorenRechnungID));
	}
	
	public void deleteAllDebitorenRechnung()
	{
		debitorenRechnungList.clear();
	}
}
