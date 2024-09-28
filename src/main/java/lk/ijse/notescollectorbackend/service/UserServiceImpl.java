package lk.ijse.notescollectorbackend.service;

import lk.ijse.notescollectorbackend.dao.UserDAO;
import lk.ijse.notescollectorbackend.dto.impl.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return userDAO.save();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getUser() {
        return null;
    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }
}
