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

public class EditerCollaborateurController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		Optional<Collaborateur> collab = collabService.queryByMatricule(matricule);
		req.setAttribute("collaborateur", collab.orElse(null));
		req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> keyValue = new HashMap<String, String>();
		List<String> itemManquants = new ArrayList<String>();
		// champs obligatoires :
		for (String key : collabService.KEYS) {
			String value = req.getParameter(key);
			if (value == null || value.equals("")) {
				itemManquants.add(key);
			} else {
				keyValue.put(key, value);
			}
		}
		// champs optionnels
		for (String key : collabService.OPTIONAL_KEYS) {
			String value = req.getParameter(key);
			if (value != null && !value.equals("")) {
				keyValue.put(key, value);
			}
		}

		if (itemManquants.isEmpty()) {
			Collaborateur collab = collabService.newCollabFromHashMap(keyValue);
			collabService.sauvegarderCollaborateur(collab);

			System.out
					.println("Creation d’un collaborateur avec les informations suivantes :" + getStrFromObj(keyValue));

			resp.setStatus(201);
			resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");
		} else {
			String joinedItemManquant = itemManquants.stream().collect(Collectors.joining(", "));
			resp.sendError(400, "Les paramètres suivant sont incorrects : " + joinedItemManquant);
		}
	}

	private String getStrFromObj(Map<String, String> obj) {
		List<String> msg = new ArrayList<String>();
		obj.forEach((key, val) -> {
			StringBuilder strbuff = new StringBuilder();
			strbuff.append(key).append(":").append(val);
			msg.add(strbuff.toString());
		});
		return msg.stream().collect(Collectors.joining(", "));
	}
}
