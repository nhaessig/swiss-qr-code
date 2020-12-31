/**
 * Class implementing a factory for DAOs of customer invoices (Debitorenrechnung)
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas H�ssig
 */

package ch.groupone.swissqr.v1.persistence;

public class DebitorenRechnungDAOFactory {

	/**
	 * the singleton instance 
	 */
	private static final DebitorenRechnungDAOFactory INSTANCE = new DebitorenRechnungDAOFactory();

	/**
	 * default constructor
	 */
	private DebitorenRechnungDAOFactory() {
	}

	/**
	 * @return the Singleton
	 */
	public static DebitorenRechnungDAOFactory getInstance() {
		return DebitorenRechnungDAOFactory.INSTANCE;
	}

	/**
	 * creates concrete DAO
	 * @return DAO
	 */
	public DebitorenRechnungDAOMock createDebitorenRechnungDAOMock() {
		return new DebitorenRechnungDAOMock();
	}

}
