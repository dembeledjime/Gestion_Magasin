package com.example.magasin.modele;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import lombok.Data;


@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ligne_de_cmd {
		
    public Ligne_de_cmd() {
		super();
		
	}

	public Ligne_de_cmd(float prix, int quantity, Commande commande, Article article) {
		super();
		this.prix = prix;
		this.quantity = quantity;
		this.commande = commande;
		this.article = article;
	}

	@Id
    private float prix;
    private int quantity;
    
    @ManyToOne
    @JoinColumn( name = "commande" )
    private Commande commande;
    
    @ManyToOne
    @JoinColumn( name = "article" )
    private Article article;

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Ligne_de_cmd [prix=" + prix + ", quantity=" + quantity + ", commande=" + commande + ", article="
				+ article + "]";
	}
    
    

}
