package lk.ijse.notescollectorbackend.service;

import lk.ijse.notescollectorbackend.customStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.notescollectorbackend.dao.UserDAO;
import lk.ijse.notescollectorbackend.dto.UserStatus;
import lk.ijse.notescollectorbackend.dto.impl.UserDTO;
import lk.ijse.notescollectorbackend.entity.UserEntity;
import lk.ijse.notescollectorbackend.exception.DataPersistException;
import lk.ijse.notescollectorbackend.exception.UserNotFoundException;
import lk.ijse.notescollectorbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        /*UserEntity saveUser = userDAO.save(mapping.toUserEntity(userDTO));
        return mapping.toUserDTO(saveUser);*/
        UserEntity saveUser = userDAO.save(mapping.toUserEntity(userDTO));

        if (saveUser == null){
            throw new DataPersistException("User not saved");
        }
        //return mapping.toUserDTO(userDAO.save(mapping.toUserEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userDAO.findAll();
        return mapping.asUserDTOList(allUsers);
    }

    /*@Override
    public UserDTO getUser(String userId) {
        UserEntity selectedUser = userDAO.getReferenceById(userId);
        return mapping.toUserDTO(selectedUser);
    }*/
    @Override
    public UserStatus getUser(String userId) {
        if(userDAO.existsById(userId)){
            UserEntity selectedUser = userDAO.getReferenceById(userId);
            return mapping.toUserDTO(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2, "User with id " + userId + " not found");
        }
    }


    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        //findUser =  tmpUser
        Optional<UserEntity> tmpUser = userDAO.findById(userId);

        if (tmpUser.isPresent()){
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
    }

    @Override
    public void deleteUser(String userId) {
        //userDAO.deleteById(userId);
        Optional<UserEntity> existedUser = userDAO.findById(userId);
        if(!existedUser.isPresent()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }else {
            userDAO.deleteById(userId);
        }
    }
}
