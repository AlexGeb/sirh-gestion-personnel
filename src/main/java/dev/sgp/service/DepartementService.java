package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.sgp.entite.Departement;

public class DepartementService {
	private List<Departement> listeDepartements = new ArrayList<>();

	public List<Departement> getListeDepartements() {
		return listeDepartements;
	}

	public Optional<Departement> getDeptByName(String nom_dept) {
		if (nom_dept == null)
			return Optional.ofNullable(null);
		return listeDepartements.stream()
				.filter((dept) -> nom_dept.trim().toLowerCase().equals(dept.getNom().trim().toLowerCase())).findFirst();
	}

	public void ajouterDept(Departement dept) {
		listeDepartements.add(dept);
	}
}
