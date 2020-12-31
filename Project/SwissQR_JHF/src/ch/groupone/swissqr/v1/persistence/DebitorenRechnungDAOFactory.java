package ch.groupone.swissqr.v1.persistence;

/**
 * Class implementing a factory for DAOs of customer invoices (Debitorenrechnung)
 * Please note that all accounting specific terms are written in German because it is an exclusive project for accounting in Switzerland
 * 
 * @author Fabrizio Piacente, Markus Kaufmann, Nicolas H�ssig
 */
public class DebitorenRechnungDAOFactory {

	// Class members (singleton)
	/**
	 * the singleton instance 
	 */
	private static final DebitorenRechnungDAOFactory INSTANCE = new DebitorenRechnungDAOFactory();

	// Construcotrs
	/**
	 * default constructor
	 */
	private DebitorenRechnungDAOFactory() {
	}

	// Singleton getter
	/**
	 * @return DebitorenRechnungDAOFactory Singelton
	 */
	public static DebitorenRechnungDAOFactory getInstance() {
		return DebitorenRechnungDAOFactory.INSTANCE;
	}

	// Class functions
	/**
	 * Creation of DebitorenRechnungDAOMock
	 * @return DebitorenRechnungDAOMock
	 */
	public DebitorenRechnungDAOMock createDebitorenRechnungDAOMock() {
		return new DebitorenRechnungDAOMock();
	}

}
