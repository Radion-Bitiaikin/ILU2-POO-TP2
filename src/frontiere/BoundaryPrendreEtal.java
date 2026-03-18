package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		// TODO a completer
	}

	private void installerVendeur(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un etal.");
			if (controlPrendreEtal.resteEtals()) {
				System.out.println("Desole " + nomVendeur + "je n'ai plus d'etal qui ne soit pas deja occupe.");
			}
		} else {
			System.out.println("Je suis desole " + nomVendeur
					+ " mais il faut etre un habitant de notre village pour commercer ici.");
		}
	}
}
