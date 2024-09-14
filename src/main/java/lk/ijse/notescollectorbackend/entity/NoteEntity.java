package lk.ijse.notescollectorbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteEntity implements SuperEntity{
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createDate;
    private String  priorityLevel;
    private String userId;
}
