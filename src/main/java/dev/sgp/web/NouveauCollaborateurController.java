package dev.sgp.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;
import dev.sgp.util.FormValidator;

@WebServlet(urlPatterns = { "/collaborateurs/nouveau" })
public class NouveauCollaborateurController extends HttpServlet {
	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private static final Logger LOG = LoggerFactory.getLogger(NouveauCollaborateurController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<String> keys = Arrays.asList("nom", "prenom", "date_naissance", "adresse", "num_secu_sociale", "phone");
		FormValidator validator = new FormValidator(keys, req);
		List<String> itemManquants = validator.validate();
		Map<String, String> keyValue = validator.getFormData();
		if (itemManquants.isEmpty()) {
			Collaborateur collab = collabService.newCollabFromHashMap(keyValue);
			collabService.sauvegarderCollaborateur(collab);
			LOG.debug("Creation d’un collaborateur avec les informations suivantes :" + validator.formatFormData());
			resp.setStatus(201);
			resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");
		} else {
			String joinedItemManquant = itemManquants.stream().collect(Collectors.joining(", "));
			resp.sendError(400, "Les paramètres suivant sont incorrects : " + joinedItemManquant);
		}
	}
}
