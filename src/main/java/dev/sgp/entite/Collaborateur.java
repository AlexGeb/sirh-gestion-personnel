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

	/**
	 * initialisation des valeurs par defauts actif = true dateHeureCreation =
	 * ZonedDateTime.now() photo = default-avatar.png matricule = un random mixé
	 * avec le timestamp phone = unknown
	 */
	private Collaborateur() {
		this.actif = true;
		this.dateHeureCreation = ZonedDateTime.now();
		this.intitulePoste = "employé";
		this.photo = "default-avatar.png";
		// random generated matricule :
		this.matricule = String.format("%x", (long) (Math.random() * LocalDate.now().toEpochDay())).toUpperCase();
		this.phone = "unknown";
	}

	/**
	 * Valorise le nom, le prenom et l'emailPro tel que emailPro =
	 * prenom.nom@societe.com
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Collaborateur(String nom, String prenom) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.emailPro = prenom.toLowerCase() + "." + nom.toLowerCase() + "@" + SOCIETE + ".com";
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
		this(nom, prenom);
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.num_secu_sociale = num_secu_sociale;
		this.intitulePoste = initulePoste;
		this.departement = departement;
	}

	/**
	 * @return le matricule du collaborateur
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return le nom du collaborateur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return le prenom du collaborateur
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return la date de naissance du collaborateur
	 */
	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	/**
	 * @param date_naissance
	 */
	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	/**
	 * @return l'adresse du collaborateur
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return le numero de secu sociale (15 caractères)
	 */
	public String getNum_secu_sociale() {
		return num_secu_sociale;
	}

	/**
	 * @param num_secu_sociale
	 *            (15 caractères)
	 */
	public void setNum_secu_sociale(String num_secu_sociale) {
		this.num_secu_sociale = num_secu_sociale;
	}

	/**
	 * @return emailPro (prenom.nom@societe.com)
	 */
	public String getEmailPro() {
		return emailPro;
	}

	/**
	 * @param emailPro
	 */
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	/**
	 * @return le nom de la photo, de la forme : "photoname.extension"
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return dateHeureCreation
	 */
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * @param dateHeureCreation
	 */
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**
	 * @return if collaborateur is actif or not
	 */
	public Boolean isActif() {
		return actif;
	}

	/**
	 * @param actif
	 */
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
