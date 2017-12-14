package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteWeb;

public class FrequentationService {
	private List<VisiteWeb> visites = new ArrayList<VisiteWeb>();

	public void addVisite(VisiteWeb visite) {
		visites.add(visite);
	}
}
