package View;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Auth1 extends JFrame{
    private JPasswordField pfPassword;
    private JTextField tfLogin;
    private JButton annulerButton;
    private JButton confirmerButton;
    private JPanel authPanel;


    public void showView() {
        setTitle("Connexion");
        setSize(550, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setContentPane(authPanel);
        setLocationRelativeTo(null);
    }


    public JPasswordField getPfPassword() {
        return pfPassword;
    }

    public void setPfPassword(JPasswordField pfPassword) {
        this.pfPassword = pfPassword;
    }

    public JButton getConfirmerButton() {
        return confirmerButton;
    }

    public JTextField getTfLogin() {
        return tfLogin;
    }

    public void setTfLogin(JTextField tfLogin) {
        this.tfLogin = tfLogin;
    }

    public void addConfirmerListener(ActionListener listener) {
        confirmerButton.addActionListener(listener);
    }

    public String getLogin() {
        return tfLogin.getText();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

}