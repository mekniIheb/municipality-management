package service;

import controller.ControlUtils;
import domain.model.Personel;
import lombok.SneakyThrows;
import respository.PersonelRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonelService implements PersonelRepository {


    @Override
    @SneakyThrows
    public void addPersonel(Personel p) {
        String sqlQuery = "INSERT INTO \"PERSONNEL\" (CIN, NOM, PRENOM, NUMERO, ADRESSE) VALUES (?,?,?,?,?);";
        PreparedStatement preStm = ConnectionUtils.createPrepareStatement(sqlQuery);
        preStm.setString(1, String.valueOf(p.getCin()));
        preStm.setString(2, p.getNom());
        preStm.setString(3, p.getPrenom());
        preStm.setString(4, String.valueOf(p.getNumero()));
        preStm.setString(5, p.getAddress());
        preStm.executeUpdate();
        ConnectionUtils.cloneConnection(preStm.getConnection());

    }

    @Override
    @SneakyThrows
    public void deletePersonel(int cin) {
        String sqlQuery = "DELETE * FROM \"PERSONNEL\" WHERE CIN =?;";
        PreparedStatement preStm = ConnectionUtils.createPrepareStatement(sqlQuery);
        preStm.setString(1, String.valueOf(cin));
        preStm.execute();
        ConnectionUtils.cloneConnection(preStm.getConnection());
    }

    @Override
    public void updatePersonel(Personel p) {


    }

    @Override
    @SneakyThrows
    public List<Personel> getAllPersonels() {
        String sqlQuery = "SELECT * FROM \"PERSONNEL\"";
        PreparedStatement preStm = ConnectionUtils.createPrepareStatement(sqlQuery);
        ResultSet rs = preStm.executeQuery();
        List<Personel> ps = new ArrayList<>();
        while (rs.next()) {
            Personel p = new Personel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5));
            ps.add(p);
        }
        ConnectionUtils.cloneConnection(preStm.getConnection());
        return ps;
    }

    @Override
    public Personel getPersonel(int cin) {
        return null;
    }
}
