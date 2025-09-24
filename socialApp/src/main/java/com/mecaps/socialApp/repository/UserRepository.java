package com.mecaps.socialApp.repository;

import com.mecaps.socialApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO -> Data Access Object Layer
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
