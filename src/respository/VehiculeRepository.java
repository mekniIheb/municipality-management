package respository;

import domain.model.Vehicule;

import java.sql.SQLException;
import java.util.List;

public interface VehiculeRepository {
    void addVehicule(Vehicule v) throws SQLException;
    void deleteVehicule(int matricule);
    void updateVehicule(Vehicule v);
    List<Vehicule> getAllVehicule();
    Vehicule getVehicule(int matricule);
}
