package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desole " + nomVendeur
					+ " mais il faut etre un habitant de notre village pour commercer ici.");
			return;
		}

		System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un etal.");

		if (!controlPrendreEtal.resteEtals()) {
			System.out.println("Desole " + nomVendeur + " je n'ai plus d'etal qui ne soit pas deja occupe.");
			return;
		}

		installerVendeur(nomVendeur);
	}

	private void installerVendeur(String nomVendeur) {
		String produit = Clavier.entrerChaine(
				"C'est parfait, il me reste un etal pour vous!\nIl me faudrais quelque renseignements:\nQuel produit souhaitez vous vendre?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (-1 != numeroEtal) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installe a l'etal numero " + numeroEtal);
		}
	}
}
