package com.acn.agile.repository;

import com.acn.agile.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private static final String VALID_USER = "agile-team";
    private static final String VALID_PASSWORD = "123456";

    public User getUserByIdAndPass(String userId, String password) {
        if (userId.equalsIgnoreCase(VALID_USER) && password.equals(VALID_PASSWORD)) {
            return new User("agile-team", "Agile Division ACN", 25, "fakemail@acn.com");
        } else {
            return null;
        }
    }

    public boolean getUserById(String userId) {
        return userId.equalsIgnoreCase(VALID_USER);
    }
}
