package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;
import dev.sgp.util.FormValidator;

public class EditerCollaborateurController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		Collaborateur collab = collabService.queryByMatricule(matricule).orElse(null);
		if (collab == null || matricule == null) {
			resp.sendError(400, "Matricule inconnu ou non spécifié");
		} else {
			req.setAttribute("collaborateur", collab);
			req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FormValidator validator = new FormValidator();
		List<String> itemManquants = validator.validate(req);
		Map<String, String> keyValue = validator.getFormData();
		if (itemManquants.isEmpty()) {
			String matricule = req.getParameter("matricule");
			collabService.modifyCollaborateur(matricule, keyValue);
			resp.setStatus(201);
			resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");
		} else {
			String joinedItemManquant = itemManquants.stream().collect(Collectors.joining(", "));
			resp.sendError(400, "Les paramètres suivant sont incorrects : " + joinedItemManquant);
		}
	}
}
