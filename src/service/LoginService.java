package service;

import controller.ControlUtils;
import domain.model.User;
import lombok.SneakyThrows;
import respository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService implements UserRepository {
    @Override
    @SneakyThrows
    public User getUserByCin(int cin) {
        String query = "SELECT  * FROM \"USER\" WHERE CIN = ?;";
        PreparedStatement preStm = ConnectionUtils.createPrepareStatement(query);
        preStm.setInt(1, cin);
        ResultSet rs = preStm.executeQuery();
        User u = new User();
        while (rs.next()) {
            u.setNOM_UTILISATEUR(rs.getString(1));
            u.setCIN(rs.getInt(2));
            u.setMOT_DE_PASSE(rs.getString(3));
            u.setROLE(rs.getString(4));
        }
        ConnectionUtils.cloneConnection(preStm.getConnection());
        return u;
    }

    @Override
    public User addUser(User u) {
        return null;
    }

    public boolean checkIfLoginValid(User u) {
        User user = getUserByCin(u.getCIN());
        if (user == null) {
            ControlUtils.ErrorDialog("user not found", "NOT FOUND", "the user is not in the db");
        }
        assert user != null;
        return u.getMOT_DE_PASSE().equals(user.getMOT_DE_PASSE());
    }
}
