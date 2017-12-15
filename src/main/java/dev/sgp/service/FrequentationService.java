package dev.sgp.service;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dev.sgp.entite.VisiteWeb;

public class FrequentationService {
	private List<VisiteWeb> visites = new ArrayList<>();

	public void addVisite(VisiteWeb visite) {
		visites.add(visite);
	}

	public List<VisiteWeb> getVisites() {
		return visites;
	}

	public Map<String, IntSummaryStatistics> getStatsByPath() {
		return visites.stream().collect(Collectors.groupingBy(VisiteWeb::getChemin,Collectors.summarizingInt(VisiteWeb::getTempsExecution)));
	}
}
