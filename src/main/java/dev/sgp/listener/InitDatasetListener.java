package dev.sgp.listener;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

@WebListener
public class InitDatasetListener implements ServletContextListener {

	private CollaborateurService collaborateurService = Constantes.COLLAB_SERVICE;
	private DepartementService departementService = Constantes.DEPT_SERVICE;

	@Override
	public void contextDestroyed(ServletContextEvent serv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent serv) {
		Departement compta = new Departement(1, "Comptabilite");
		Departement rh = new Departement(2, "Ressources Humaines");
		Departement info = new Departement(3, "Informatique");
		Departement admin = new Departement(4, "Administratif");
		departementService.ajouterDept(compta);
		departementService.ajouterDept(rh);
		departementService.ajouterDept(info);
		departementService.ajouterDept(admin);

		List<Departement> depts = departementService.getListeDepartements();
		Collaborateur collab1 = new Collaborateur("Doe", "John", LocalDate.now().minusYears(40),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "0123459012");
		collab1.setIntitulePoste("employé");
		collab1.setDepartement(compta);
		Collaborateur collab2 = new Collaborateur("Brown", "Jackie", LocalDate.now().minusYears(35),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "0123459012");
		collab2.setIntitulePoste("employé");
		collab2.setDepartement(rh);
		Collaborateur collab3 = new Collaborateur("Norris", "Chuck", LocalDate.now().minusYears(52),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "0123459012");
		collab3.setIntitulePoste("employé");
		collab3.setDepartement(info);
		collab3.setPhoto("chuck-norris.jpg");
		Collaborateur collab4 = new Collaborateur("Pitt", "Brad", LocalDate.now().minusYears(40),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "0123459012");
		collab4.setIntitulePoste("employé");
		collab4.setDepartement(admin);
		Collaborateur collab5 = new Collaborateur("Lucky", "Luke", LocalDate.now().minusYears(40),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "0123459012");
		collab5.setIntitulePoste("employé");
		collab5.setDepartement(compta);
		Collaborateur collab6 = new Collaborateur("Jumper", "Joly", LocalDate.now().minusYears(40),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "0123459012");
		collab6.setIntitulePoste("employé");
		collab6.setDepartement(info);
		collab6.setPhoto("jolly-jumper.png");

		collaborateurService.sauvegarderCollaborateur(collab1);
		collaborateurService.sauvegarderCollaborateur(collab2);
		collaborateurService.sauvegarderCollaborateur(collab3);
		collaborateurService.sauvegarderCollaborateur(collab4);
		collaborateurService.sauvegarderCollaborateur(collab5);
		collaborateurService.sauvegarderCollaborateur(collab6);
	}

}
