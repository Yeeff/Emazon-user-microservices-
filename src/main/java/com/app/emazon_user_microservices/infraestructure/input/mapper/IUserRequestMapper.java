package com.app.emazon_user_microservices.infraestructure.input.mapper;

import com.app.emazon_user_microservices.domain.model.UserModel;
import com.app.emazon_user_microservices.infraestructure.input.dto.AddUserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserRequestMapper {
     UserModel addRequestToUserModel(AddUserRequest addUserRequest);
}
