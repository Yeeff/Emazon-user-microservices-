package com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.mapper;

import com.app.emazon_user_microservices.domain.model.UserModel;
import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    UserEntity toEntity(UserModel userModel);
}
