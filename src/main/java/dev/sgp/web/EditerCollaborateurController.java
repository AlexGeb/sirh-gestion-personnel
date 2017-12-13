package dev.sgp.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class EditerCollaborateurController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recupere la valeur d'un parametre dont le nom est avecPhoto
		String matricule = req.getParameter("matricule");
		if (matricule == null) {
			resp.sendError(400, "Un matricule est attendu");
		} else {
			resp.setContentType("text/html");
			// code HTML ecrit dans le corps de la reponse
			resp.getWriter().write("<h1>Edition de collaborateur</h1>" + "<p> Matricule :" + matricule + "</p>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recupere la valeur d'un parametre dont le nom est avecPhoto
		BufferedReader reader = req.getReader();
		String body = reader.lines().reduce((l1, l2) -> l1.trim() + l2.trim()).get();
		JSONObject obj = new JSONObject(body);
		String[] keys = { "matricule", "titre", "nom", "prenom" };
		List<String> itemManquants = getItemManquants(obj, keys);
		if (itemManquants.isEmpty()) {
			resp.setContentType("text/html");
			resp.setStatus(201);
			resp.getWriter().write("<h1>\"Creation d’un collaborateur avec les informations suivantes :</h1>" + "<ul>"
					+ "<li>" + getStrFromObj(obj, keys) + "</li>" + "</ul>");
		} else {
			String joinedItemManquant = itemManquants.stream().collect(Collectors.joining(", "));
			resp.sendError(400, "Les paramètres suivant sont incorrects : " + joinedItemManquant);
		}
	}

	private String getStrFromObj(JSONObject obj, String[] keys) {
		List<String> msg = new ArrayList<String>();
		for (int i = 0; i < keys.length; i++) {
			StringBuffer strbuff = new StringBuffer("");
			String key = keys[i];
			if (obj.has(key)) {
				String val = (String) obj.get(keys[i]);
				if (val != null) {
					strbuff.append(key).append(":").append(val);
					msg.add(strbuff.toString());
				}
			}
		}
		return msg.stream().collect(Collectors.joining(", "));
	}

	private List<String> getItemManquants(JSONObject obj, String[] keys) {
		List<String> manq = new ArrayList<String>();
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (obj.has(key)) {
				if (obj.get(key) == null || obj.get(key).equals("") || obj.get(key).equals("null")
						|| obj.get(key).equals("undefined")) {
					manq.add(key);
				}
			} else {
				manq.add(key);
			}
		}
		return manq;
	}
}
