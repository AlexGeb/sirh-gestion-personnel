package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.sgp.entite.Departement;

public class DepartementService {

	private List<Departement> listeDepartements = new ArrayList<>();

	public DepartementService() {
		Departement compta = new Departement(1, "Comptabilite");
		Departement rh = new Departement(2, "Ressources Humaines");
		Departement info = new Departement(3, "Informatique");
		Departement admin = new Departement(4, "Administratif");
		listeDepartements.add(compta);
		listeDepartements.add(rh);
		listeDepartements.add(info);
		listeDepartements.add(admin);
	}

	public List<Departement> getListeDepartements() {
		return listeDepartements;
	}

	public Optional<Departement> getDeptByName(String nom_dept) {
		return listeDepartements.stream()
				.filter((dept) -> nom_dept.trim().toLowerCase().equals(dept.getNom().trim().toLowerCase())).findFirst();
	}
}
