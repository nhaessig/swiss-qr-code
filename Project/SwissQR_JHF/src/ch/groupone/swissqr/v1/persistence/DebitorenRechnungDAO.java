/**
 * Interface of DAOs for data manipulation related to customer invoices (Debitorenrechnung)
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas Hässig
 */

package ch.groupone.swissqr.v1.persistence;

import java.util.ArrayList;

public interface DebitorenRechnungDAO {
	
	public final static int DEBITORENRECHNUNGID_INDEX = 0;	
	public final static int BETRAG_INDEX = 1;	
	public final static int ZAHLUNGSEMPFAENGER_INDEX = 2;
	public final static int ZAHLUNGSPFLICHTIGER_INDEX = 3;
	
	public void insertDebitorenRechnungAsArray(String[] debitorenRechnungData);

	public String[] selectDebitorenRechnungAsArray(int debitorenRechnungID);
	
	public ArrayList<String[]> selectAllDebitorenRechnungAsArrayList();
	
	public void deleteDebitorenRechnung(int debitorenRechnungID);
	
	public void deleteAllDebitorenRechnung();

}
