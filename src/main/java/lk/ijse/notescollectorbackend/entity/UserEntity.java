package lk.ijse.notescollectorbackend.entity;

import jakarta.persistence.*;
import lk.ijse.notescollectorbackend.dto.impl.NoteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity{
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    //unique value ekk daddi mehema danna oni
    @Column(unique = true)
    private String email;
    private String password;
    private String profilePic;
    @OneToMany(mappedBy = "user")
    private List<NoteEntity> notes;
    //NoteDTO eka NoteEntity karanawa methnadi
}
