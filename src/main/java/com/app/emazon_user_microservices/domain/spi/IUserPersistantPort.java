package com.app.emazon_user_microservices.domain.spi;

import com.app.emazon_user_microservices.domain.model.UserModel;

public interface IUserPersistantPort {
    void addUser(UserModel userModel);
}
