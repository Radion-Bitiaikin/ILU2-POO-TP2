package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit;
		String[] vendeurs;
		String vendeur;
		int reponse;
		int quantiteAchete;

		if (!controlAcheterProduit.verifierAcheteur(nomAcheteur)) {
			System.out.println("Je suis desole " + nomAcheteur
					+ " mais il faut etre un habitant de notre village pour commercer ici.");
			return;
		}

		produit = Clavier.entrerChaine("Quel produit voulez-vous acheter?");

		vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
		if (vendeurs.length == 0) {
			System.out.println("Desole, personne ne vend ce produit au marche.");
			return;
		}

		System.out.println("Chez quel commercant voulez-vous acheter des " + produit + "?");
		for (int i = 0; i < vendeurs.length; i++) {
			System.out.println(i + 1 + " - " + vendeurs[i]);
		}

		reponse = Clavier.entrerEntier("")-1;
		if (reponse < 0 || reponse >= vendeurs.length) {
			return;
		}
		vendeur = vendeurs[reponse];

		System.out
				.println(nomAcheteur + " se deplace jusqu'a l'etal du vendeur " + vendeur + "\nBonjour " + nomAcheteur);
		reponse = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter?");
		quantiteAchete = controlAcheterProduit.acheterProduit(vendeur, reponse);

		if (reponse == quantiteAchete) {
			System.out.println(nomAcheteur + " achete " + quantiteAchete + " " + produit + " a " + vendeur);
		} else if (quantiteAchete == 0) {
			System.out.println(
					nomAcheteur + " veut acheter " + reponse + " " + produit + ", malheureusement il y en a plus!");
		} else {
			System.out.println(nomAcheteur + " veut acheter " + reponse + " " + produit + ", malheureusement " + vendeur
					+ " n'en a plus que " + quantiteAchete + ". " + nomAcheteur + " achete tout le stock de " + vendeur
					+ ".");
		}
	}
}
