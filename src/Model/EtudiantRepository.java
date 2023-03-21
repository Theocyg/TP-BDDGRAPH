package Model;

import Controller.CandidatController;
import View.Contact;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EtudiantRepository {
    private Contact view;
    private final Connection connection = Connexion.getConnection();

    private String nom;
    private String prenom;
    private Date dateNaiss;
    private String lieuNaiss;
    private String nationalite;
    private String rue;
    private String ville;
    private String mail;
    private String telephone;
    private String hobbies;
    private String sexe;
    private String niveau;
    private String bac;
    private String filiere;
    private int cp;

    public EtudiantRepository(String nom, String prenom, Date dateNaissance, String lieuNaissance, String nationalite, String rue, String ville, String mail, String telephone, String sexe, String niveau, String bac, String filiere, int cp) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaissance;
        this.lieuNaiss = lieuNaissance;
        this.nationalite = nationalite;
        this.rue = rue;
        this.ville = ville;
        this.mail = mail;
        this.telephone = telephone;
        this.sexe = sexe;
        this.niveau = niveau;
        this.bac = bac;
        this.hobbies = "";
        this.filiere = filiere;
        this.cp = cp;
    }
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance='" + dateNaiss + '\'' +
                ", lieuNaissance='" + lieuNaiss + '\'' +
                ", Nationalite='" + nationalite + '\'' +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", loisirs='" + hobbies + '\'' +
                ", cp=" + cp +
                ", sexe='" + sexe + '\'' +
                ", niveau='" + niveau + '\'' +
                ", filiere=" + filiere +
                ", bac=" + bac +
                '}';
    }



    public int insertEtudiant(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        int resultSet;

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "INSERT INTO etudiant (idBac, idFil,  nom, prenom, dateNaiss, lieuNaiss, sexe, nationalite, rue, cp,  ville, telephone, mail, niveau,loisir) VALUES ((SELECT idBac FROM bac WHERE libelle = ?), (SELECT idFil FROM filiere WHERE nom = ?), ?, ?,?,?,?,?,?,?,?,?,?,?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bac);
            preparedStatement.setString(2, filiere);
            preparedStatement.setString(3, nom);
            preparedStatement.setString(4, prenom);
            preparedStatement.setString(5, simpleDateFormat.format(dateNaiss));
            preparedStatement.setString(6, lieuNaiss);
            preparedStatement.setString(7, sexe);
            preparedStatement.setString(8, nationalite);
            preparedStatement.setString(9, rue);
            preparedStatement.setInt(10, cp);
            preparedStatement.setString(11, ville);
            preparedStatement.setString(12, telephone);
            preparedStatement.setString(13, mail);
            preparedStatement.setString(14, niveau);
            preparedStatement.setString(15, hobbies);
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /*
    public ResultSet checkEtudiantInDataBase(Connection connection) {
        java.sql.PreparedStatement pstmt;
        ResultSet resultSet = null;
        try {
            String request = "SELECT count(*) FROM etudiant WHERE (nom = ? AND prenom = ? AND dateNaiss = ? AND lieuNaiss = ?) OR telephone = ?";
            pstmt = connection.prepareStatement(request);
            pstmt.setString(1, this.nom);
            pstmt.setString(2, this.prenom);
            pstmt.setString(3, this.dateNaiss.toString());
            pstmt.setString(4, this.lieuNaiss);
            pstmt.setString(5, this.telephone);
            resultSet = pstmt.executeQuery();
            System.out.println(resultSet);
        } catch (SQLException e) {
            System.out.println("Erreur lors du chargement " + e.getMessage());
        }
        return resultSet;
    }

     */
}
