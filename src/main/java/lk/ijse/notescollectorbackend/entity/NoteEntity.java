package lk.ijse.notescollectorbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;

@NoArgsConstructor
@AllArgsConstructor
@Data
//Entity ekak kiyala define karanwa
@Entity
@Table(name = "note")
public class NoteEntity implements SuperEntity{
    @Id
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createDate;
    private String  priorityLevel;
    //Note ekak thiyenna be user kenek nethiwa(nullable = false)
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity user;
}
