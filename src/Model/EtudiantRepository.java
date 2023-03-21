package Model;

import View.Contact;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EtudiantRepository implements ActionListener {
    private Contact view;
    private final Connection connection = Connexion.getConnection();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getValiderButton()) {
            // Récupération des valeurs des champs du formulaire
            String nom = view.getTfNom().getText();
            String prenom = view.getTfPrenom().getText();
            String dateNaissance = view.getTfDateNaissance().getText();
            String lieuNaissance = view.getTfLieuNaissance().getText();
            String nationalite = view.getTfNationalite().getText();
            String num = view.getTfNum().getText();
            String mail = view.getTfMail().getText();
            String rue = view.getTfRue().getText();
            String cp = view.getTfCP().getText();
            String ville = view.getTfVille().getText();
            String sexe = view.getHommeRadioButton().isSelected() ? "Homme" : "Femme";
            String[] hobbies = {view.getMusiqueCheckBox().isSelected() ? "Musique" : "",
                    view.getVoyagesCheckBox().isSelected() ? "Voyages" : "",
                    view.getSportsCheckBox().isSelected() ? "Sports" : "",
                    view.getLectureCheckBox().isSelected() ? "Lecture" : ""};
            String filiere = (String) view.getFiliereChoix().getSelectedItem();
            String niveau = (String) view.getNiveauChoix().getSelectedItem();
            String bac = (String) view.getBacChoix().getSelectedItem();

            // Connexion à la base de données
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concours", "root", "");

                // Récupération de l'ID de la filière choisie
                pst = con.prepareStatement("SELECT idFil FROM filiere WHERE nom = ?");
                pst.setString(1, filiere);
                rst = pst.executeQuery();
                String idFil = "";

                while (rst.next()) {
                    idFil = rst.getString(1);
                }

                // Récupération de l'ID de la spécialité correspondant au bac choisi
                pst = con.prepareStatement("SELECT idBac FROM bac WHERE libelle = ?");
                pst.setString(1, bac);
                rst = pst.executeQuery();
                String idBac = "";

                while (rst.next()) {
                    idBac = rst.getString(1);
                }


                // Insertion du nouvel étudiant dans la base de données
                pst = con.prepareStatement(
                        "INSERT INTO etudiant (nom, prenom, dateNaiss, lieuNaiss,sexe, nationalite, rue, cp, ville, telephone, mail, hobbies, niveau, idFil, idBac) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                // Attribution des valeurs aux paramètres de la requête
                pst.setString(1, nom);
                pst.setString(2, prenom);
                pst.setString(3, dateNaissance);
                pst.setString(4, lieuNaissance);
                pst.setString(11, sexe);
                pst.setString(5, nationalite);
                pst.setString(8, rue);
                pst.setString(9, cp);
                pst.setString(10, ville);
                pst.setString(6, num);
                pst.setString(7, mail);
                pst.setString(12, String.join(", ", hobbies));
                pst.setString(14, niveau);
                pst.setString(13, idFil);
                pst.setString(15, idBac);
                // Exécution de la requête
                pst.executeUpdate();
                // Fermeture de la connexion
                con.close();

            } catch (Exception ex) {
                System.out.println("Erreur lors de l'insertion de l'étudiant : " + ex.getMessage());
            }

            // Message de confirmation de l'ajout
            JOptionPane.showMessageDialog(view, "L'étudiant a été ajouté avec succès !");
/*
            // Effacement du formulaire
            view.getTfNom().setText("");
            view.getTfPrenom().setText("");
            view.getTfDateNaissance().setText("");
            view.getTfLieuNaissance().setText("");
            view.getTfNationalite().setText("");
            view.getTfNum().setText("");
            view.getTfMail().setText("");
            view.getTfRue().setText("");
            view.getTfCP().setText("");
            view.getTfVille().setText("");
            view.getHommeRadioButton().setSelected(true);
            view.getMusiqueCheckBox().setSelected(false);
            view.getVoyagesCheckBox().setSelected(false);
            view.getSportsCheckBox().setSelected(false);
            view.getLectureCheckBox().setSelected(false);
            view.getFiliereChoix().setSelectedIndex(0);
            view.getNiveauChoix().setSelectedIndex(0);
            view.getBacChoix().setSelectedIndex(0);


 */
        }
    }
}

