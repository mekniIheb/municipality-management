package service;

import domain.model.Vehicule;
import lombok.SneakyThrows;
import respository.VehiculeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculeService implements VehiculeRepository {

    @Override
    public void addVehicule(Vehicule v) throws SQLException {
        String sqlQuery = "INSERT INTO Vehicules (matricule, marque, nb_portes, puissance) VALUES (?,?,?,?);";
        PreparedStatement preStm = ConnectionUtils.createPrepareStatement(sqlQuery);
        preStm.setString(1, String.valueOf(v.getMatricule()));
        preStm.setString(2, v.getMarque());
        preStm.setString(3, String.valueOf(v.getNb_portes()));
        preStm.setString(4, String.valueOf(v.getPuissance()));
        preStm.executeUpdate();
        ConnectionUtils.cloneConnection(preStm.getConnection());

    }

    @SneakyThrows
    @Override
    public void deleteVehicule(int matricule) {
        String sqlQuery = "delete * from Vehicules where cin =?;";
        PreparedStatement preStm = ConnectionUtils.createPrepareStatement(sqlQuery);
        preStm.setString(1, String.valueOf(matricule));
        preStm.execute();
        ConnectionUtils.cloneConnection(preStm.getConnection());
    }

    @Override
    public void updateVehicule(Vehicule v) {

    }

    @SneakyThrows
    @Override
    public List<Vehicule> getAllVehicule() {
        String sqlQuery = "select * from Vehicules";
        PreparedStatement preStm = ConnectionUtils.createPrepareStatement(sqlQuery);
        ResultSet rs = preStm.executeQuery();
        List<Vehicule> ps = new ArrayList<>();
        while (rs.next()) {
            Vehicule v = new Vehicule(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4));
            ps.add(v);
        }
        ConnectionUtils.cloneConnection(preStm.getConnection());
        return ps;
    }

    @Override
    public Vehicule getVehicule(int matricule) {
        return null;
    }
}
