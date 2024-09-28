package lk.ijse.notescollectorbackend.service;

import lk.ijse.notescollectorbackend.dto.impl.NoteDTO;
import lk.ijse.notescollectorbackend.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUser();
    boolean updateUser(String userId,UserDTO userDTO);
    boolean deleteUser(String userId);
}
