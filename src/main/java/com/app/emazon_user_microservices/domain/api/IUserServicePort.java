package com.app.emazon_user_microservices.domain.api;

import com.app.emazon_user_microservices.domain.model.UserModel;

public interface IUserServicePort {
    void addUser(UserModel userModel);
}
