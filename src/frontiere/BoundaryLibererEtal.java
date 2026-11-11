package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		String[] resultat = controlLibererEtal.libererEtal(nomVendeur);
		if(resultat == null) {
			System.out.println("Mais vous n’êtes pas inscrit sur notre marché aujourd’hui !");
		} else {
			System.out.println("Vous avez vendu " + resultat[4] + " sur " + resultat[3] + " " + resultat[2] + ".");
			System.out.println("Au revoir " + resultat[1] + " passez une bonne journée.");
		}
	}

}
