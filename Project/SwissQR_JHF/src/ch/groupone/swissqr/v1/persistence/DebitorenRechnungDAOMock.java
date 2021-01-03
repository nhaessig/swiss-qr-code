package ch.groupone.swissqr.v1.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class implementing a mock implementation for the interface DebitorenRechnungDAO using a HashMap as in-memory data storage.
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 *  
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas H�ssig
 */
public class DebitorenRechnungDAOMock implements DebitorenRechnungDAO {

	// Class members
	/**
	 * container for debitorenRechnungen
	 */
	private HashMap<String,String[]> debitorenRechnungList = null;
	private int insertCounter = 0;

	// Constructors
	/**
	 * Default constructor
	 */
	public DebitorenRechnungDAOMock() {
		this.debitorenRechnungList = new HashMap<String, String[]>();
		this.insertCounter = 0;
	}

	// Class functions
	/**
	 * Saves the debitorenRechnungData in memory
	 * @param String[] debitorenRechnungData
	 */
	public void insertDebitorenRechnungAsArray(String[] debitorenRechnungData) {
		this.insertCounter++;
		debitorenRechnungData[DEBITORENRECHNUNGID_INDEX] = Integer.toString(insertCounter);
		this.debitorenRechnungList.put(Integer.toString(insertCounter), debitorenRechnungData);
	}

	/**
	 * Selects the debitorenRechnungData by the given id from memory
	 * @return String[] debitorenRechnungen
	 */
	public String[] selectDebitorenRechnungAsArray(int debitorenRechnungID) {

		return debitorenRechnungList.get(Integer.toString(debitorenRechnungID));
	}

	/**
	 * Selects all the debitorenRechnungData which are in the memory
	 * @return ArrayList<String[]> debitorenRechnungen
	 */
	public ArrayList<String[]> selectAllDebitorenRechnungAsArrayList() {
		ArrayList<String[]> debitorenRechnungen = new ArrayList<String[]>();
		
		// We don't want to pass the debitorenRechnungList reference outside this class, so this is a copy (also without the not needed index)
		Map<String, String[]> map = debitorenRechnungList;
		Iterator<Map.Entry<String, String[]>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<String, String[]> entry = entries.next();
		    debitorenRechnungen.add(entry.getValue());
		}
			
		return debitorenRechnungen; 
	}
	
	/**
	 * Deletes the debtors invoice by the given value
	 * @param int debitorenRechnungID
	 */
	public void deleteDebitorenRechnung(int debitorenRechnungID) {

		debitorenRechnungList.remove(Integer.toString(debitorenRechnungID));
	}
	
	/**
	 * Deletes all debtors invoice from memory
	 */
	public void deleteAllDebitorenRechnung() {
		debitorenRechnungList.clear();
	}
}
