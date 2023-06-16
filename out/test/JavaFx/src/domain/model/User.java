package domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String NOM_UTILISATEUR;
    int CIN;
    String MOT_DE_PASSE;
    String ROLE ;
    public User(int CIN ,String MOT_DE_PASSE){}
}
