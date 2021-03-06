package com.example.magasin.modele;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_cmd")
public class Commande {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cmd;
    private LocalDateTime date_cmd = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn( name = "user" )
    private User user;

    @Override
    public String toString() {
        return "Commande [id_cmd=" + id_cmd + ", date_cmd=" + date_cmd + "]";
    }

	public Integer getId_cmd() {
		return id_cmd;
	}

	public void setId_cmd(Integer id_cmd) {
		this.id_cmd = id_cmd;
	}

	public LocalDateTime getDate_cmd() {
		return date_cmd;
	}

	public void setDate_cmd(LocalDateTime date_cmd) {
		this.date_cmd = date_cmd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    

}
