package lk.ijse.notescollectorbackend.util;

import lk.ijse.notescollectorbackend.dto.impl.UserDTO;
import lk.ijse.notescollectorbackend.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//api hdana object spring ta manage karanna denne @Component annotation eka use karala
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //For User-mapping
    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,UserEntity.class);
    }

    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity,UserDTO.class);
    }
}
