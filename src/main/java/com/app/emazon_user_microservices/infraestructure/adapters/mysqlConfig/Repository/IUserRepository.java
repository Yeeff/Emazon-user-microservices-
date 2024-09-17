package com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.Repository;


import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByName(String name);




}
