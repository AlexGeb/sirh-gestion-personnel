package dev.sgp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

public class FormValidator {
	private List<String> keys;
	private HttpServletRequest req;

	public FormValidator(List<String> keys, HttpServletRequest req) {
		this.keys = keys;
		this.req = req;
	}

	private Map<String, String> formData = new HashMap<>(11);

	public Map<String, String> getFormData() {
		return formData;
	}

	public List<String> validate() {
		List<String> erreurs = new ArrayList<>();
		// champs obligatoires
		for (String key : keys) {
			String value = req.getParameter(key);
			if (value == null || value.equals("")) {
				erreurs.add(key);
			} else if (key.equals("num_secu_sociale")) {
				if (value.length() != 15) {
					erreurs.add(key);
				} else {
					formData.put(key, value);
				}
			} else {
				formData.put(key, value);
			}
		}
		return erreurs;
	}

	public String formatFormData() {
		return getStrFromMap(formData);
	}

	private String getStrFromMap(Map<String, String> obj) {
		List<String> msg = new ArrayList<>();
		obj.forEach((key, val) -> {
			StringBuilder strbuff = new StringBuilder();
			strbuff.append(key).append(":").append(val);
			msg.add(strbuff.toString());
		});
		return msg.stream().collect(Collectors.joining(", "));
	}

	public static boolean isNotNullAndNotEmpty(String str) {
		return str != null && !str.trim().isEmpty();
	}
}
