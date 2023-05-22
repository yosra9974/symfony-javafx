/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entites.Avis;
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
public class ServiceAvis {
    Connection cnx;

    public ServiceAvis(Connection cnx) {
        this.cnx = cnx;
    }
    
     public void ajouter(Avis c) {
        try {
            String req = "INSERT INTO `avis`(`idAvis`, `detailAvisService`, `noteService`, `idArticle`, `idUser`) VALUES ('"+c.getIdAvis()+"','"+c.getDetailAvisService()+"','"+c.getNoteService()+"','"+c.getIdArticle()+"','"+c.getIdUser()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Avis Ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimer(int id) {
                try {
            String req = "DELETE FROM `avis` WHERE `idAvis` = "+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Avis supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
 
            public ObservableList<Avis> getAll() {
         String rep = "SELECT * FROM `avis`";
        ObservableList<Avis> l = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Avis m = new  Avis();
                m.setIdAvis(rs.getInt(1));
                m.setDetailAvisService(rs.getString(2));
                m.setNoteService(rs.getInt(3));
                m.setIdArticle(rs.getInt(4));
                m.setIdUser(rs.getInt(5));
           

                l.add(m);

    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(l+"\n");
        return l;
    }
            
            
                        public ObservableList<Avis> getAllArticle(int id) {
         String rep = "SELECT * FROM `avis` WHERE `idArticle` = " + id;
        ObservableList<Avis> l = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Avis m = new  Avis();
                m.setIdAvis(rs.getInt(1));
                m.setDetailAvisService(rs.getString(2));
                m.setNoteService(rs.getInt(3));
                m.setIdArticle(rs.getInt(4));
                m.setIdUser(rs.getInt(5));
           

                l.add(m);

    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(l+"\n");
        return l;
    }
            
                    
        public void modifier(Avis m) {
          
      try {
            String req="UPDATE `avis` SET `detailAvisService`=?,`noteService`=?,`idArticle`=?,`idUser`=? WHERE `idAvis` ="+m.getIdAvis();
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, m.getDetailAvisService());
            st.setInt(2, m.getNoteService());
            st.setInt(3, m.getIdArticle());
            st.setInt(4, m.getIdUser());
            
            
            st.executeUpdate();
            System.out.println("Avis Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  }

}
