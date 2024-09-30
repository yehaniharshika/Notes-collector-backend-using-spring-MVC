package lk.ijse.notescollectorbackend.service;

import lk.ijse.notescollectorbackend.dto.UserStatus;
import lk.ijse.notescollectorbackend.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    //UserDTO saveUser(UserDTO userDTO);
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserStatus getUser(String userId);
    void updateUser(String userId,UserDTO userDTO);
    void deleteUser(String userId);
}
