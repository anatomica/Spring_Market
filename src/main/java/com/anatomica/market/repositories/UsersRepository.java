package com.anatomica.market.repositories;

import com.anatomica.market.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByPhone(String phone);
    Optional<User> findOneByEmail(String email);
    List<User> findAllByEmailContains(String email);
    boolean existsByPhone(String phone);
}