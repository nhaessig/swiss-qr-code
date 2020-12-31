/**
 * Class implementing a mock implementation for the interface DebitorenRechnungDAO using a HashMap as in-memory data storage.
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 *  
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas H�ssig
 */

package ch.groupone.swissqr.v1.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DebitorenRechnungDAOMock implements DebitorenRechnungDAO {

	/**
	 * set the index value of the debitorenRechnungList
	 */
	private HashMap<String,String[]> debitorenRechnungList = null;
	
	/**
	 * set the index value of the insertCounter
	 */
	private int insertCounter = 0;

	/**
	 * default constructor
	 */
	public DebitorenRechnungDAOMock() {
		this.debitorenRechnungList = new HashMap<String, String[]>();
		this.insertCounter = 0;
	}

	/**
	 * insert a debtor invoice
	 */
	public void insertDebitorenRechnungAsArray(String[] debitorenRechnungData) {
		this.insertCounter++;
		debitorenRechnungData[DEBITORENRECHNUNGID_INDEX] = Integer.toString(insertCounter);
		this.debitorenRechnungList.put(Integer.toString(insertCounter), debitorenRechnungData);
	}

	/**
	 * set debtors invoices by the given value and return as an array
	 * @return String[] debitorenRechnungen
	 */
	public String[] selectDebitorenRechnungAsArray(int debitorenRechnungID) {

		return debitorenRechnungList.get(Integer.toString(debitorenRechnungID));
	}

	/**
	 * set all debtors invoices and return as an array
	 * @return String[] debitorenRechnungen
	 */
	public ArrayList<String[]> selectAllDebitorenRechnungAsArrayList() {
		ArrayList<String[]> debitorenRechnungen = new ArrayList<String[]>();
		
		Map<String, String[]> map = debitorenRechnungList;
		Iterator<Map.Entry<String, String[]>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<String, String[]> entry = entries.next();
		    debitorenRechnungen.add(entry.getValue());
		}
			
		return debitorenRechnungen; 
	}
	
	/**
	 * deletes debtors invoice by the given value
	 * @param int debitorenRechnungID
	 */
	public void deleteDebitorenRechnung(int debitorenRechnungID) {

		debitorenRechnungList.remove(Integer.toString(debitorenRechnungID));
	}
	
	/**
	 * deletes all debtors invoice
	 */
	public void deleteAllDebitorenRechnung() {
		debitorenRechnungList.clear();
	}
}
