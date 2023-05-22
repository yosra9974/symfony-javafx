/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entites.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author dell
 */
public class ServiceReclamation {
    Connection cnx;

    public ServiceReclamation(Connection cnx) {
        this.cnx = cnx;
    }
    
     public void ajouter(Reclamation m) {
        try {
            String req = "INSERT INTO `reclamation`(`idReclamation`, `nom`, `prenom`, `email`, `screenshot`, `numero_mobile`, `date_creation`, `date_traitement`, `description`, `status`, `nomServcie`) VALUES ('"+m.getIdReclamation()+"','"+m.getNom()+"','"+m.getPrenom()+"','"+m.getEmail()+"','"+m.getScreenshot()+"','"+m.getNumero_mobile()+"','"+m.getDate_creation()+"','"+m.getDate_traitement()+"','"+m.getDescription()+"','"+m.getStatus()+"','"+m.getNomServcie()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Produit Ajouter avec succés");
        //    MailService sem = new MailService();
        //    sem.sendEmail("Mail", "Ajouter Article", "un nouvelle Article a ete Ajouter");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void supprimer(int id) {
            System.out.println(id);
                try {
            String req = "DELETE FROM `reclamation` WHERE `idReclamation` ="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("recalamtion supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        
        
        public void modifier(Reclamation m) {
          
      try {
            String req="UPDATE `reclamation` SET `nom`=?,`prenom`=?,`email`=?,`screenshot`=?,`numero_mobile`=?,`date_creation`=?,`date_traitement`=?,`description`=?,`status`=? ,`nomServcie`=? WHERE `idReclamation` ="+m.getIdReclamation();
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, m.getNom());
            st.setString(2, m.getPrenom());
            st.setString(3, m.getEmail());
            st.setString(4, m.getScreenshot());
            st.setString(5, m.getNumero_mobile());
            st.setDate(6, m.getDate_creation());
            st.setDate(7, m.getDate_traitement());
            st.setString(8, m.getDescription());
            st.setString(9, m.getStatus());
            st.setString(10, m.getNomServcie());
            st.executeUpdate();
            System.out.println("recalamtion Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  }
        
        
                public void modifierStatus(int id , String m) {
          
      try {
            String req="UPDATE `reclamation` SET `status`=?  WHERE `idReclamation` ="+id;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, m);
         
            st.executeUpdate();
            System.out.println("status Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  }
    public ObservableList<Reclamation> getAll() {
         String rep = "SELECT * FROM `reclamation`";
        ObservableList<Reclamation> l = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Reclamation m = new  Reclamation();
                m.setIdReclamation(rs.getInt(1));
                m.setNom(rs.getString(2));
                m.setPrenom(rs.getString(3));
                m.setEmail(rs.getString(4));
                m.setScreenshot(rs.getString(5));
                m.setNumero_mobile(rs.getString(6));
                m.setDate_creation(rs.getDate(7));
                m.setDate_traitement(rs.getDate(8));
                m.setDescription(rs.getString(9));
                m.setStatus(rs.getString(10));
                m.setNomServcie(rs.getString(11));
                l.add(m);
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(l+"\n");
        return l;
    }
}
