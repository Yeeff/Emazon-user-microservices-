package com.app.emazon_user_microservices.Configuration;

import com.app.emazon_user_microservices.domain.api.IUserServicePort;
import com.app.emazon_user_microservices.domain.api.usecase.UserUseCase;
import com.app.emazon_user_microservices.domain.spi.IUserPersistantPort;
import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.Repository.IUserRepository;
import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.adapters.UserAdapter;
import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.mapper.IUserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Autowired
    private IUserEntityMapper userEntityMapper;
    @Autowired
    private IUserRepository userRepository;

    @Bean
    public IUserServicePort getUserService(){
        return new UserUseCase(getUserAdapter());
    }

    @Bean
    public IUserPersistantPort getUserAdapter(){
       return new UserAdapter(userEntityMapper, userRepository );
    }
}
