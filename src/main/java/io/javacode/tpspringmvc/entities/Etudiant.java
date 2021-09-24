package io.javacode.tpspringmvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nom", length = 30)
    private String nom;
    private Date dateNaissance;
    private String email;
    private String photo;

    public Etudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Etudiant(String nom, Date dateNaissance, String email, String photo) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.photo = photo;
    }

    //--- GETTERS ---
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    //--- SETTERS ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
