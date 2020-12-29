package org.groupone.se1.projectwork.swissqr.v1.business;

public class MainTestBusiness {

	public static void main(String[] args) {

		
		DebitorenRechnungFactory debiFactory = DebitorenRechnungFactory.getInstance();
		
		debiFactory.saveDebitorenRechnung(debiFactory.createDebitorenRechnung(111, ""));
		debiFactory.saveDebitorenRechnung(debiFactory.createDebitorenRechnung(2222, ""));
		
		DebitorenRechnung bla = debiFactory.getDebitorenRechnung(2);
		
		System.out.print(bla.getBetrag());
		

	}

}
