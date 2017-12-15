package dev.sgp.util;

import java.util.ResourceBundle;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.FrequentationService;

public interface Constantes {
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	DepartementService DEPT_SERVICE = new DepartementService();
	FrequentationService FREQ_SERVICE = new FrequentationService();
	final String SOCIETE = ResourceBundle.getBundle("application").getString("societe");
}
