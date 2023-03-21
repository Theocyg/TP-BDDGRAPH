package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatRepository {
    private String login;
    private String password;

    public CandidatRepository(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean authenticate(Connection conn) {
        String req = "SELECT count(*) FROM utilisateur WHERE login = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(req)) {
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Les informations de connexion sont correctes
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // Les informations de connexion sont incorrectes
        return false;
    }
}
