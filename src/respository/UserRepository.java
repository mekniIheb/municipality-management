package respository;

import domain.model.User;

public interface UserRepository {
    User getUserByCin(int cin);
    User addUser(User u);
}