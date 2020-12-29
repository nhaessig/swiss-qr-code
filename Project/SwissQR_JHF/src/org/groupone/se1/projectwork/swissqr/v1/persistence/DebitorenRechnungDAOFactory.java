package org.groupone.se1.projectwork.swissqr.v1.persistence;

public class DebitorenRechnungDAOFactory {

	static final DebitorenRechnungDAOFactory INSTANCE = new DebitorenRechnungDAOFactory();

	private DebitorenRechnungDAOFactory() {
	}

	public static DebitorenRechnungDAOFactory getInstance() {
		return DebitorenRechnungDAOFactory.INSTANCE;
	}

	public DebitorenRechnungDAOMock createDebitorenRechnungDAOMock() {
		return new DebitorenRechnungDAOMock();
	}

}
