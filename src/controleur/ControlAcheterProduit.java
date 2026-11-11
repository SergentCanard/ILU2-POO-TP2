package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nomVendeur, int nbProduit) {
	    Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	    if (etal == null) {
	        return 0;
	    }
	    return etal.acheterProduit(nbProduit);
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] rechercherVendeursProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if(vendeurs == null) {
			return null;
		} else {
			String[] result = new String[vendeurs.length];
			for(int i = 0; i < vendeurs.length; i++) {
				result[i] = vendeurs[i].getNom();
			}
			return result;
		}
	}
	
}
