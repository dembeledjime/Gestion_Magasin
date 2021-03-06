package com.example.magasin.modele;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "categorie")
public class Categorie {
    
    @Id
    @NotNull
    @Size(min = 2, max = 20)
    private String categorie;
    
    @OneToMany( mappedBy = "categorie" )
    private List<Article> articles = new ArrayList<>();

    @Override
    public String toString() {
        return "Categorie [categorie=" + categorie + ", articles= "+ articles +"]";
    }

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

    
    
}
