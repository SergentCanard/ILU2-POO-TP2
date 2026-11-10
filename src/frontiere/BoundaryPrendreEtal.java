package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
    private ControlPrendreEtal controlPrendreEtal;

    public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
        this.controlPrendreEtal = controlChercherEtal;
    }

    public void prendreEtal(String nomVendeur) {
    	//TODO a completer

        if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
            System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
        } else {

            System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");

            if (!controlPrendreEtal.resteEtals()) {
                System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
            } else {
                installerVendeur(nomVendeur);
            }
        }
    }

    private void installerVendeur(String nomVendeur) {
    	//TODO a completer

        System.out.println("C'est parfait, il me reste un étal pour vous !\n Il me faudrait quelques renseignements :");
        System.out.println("");

        System.out.println("Quel produit souhaitez-vous vendre ?");
        String produit = Clavier.entrerClavierString();

        System.out.println("Combien souhaitez-vous en vendre ?");
        int nbProduit = Clavier.entrerEntier();

        int numeroEtal = controlPrendreEtal.prendreEtal(
            nomVendeur, produit, nbProduit
        );

        if (numeroEtal != -1) {
            System.out.println("Le vendeur " + nomVendeur
                + " s'est installé à l'étal n°" + numeroEtal);
        }
    }
}