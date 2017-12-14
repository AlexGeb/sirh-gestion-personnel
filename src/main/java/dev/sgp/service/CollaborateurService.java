package dev.sgp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.util.Constantes;

public class CollaborateurService {

	public final List<String> KEYS = Arrays.asList("nom", "prenom", "date_naissance", "adresse", "num_secu_sociale");
	public final List<String> OPTIONAL_KEYS = Arrays.asList("phone", "intitulePoste", "departement", "banque", "bic",
			"iban");
	private List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	private final String SOCIETE = Constantes.SOCIETE;

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}

	public void _init(List<Departement> depts) {
		Collaborateur collab1 = new Collaborateur("Doe", "John", LocalDate.now().minusYears(40),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "employé", depts.get(0));
		Collaborateur collab2 = new Collaborateur("Brown", "Jackie", LocalDate.now().minusYears(35),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "employé", depts.get(1));
		Collaborateur collab3 = new Collaborateur("Norris", "Chuck", LocalDate.now().minusYears(52),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "employé", depts.get(2));
		Collaborateur collab4 = new Collaborateur("Pitt", "Brad", LocalDate.now().minusYears(40),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "employé", depts.get(2));
		Collaborateur collab5 = new Collaborateur("Luke", "Lucky", LocalDate.now().minusYears(40),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "employé", depts.get(3));
		Collaborateur collab6 = new Collaborateur("Jumper", "Joly", LocalDate.now().minusYears(40),
				"2 rue de la Paix, 75000 Paris", "123456789123456", "employé", depts.get(0));
		sauvegarderCollaborateur(collab1);
		sauvegarderCollaborateur(collab2);
		sauvegarderCollaborateur(collab3);
		sauvegarderCollaborateur(collab4);
		sauvegarderCollaborateur(collab5);
		sauvegarderCollaborateur(collab6);
	}

	public Collaborateur newCollabFromHashMap(Map<String, String> keyValue) {
		Collaborateur collab = new Collaborateur();
		// champs obligatoires
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		collab.setDate_naissance(LocalDate.parse(keyValue.get("date_naissance"), formatter));
		collab.setAdresse(keyValue.get("adresse"));
		collab.setNom(keyValue.get("nom"));
		collab.setPrenom(keyValue.get("prenom"));
		collab.setNum_secu_sociale(keyValue.get("num_secu_sociale"));
		String emailPro = collab.getPrenom() + "." + collab.getNom() + "@" + SOCIETE + ".com";
		collab.setEmailPro(emailPro);

		// champs optionnels
		if (keyValue.containsKey("phone")) {
			collab.setPhone(keyValue.get("phone"));
		}
		if (keyValue.containsKey("intitulePoste")) {
			collab.setIntitulePoste(keyValue.get("intitulePoste"));
		}
		if (keyValue.containsKey("departement")) {
			Departement dept = Constantes.DEPT_SERVICE.getDeptByName(keyValue.get("departement"));
			collab.setDepartement(dept);
		}
		if (keyValue.containsKey("banque")) {
			collab.setBanque(keyValue.get("banque"));
		}
		if (keyValue.containsKey("bic")) {
			collab.setBic(keyValue.get("bic"));
		}
		if (keyValue.containsKey("iban")) {
			collab.setIban(keyValue.get("iban"));
		}
		return collab;
	}

	public List<Collaborateur> queryByName(String recherche) {
		return listeCollaborateurs.stream().filter(collab -> {
			return collab.getPrenom().toLowerCase().startsWith(recherche.trim().toLowerCase())
					|| collab.getNom().toLowerCase().startsWith(recherche.trim().toLowerCase());
		}).collect(Collectors.toList());
	}

	public List<Collaborateur> queryByDept(String nom_dept) {
		return listeCollaborateurs.stream().filter(collab -> {
			return collab.getDepartement().getNom().equals(nom_dept.trim());
		}).collect(Collectors.toList());
	}

	public Optional<Collaborateur> queryByMatricule(String matricule) {
		return listeCollaborateurs.stream().filter(collab -> collab.getMatricule().equals(matricule)).findFirst();
	}

}
