package com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.adapters;

import com.app.emazon_user_microservices.domain.model.UserModel;
import com.app.emazon_user_microservices.domain.spi.IUserPersistantPort;
import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.Repository.IUserRepository;
import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.entity.UserEntity;
import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.mapper.IUserEntityMapper;

public class UserAdapter implements IUserPersistantPort {

    private IUserEntityMapper userEntityMapper;
    private IUserRepository userRepository;

    public UserAdapter(IUserEntityMapper userEntityMapper, IUserRepository userRepository) {
        this.userEntityMapper = userEntityMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserModel userModel) {
        UserEntity user = userEntityMapper.toEntity(userModel) ;
        userRepository.save(user);
    }
}
