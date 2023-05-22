/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.sql.Date;

/**
 *
 * @author dell
 */
public class Reclamation {
    
    private int idReclamation;
    
    private String nom;
    private String prenom;
    private String email;
    private String screenshot;
    private String numero_mobile;
    
    private Date date_creation;
    private Date date_traitement;

    private String description;
    private String status;
    
    private String nomServcie;

    public Reclamation() {
    }

    public Reclamation(int idReclamation, String nom, String prenom, String email, String screenshot, String numero_mobile, Date date_creation, Date date_traitement, String description, String status, String nomServcie) {
        this.idReclamation = idReclamation;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.screenshot = screenshot;
        this.numero_mobile = numero_mobile;
        this.date_creation = date_creation;
        this.date_traitement = date_traitement;
        this.description = description;
        this.status = status;
        this.nomServcie = nomServcie;
    }

    public Reclamation(String nom, String prenom, String email, String screenshot, String numero_mobile, Date date_creation, Date date_traitement, String description, String status, String nomServcie) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.screenshot = screenshot;
        this.numero_mobile = numero_mobile;
        this.date_creation = date_creation;
        this.date_traitement = date_traitement;
        this.description = description;
        this.status = status;
        this.nomServcie = nomServcie;
    }



    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getNumero_mobile() {
        return numero_mobile;
    }

    public void setNumero_mobile(String numero_mobile) {
        this.numero_mobile = numero_mobile;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_traitement() {
        return date_traitement;
    }

    public void setDate_traitement(Date date_traitement) {
        this.date_traitement = date_traitement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomServcie() {
        return nomServcie;
    }

    public void setNomServcie(String nomServcie) {
        this.nomServcie = nomServcie;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }

    
}
