package org.groupone.se1.projectwork.swissqr.v1.business;

public abstract class AbstractDebitorenRechnung implements DebitorenRechnung {

	private double betrag = 0.0;

	public AbstractDebitorenRechnung() {
		this.betrag = 0.0;
	}

	public AbstractDebitorenRechnung(double betrag) {
		this.betrag = betrag;
	}

	public final double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

}
