package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {

	Village village;
	ControlEmmenager controlEmmenager;

	@BeforeEach
	void init() {
		village = new Village("village", 10, 10);
		Chef chef = new Chef("chef", 100, village);
		village.setChef(chef);
		controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("druide", 3, 4, 5);
		controlEmmenager.ajouterGaulois("gaulois", 6);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager);
	}

	@Test
	void testAjouterDruide() {
		Gaulois druide = village.trouverHabitant("druide");
		assertNotNull(druide);
	}

	@Test
	void testAjouterGaulois() {
		Gaulois gaulois = village.trouverHabitant("gaulois");
		assertNotNull(gaulois);
	}

	@Test
	void testIsHabitant() {
		assertTrue(controlEmmenager.isHabitant("druide"));
		assertTrue(controlEmmenager.isHabitant("gaulois"));
		assertFalse(controlEmmenager.isHabitant("fsfhisihoiobfobnsds"));
	}

}
