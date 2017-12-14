package dev.sgp.util;

import java.util.ResourceBundle;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

public interface Constantes {
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	DepartementService DEPT_SERVICE = new DepartementService();
	final String SOCIETE = ResourceBundle.getBundle("application").getString("societe");
}
