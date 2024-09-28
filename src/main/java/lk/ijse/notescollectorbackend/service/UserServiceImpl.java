package lk.ijse.notescollectorbackend.service;

import lk.ijse.notescollectorbackend.dao.UserDAO;
import lk.ijse.notescollectorbackend.dto.impl.UserDTO;
import lk.ijse.notescollectorbackend.entity.UserEntity;
import lk.ijse.notescollectorbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        /*UserEntity saveUser = userDAO.save(mapping.toUserEntity(userDTO));
        return mapping.toUserDTO(saveUser);*/
        return mapping.toUserDTO(userDAO.save(mapping.toUserEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getUser(String userId) {
        UserEntity selectedUser = userDAO.getReferenceById(userId);
        return mapping.toUserDTO(selectedUser);
    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }

    @Override
    public void deleteUser(String userId) {
        userDAO.deleteById(userId);
    }
}
