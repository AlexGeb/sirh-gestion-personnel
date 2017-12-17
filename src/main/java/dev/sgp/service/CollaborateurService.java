package dev.sgp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.util.Constantes;

public class CollaborateurService {
	private static final Logger LOG = LoggerFactory.getLogger(CollaborateurService.class);

	private List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}

	public Collaborateur newCollabFromHashMap(Map<String, String> keyValue) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date_naissance = LocalDate.parse(keyValue.get("date_naissance"), formatter);
		Collaborateur collab = new Collaborateur(keyValue.get("nom"), keyValue.get("prenom"), date_naissance,
				keyValue.get("adresse"), keyValue.get("num_secu_sociale"), keyValue.get("phone"));
		LOG.debug("nouveau collaborateur " + keyValue.get("num_secu_sociale"));
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
			return collab.getDepartement()!=null && collab.getDepartement().getNom().equals(nom_dept);
		}).collect(Collectors.toList());
	} 

	public Optional<Collaborateur> queryByMatricule(String matricule) {
		return listeCollaborateurs.stream().filter(collab -> collab.getMatricule().equals(matricule)).findFirst();
	}

	public void modifyCollaborateur(String matricule, Map<String, String> keyValue) {
		Optional<Collaborateur> collabOpt = queryByMatricule(matricule);
		if (collabOpt.isPresent()) {
			Collaborateur collab = collabOpt.get();
			modifCollabFromHashMap(collab, keyValue);
		}
	}

	public Collaborateur modifCollabFromHashMap(Collaborateur collab, Map<String, String> keyValue) {
		// champs optionnels
		collab.setPhone(keyValue.get("phone"));
		collab.setAdresse(keyValue.get("adresse"));
		collab.setIntitulePoste(keyValue.get("intitulePoste"));
		collab.setBanque(keyValue.get("banque"));
		collab.setBic(keyValue.get("bic"));
		collab.setIban(keyValue.get("iban"));
		String deptname = keyValue.get("departement");
		Optional<Departement> deptOpt = Constantes.DEPT_SERVICE.getDeptByName(deptname);
		if (deptOpt.isPresent()) {
			collab.setDepartement(deptOpt.get());
		}
		return collab;
	}

}
