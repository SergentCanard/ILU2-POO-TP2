package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
	    if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
	        System.out.println("Je suis désolée " + nomAcheteur
	                + " mais il faut être un habitant de notre village pour commercer ici.");
	        return;
	    }

	    String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
	    String[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);

	    if (vendeurs == null || vendeurs.length == 0) {
	        System.out.println("Désolé, personne ne vend ce produit au marché.");
	        return;
	    }

	    StringBuilder question = new StringBuilder(
	            "Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
	    for (int i = 0; i < vendeurs.length; i++) {
	        question.append(i + 1).append(" - ").append(vendeurs[i]).append("\n");
	    }

	    int choix;
	    do {
	        choix = Clavier.entrerEntier(question.toString());
	        if (choix > vendeurs.length) {
	            System.out.println("Choisissez un numéro dans la liste.");
	        }
	    } while (choix > vendeurs.length);

	    String nomVendeur = vendeurs[choix - 1];
	    System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
	    System.out.println("Bonjour " + nomAcheteur);

	    int quantiteDemandee = Clavier.entrerEntier(
	            "Combien de " + produit + " voulez-vous acheter ?");
	    int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantiteDemandee);

	    if (quantiteAchetee == 0) {
	        System.out.println(nomAcheteur + " veut acheter " + quantiteDemandee + " "
	                + produit + ", malheureusement il n'y en a plus !");
	    } else if (quantiteAchetee < quantiteDemandee) {
	        System.out.println(nomAcheteur + " veut acheter " + quantiteDemandee + " "
	                + produit + ", malheureusement " + nomVendeur + " n'en a plus que "
	                + quantiteAchetee + ". " + nomAcheteur + " achète tout le stock de "
	                + nomVendeur + ".");
	    } else {
	        System.out.println(nomAcheteur + " achète " + quantiteAchetee + " "
	                + produit + " à " + nomVendeur + ".");
	    }
	}
}
