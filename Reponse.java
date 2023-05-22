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
public class Reponse {
    
    private int idReponse ;
    private String Text ;
    private String status;
    private int idReclamation ;

    public Reponse() {
    }

    public Reponse(int idReponse, String Text, String status, int idReclamation) {
        this.idReponse = idReponse;
        this.Text = Text;
        this.status = status;
        this.idReclamation = idReclamation;
    }

    public Reponse(String Text, String status, int idReclamation) {
        this.Text = Text;
        this.status = status;
        this.idReclamation = idReclamation;
    }

    public int getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    @Override
    public String toString() {
        return "Reponse{" + "idReponse=" + idReponse + ", Text=" + Text + ", status=" + status + ", idReclamation=" + idReclamation + '}';
    }
    
    
    
    
}
