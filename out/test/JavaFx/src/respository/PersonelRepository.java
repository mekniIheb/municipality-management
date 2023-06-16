package respository;

import domain.model.Personel;

import java.util.List;

public interface PersonelRepository {

    void addPersonel(Personel p);
    void deletePersonel(int cin);
    void updatePersonel(Personel p);
    List<Personel> getAllPersonels();
    Personel getPersonel(int cin);

}

//template
//controller
//service
//repositorty
//db