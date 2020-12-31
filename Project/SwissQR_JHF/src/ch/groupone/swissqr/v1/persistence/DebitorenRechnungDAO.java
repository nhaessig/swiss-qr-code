/**
 * Interface of DAOs for data manipulation related to customer invoices (Debitorenrechnung)
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas H�ssig
 */

package ch.groupone.swissqr.v1.persistence;

import java.util.ArrayList;

public interface DebitorenRechnungDAO {
	
	/**
	 * set the index value of the persistence array
	 * @param int DEBITORENRECHNUNGID_INDEX
	 */
	public final static int DEBITORENRECHNUNGID_INDEX = 0;
	
	/**
	 * set the index value of the persistence array
	 * @param int BETRAG_INDEX
	 */
	public final static int BETRAG_INDEX = 1;
	
	/**
	 * set the index value of the persistence array
	 * @param int ZAHLUNGSEMPFAENGER_INDEX
	 */
	public final static int ZAHLUNGSEMPFAENGER_INDEX = 2;
	
	/**
	 * set the index value of the persistence array
	 * @param int ZAHLUNGSPFLICHTIGER_INDEX
	 */
	public final static int ZAHLUNGSPFLICHTIGER_INDEX = 3;
	
	
	/**
	 * insert debtors invoices
	 * @param String debitorenRechnungData
	 */
	public void insertDebitorenRechnungAsArray(String[] debitorenRechnungData);

	/**
	 * returns debtors invoices by the given value as list
	 * @param int debitorenRechnungID
	 * @return String[] 
	 */
	public String[] selectDebitorenRechnungAsArray(int debitorenRechnungID);
	
	/**
	 * returns all debtors invoices as list 
	 * @return String[] 
	 */
	public ArrayList<String[]> selectAllDebitorenRechnungAsArrayList();
	
	/**
	 * delete debtors invoice by the given value
	 * @param int debitorenRechnungID
	 */
	public void deleteDebitorenRechnung(int debitorenRechnungID);
	
	/**
	 * deletes all debtors invoice
	 */
	public void deleteAllDebitorenRechnung();

}
