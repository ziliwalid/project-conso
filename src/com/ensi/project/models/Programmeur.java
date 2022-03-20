package com.ensi.project.models;

public class Programmeur {
    private int id;
    private String nom;
    private String prenom;
    private int bureau;

    public Programmeur() {
    }

    public Programmeur(int id, String nom, String prenom, int bureau) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.bureau = bureau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getBureau() {
        return bureau;
    }

    public void setBureau(int bureau) {
        this.bureau = bureau;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", bureau=" + bureau ;
    }

    public void show() {

        System.out.println(this.toString());
    }
}
