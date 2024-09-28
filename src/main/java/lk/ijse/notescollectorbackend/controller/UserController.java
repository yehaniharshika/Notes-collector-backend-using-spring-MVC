package lk.ijse.notescollectorbackend.controller;

import lk.ijse.notescollectorbackend.dto.impl.NoteDTO;
import lk.ijse.notescollectorbackend.dto.impl.UserDTO;
import lk.ijse.notescollectorbackend.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName")String lastName,
            @RequestPart("email")String email,
            @RequestPart("password")String password,
            @RequestPart("profilePic")String profilePic
    ) {
        //To Do: Profile pic -----> Base64 format
        /*convert to base64*/
        String base64ProfilePic = AppUtil.profilePicToBase64(profilePic);

        //To Do: user ID generate(meka service layer logic ekk passe ain karanwa)
        String userId = AppUtil.generateUserId();
        //TO Do: Build the object
        var buildUserDTO = new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProfilePic);
        
       return buildUserDTO;
    }
}
