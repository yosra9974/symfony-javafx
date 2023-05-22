/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author dell
 */
public class Avis {
    
    private int idAvis ;
    private String detailAvisService ;
    private int noteService ;
    private int idArticle ;
    private int idUser ;

    public Avis(int idAvis, String detailAvisService, int noteService, int idArticle, int idUser) {
        this.idAvis = idAvis;
        this.detailAvisService = detailAvisService;
        this.noteService = noteService;
        this.idArticle = idArticle;
        this.idUser = idUser;
    }

        public Avis() {
    }

    public Avis(String detailAvisService, int noteService, int idArticle, int idUser) {
        this.detailAvisService = detailAvisService;
        this.noteService = noteService;
        this.idArticle = idArticle;
        this.idUser = idUser;
    }
        
    
    public int getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }

    

    public String getDetailAvisService() {
        return detailAvisService;
    }

    public void setDetailAvisService(String detailAvisService) {
        this.detailAvisService = detailAvisService;
    }

    public int getNoteService() {
        return noteService;
    }

    public void setNoteService(int noteService) {
        this.noteService = noteService;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Avis{" + "idAvis=" + idAvis + ", detailAvisService=" + detailAvisService + ", noteService=" + noteService + ", idArticle=" + idArticle + ", idUser=" + idUser + '}';
    }
    
    
    
}
