package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import dev.sgp.util.Constantes;

public class Collaborateur {
	private String matricule;
	private String nom;
	private String prenom;
	private LocalDate date_naissance;
	private String adresse;
	private String num_secu_sociale;
	private String emailPro;
	private String photo;
	private ZonedDateTime dateHeureCreation;
	private Boolean actif;
	private String intitulePoste;
	private Departement departement;
	private String phone;
	private String banque;
	private String bic;
	private String iban;

	private final String SOCIETE = Constantes.SOCIETE;

	public Collaborateur() {
		this.actif = true;
		this.dateHeureCreation = ZonedDateTime.now();
		this.photo = "default-avatar.png";
		// random generated matricule :
		this.matricule = String.format("%x", (long) (Math.random() * LocalDate.now().toEpochDay())).toUpperCase();
		this.setPhone("unknown");
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param date_naissance
	 * @param adresse
	 * @param num_secu_sociale
	 * @param initulePoste
	 * @param departement
	 */
	public Collaborateur(String nom, String prenom, LocalDate date_naissance, String adresse, String num_secu_sociale,
			String initulePoste, Departement departement) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.num_secu_sociale = num_secu_sociale;
		this.intitulePoste = initulePoste;
		this.departement = departement;
		String emailPro = prenom + "." + nom + "@" + SOCIETE + ".com".toLowerCase();
		setEmailPro(emailPro);
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNum_secu_sociale() {
		return num_secu_sociale;
	}

	public void setNum_secu_sociale(String num_secu_sociale) {
		this.num_secu_sociale = num_secu_sociale;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public Boolean isActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	/**
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}

	/**
	 * @param departement
	 *            the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the banque
	 */
	public String getBanque() {
		return banque;
	}

	/**
	 * @param banque
	 *            the banque to set
	 */
	public void setBanque(String banque) {
		this.banque = banque;
	}

	/**
	 * @return the bic
	 */
	public String getBic() {
		return bic;
	}

	/**
	 * @param bic
	 *            the bic to set
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}

	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban
	 *            the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return the intitulePoste
	 */
	public String getIntitulePoste() {
		return intitulePoste;
	}

	/**
	 * @param intitulePoste
	 *            the intitulePoste to set
	 */
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}
}
