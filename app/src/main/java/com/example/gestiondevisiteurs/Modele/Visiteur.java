package com.example.gestiondevisiteurs.Modele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gestiondevisiteurs.R;

public class Visiteur {

    private String id;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private String adresse;
    private String cp;
    private String ville;
    private String dateEmbauche;


    public Visiteur(String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, String dateEmbauche) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse=adresse;
        this.cp=cp;
        this.login=login;
        this.dateEmbauche=dateEmbauche;
        this.ville=ville;
        this.mdp=mdp;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getville() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String toString(){
        return id+"  "+nom+"  "+prenom;
    }


    public String afficher() {
        return "Visiteur{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", adresse='" + adresse + '\'' +
                ", cp='" + cp + '\'' +
                ", ville='" + ville + '\'' +
                ", dateEmbauche='" + dateEmbauche + '\'' +
                '}';
    }
}
