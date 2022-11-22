package com.amenity_reservation_system.repos;

import com.amenity_reservation_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUsername(String username);
}
