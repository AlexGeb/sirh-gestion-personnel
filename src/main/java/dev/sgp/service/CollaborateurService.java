package dev.sgp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {
	public final List<String> KEYS = Arrays.asList("nom", "prenom", "date_naissance", "adresse", "num_secu_sociale");

	private List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}

	public Collaborateur newCollabFromHashMap(Map<String, String> keyValue) {
		Collaborateur collab = new Collaborateur();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		collab.setDate_naissance(LocalDate.parse(keyValue.get("date_naissance"), formatter));
		collab.setAdresse(keyValue.get("adresse"));
		collab.setNom(keyValue.get("nom"));
		collab.setPrenom(keyValue.get("prenom"));
		collab.setNum_secu_sociale("num_secu_sociale");
		String emailPro = collab.getPrenom() + "." + collab.getNom() + "@societe.com";
		collab.setEmailPro(emailPro);

		return collab;
	}

}
