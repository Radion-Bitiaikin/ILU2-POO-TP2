package frontiere;

import controleur.ControlAcheterProduit;
import villagegaulois.Village;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit;
		String[] vendeurs;
		int reponse;

		if (!controlAcheterProduit.verifierAcheteur(nomAcheteur)) {
			System.out.println("Je suis desole " + nomAcheteur
					+ " mais il faut etre un habitant de notre village pour commercer ici.");
			return;
		}

		produit = Clavier.entrerChaine("Quel produit voulez-vous acheter?");

		vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
		if(vendeurs.length==0) {
			System.out.println("Desole, personne ne vend ce produit au marche.");
			return;
		}
		
		System.out.println("Chez quel commercant voulez-vous acheter des " + produit + "?");
		for(int i=0; i<vendeurs.length; i++) {
			System.out.println(i+1 + " - " + vendeurs[i]);
		}
		
		reponse = Clavier.entrerEntier("");
		if(reponse < 1 || reponse > vendeurs.length) {
			return;
		}
		
		System.out.println(nomAcheteur + " se deplace jusqu'a l'etal du vendeur " + vendeurs[reponse] + "\nBonjour " + nomAcheteur);
	}
}
