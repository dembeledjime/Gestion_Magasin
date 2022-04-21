package com.example.magasin.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_art")
public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_art;
    @NotBlank
    @Column(unique = true)
    @Size(min = 2, max = 15)
    private String libelle;
    
    @Min(1)
    private float prix;
    @Min(1)
    private int quantity;
    
    private String logo;
    private String description;
    
    @ManyToOne
    @JoinColumn( name = "categorie", referencedColumnName = "categorie" )
    private Categorie categorie;
    
    @OneToMany(mappedBy = "article")
    private List<Panier> panier = new ArrayList<>();
    
    @Override
    public String toString() {
        return "Article [id_art=" + id_art + ", libelle=" + libelle + ", prix=" + prix + ", quantity=" + quantity
                + ", logo=" + logo + ", description=" + description + "]";
    }
    
    public String getDescription() {
        return "Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum.";
    }
    
    public String getImage() {return "/imgArticle/"+logo;}

	public Integer getId_art() {
		return id_art;
	}

	public void setId_art(Integer id_art) {
		this.id_art = id_art;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Panier> getPanier() {
		return panier;
	}

	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    
}
