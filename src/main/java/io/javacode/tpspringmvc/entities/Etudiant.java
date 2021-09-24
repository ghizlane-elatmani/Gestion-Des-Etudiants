package io.javacode.tpspringmvc.entities;

import java.util.Date;

public class Etudiant {

    private Long id;
    private String nom;
    private Date dateNaissance;
    private String email;
    private byte[] photo;

    public Etudiant() {
    }

    public Etudiant(String nom, Date dateNaissance, String email, byte[] photo) {
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

    public byte[] getPhoto() {
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

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}