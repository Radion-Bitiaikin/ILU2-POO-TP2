package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;


public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] rechercherVendeursProduit(String nomProduit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(nomProduit);
		String[] noms = new String[vendeurs.length];
		for (int i = 0; i < vendeurs.length; i++) {
			noms[i] = vendeurs[i].getNom();
		}
		return noms;
	}
	
	public int acheterProduit(String nomVendeur, int quantiteAcheter) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur); 
		return etal.acheterProduit(quantiteAcheter);
	}
}
