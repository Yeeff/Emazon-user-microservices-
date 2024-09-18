package com.app.emazon_user_microservices.domain.api.usecase;

import com.app.emazon_user_microservices.domain.api.IUserServicePort;
import com.app.emazon_user_microservices.domain.model.UserModel;
import com.app.emazon_user_microservices.domain.spi.IUserPersistantPort;

public class UserUseCase implements IUserServicePort {
    private IUserPersistantPort userPersistent;

    public UserUseCase(IUserPersistantPort userPersistent) {
        this.userPersistent = userPersistent;
    }

    @Override
    public void addUser(UserModel userModel) {
        userPersistent.addUser(userModel);
    }
}
