package lk.ijse.notescollectorbackend.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createDate;
    private String  priorityLevel;
    private String userId;
}
