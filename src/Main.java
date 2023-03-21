import Controller.CandidatController;
import Model.*;
import View.Auth1;
import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        //Initialisation des paramètres de connexion


        //Création d'un objet controller
        CandidatController ctl1 = new CandidatController();

        //Appel du controller
        ctl1.LancementApplication();

    }
}