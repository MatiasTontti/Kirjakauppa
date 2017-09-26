package com.matias.harjoitus;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository {
    User findByUsername(String username);
}
