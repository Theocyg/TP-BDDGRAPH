package View;
import Model.EtudiantRepository;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;

public class Contact extends JFrame {
    private JTextField tfNom;
    private JTextField tfPrenom;
    private JFormattedTextField tfDateNaissance;
    private JTextField tfLieuNaissance;
    private JTextField tfNationalite;
    private JFormattedTextField tfNum;
    private JTextField tfMail;
    private JTextField tfRue;
    private JFormattedTextField tfCP;
    private JTextField tfVille;
    private JRadioButton hommeRadioButton;
    private JRadioButton femmeRadioButton;
    private JCheckBox musiqueCheckBox;
    private JCheckBox voyagesCheckBox;
    private JCheckBox sportsCheckBox;
    private JCheckBox lectureCheckBox;
    private JComboBox FiliereChoix;
    private JComboBox NiveauChoix;
    private JComboBox BacChoix;
    private JTextField tfAffichage;
    private JButton validerButton;
    private JButton resetButton;
    private JButton quitterButton;
    private JPanel Contact;

    public void showView2() {
        setTitle("Formulaire");
        setSize(850, 445);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setContentPane(Contact);
        setLocationRelativeTo(null);
        JComboBox combo = new JComboBox();
        combo.setBounds(135, 500, 400, 60);
        try {Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/concours","root","");
            Statement St= con.createStatement();
            ResultSet Rs = St.executeQuery("SELECT * FROM Candidat");
            while (Rs.next()) {
                //Pour affecter une valeur de base de données à un Combobox
                combo.addItem(Rs.getString("nom"));}
        }catch(Exception e) {
            System.out.println("Erreur de connexion");
        }

        try{
            String validCharacters = "0123456789";
            MaskFormatter maskTel = new MaskFormatter("+33 # ## ## ## ##");
            MaskFormatter maskDate = new MaskFormatter("####-##-##");
            //maskDate.setPlaceholderCharacter('_');
            MaskFormatter maskcp = new MaskFormatter("#####");
            maskcp.setValidCharacters(validCharacters);
            maskDate.setValidCharacters(validCharacters);
            maskTel.setValidCharacters(validCharacters);
            maskcp.install(tfCP);
            maskTel.install(tfNum);
            maskDate.install(tfDateNaissance);

        } catch(ParseException e){
            e.printStackTrace();
        }
        /*
        MaskFormatter mask = newMaskFormatter("+## # ## ## ## ##");
        mask.setValidCharacters("0123456789");
        JFormattedTextField champ= newJFormattedTextField(mask);

        JFormattedTextField champDate= new JFormattedTextField(DateFormat.getDateInstance()); // Dec 31, 2000 JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT)); // 12/31/2000
         */
    }


    public JButton getQuitterButton() {
        return quitterButton;
    }

    public JCheckBox getMusiqueCheckBox() {
        return musiqueCheckBox;
    }

    public JRadioButton getFemmeRadioButton() {
        return femmeRadioButton;
    }

    public JRadioButton getHommeRadioButton() {
        return hommeRadioButton;
    }

    public JTextField getTfAffichage() {
        return tfAffichage;
    }

    public JCheckBox getSportsCheckBox() {
        return sportsCheckBox;
    }

    public JCheckBox getLectureCheckBox() {
        return lectureCheckBox;
    }

    public JCheckBox getVoyagesCheckBox() {
        return voyagesCheckBox;
    }

    public JComboBox getFiliereChoix() {
        return FiliereChoix;
    }

    public JTextField getTfCP() {
        return tfCP;
    }

    public JTextField getTfDateNaissance() {

        return tfDateNaissance;
        //JFormattedTextField get= newJFormattedTextField(mask);
    }


    public JTextField getTfLieuNaissance() {
        return tfLieuNaissance;
    }

    public JComboBox getNiveauChoix() {
        return NiveauChoix;
    }

    public JButton getValiderButton() {

        return validerButton;
    }


    public JTextField getTfMail() {
        return tfMail;
    }

    public JComboBox getBacChoix() {
        return BacChoix;
    }

    public JTextField getTfNationalite() {
        return tfNationalite;
    }

    public JTextField getTfNom() {
        return tfNom;
    }

    public JTextField getTfNum() {
        return tfNum;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JTextField getTfPrenom() {
        return tfPrenom;
    }

    public JTextField getTfRue() {
        return tfRue;
    }

    public JTextField getTfVille() {
        return tfVille;
    }

    public JPanel getContact() {
        return Contact;
    }

    }








