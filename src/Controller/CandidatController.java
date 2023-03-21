package Controller;

import Model.CandidatRepository;
import Model.Connexion;
import Model.EtudiantRepository;
import View.Auth1;
import View.Contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CandidatController {
    private Contact contact = new Contact();
    private final Connection connection = Connexion.getConnection();
    private Auth1 auth1 = new Auth1();

    public CandidatController() {
        setConfirmerBtnComportement();
        setValiderBtnComportement();
    }


    public void LancementApplication() {
        auth1.showView();
    }

    public void LancementFormulaire() {
        contact.showView2();
    }


    public void setConfirmerBtnComportement() {
        auth1.getConfirmerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = auth1.getLogin();
                System.out.println(login);
                String password = auth1.getPassword();
                System.out.println(password);

                CandidatRepository rep1 = new CandidatRepository(login, password);

                // Vérifier si le login et le mot de passe sont non vides
                if (login.trim().isEmpty() || password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(auth1, "Veuillez saisir le login et le mot de passe");
                    return;
                } else if (rep1.authenticate(connection)) {
                    // Connexion réussie, ouvrir l'application
                    LancementFormulaire();
                } else {
                    // Informations de connexion incorrectes, afficher un message d'erreur
                    JOptionPane.showMessageDialog(auth1, "Nom d'utilisateur ou mot de passe incorrect");
                }

            }
        });
    }


        public void setValiderBtnComportement(){
            contact.getValiderButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == contact.getValiderButton()) {
                        // Récupération des valeurs des champs du formulaire
                        String nom = contact.getTfNom().getText();
                        String prenom = contact.getTfPrenom().getText();
                        String dateNaissance = contact.getTfDateNaissance().getText();
                        String lieuNaissance = contact.getTfLieuNaissance().getText();
                        String nationalite = contact.getTfNationalite().getText();
                        String num = contact.getTfNum().getText();
                        String mail = contact.getTfMail().getText();
                        String rue = contact.getTfRue().getText();
                        String cp = contact.getTfCP().getText();
                        String ville = contact.getTfVille().getText();
                        String sexe = contact.getHommeRadioButton().isSelected() ? "Homme" : "Femme";
                        String[] hobbies = {contact.getMusiqueCheckBox().isSelected() ? "Musique" : "",
                                contact.getVoyagesCheckBox().isSelected() ? "Voyages" : "",
                                contact.getSportsCheckBox().isSelected() ? "Sports" : "",
                                contact.getLectureCheckBox().isSelected() ? "Lecture" : ""};
                        String filiere = (String) contact.getFiliereChoix().getSelectedItem();
                        String niveau = (String) contact.getNiveauChoix().getSelectedItem();
                        String bac = (String) contact.getBacChoix().getSelectedItem();

                        // Connexion à la base de données
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddgraph", "root", "");
                            PreparedStatement pst = con.prepareStatement(
                                    "INSERT INTO etudiant (nom, prenom, dateNaissance, lieuNaissance, nationalite, num, mail, rue, cp, ville, sexe, hobbies, filiere, niveau, bac) " +
                                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                            // Attribution des valeurs aux paramètres de la requête
                            pst.setString(1, nom);
                            pst.setString(2, prenom);
                            pst.setString(3, dateNaissance);
                            pst.setString(4, lieuNaissance);
                            pst.setString(5, nationalite);
                            pst.setString(6, num);
                            pst.setString(7, mail);
                            pst.setString(8, rue);
                            pst.setString(9, cp);
                            pst.setString(10, ville);
                            pst.setString(11, sexe);
                            pst.setString(12, String.join(", ", hobbies));
                            pst.setString(13, filiere);
                            pst.setString(14, niveau);
                            pst.setString(15, bac);
                            // Exécution de la requête
                            pst.executeUpdate();
                            // Fermeture de la connexion
                            con.close();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());

                        }
                    }
                }
            });
        }



}
