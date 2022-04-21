package com.example.magasin.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_user")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;  
    
    @Size(min = 2, max = 20)
    @NotNull
    @NotBlank
	private String prenom;
    
    @Size(min = 2, max = 20)
	private String nom;    

    @Size(min = 4, max = 20)
	private String login;

    @Size(min = 4, max = 20)
	private String mdp;

	private String statut = "USER";
	private String avatar;
	
	@NotNull
	private String sexe;
	
	@OneToMany(mappedBy = "user")
    private List<Panier> panier = new ArrayList<>();
	
	@OneToMany( mappedBy = "user" )
	private List<Commande> commandes = new ArrayList<>();

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<Panier> getPanier() {
		return panier;
	}

	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", prenom=" + prenom + ", nom=" + nom + ", login=" + login + ", mdp=" + mdp
				+ ", statut=" + statut + ", avatar=" + avatar + ", sexe=" + sexe + ", panier=" + panier + ", commandes="
				+ commandes + "]";
	}
	
	
	

}
