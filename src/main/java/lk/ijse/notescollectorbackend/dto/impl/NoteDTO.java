package lk.ijse.notescollectorbackend.dto.impl;

import lk.ijse.notescollectorbackend.dto.NoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements NoteStatus {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createDate;
    private String  priorityLevel;
    private String userId;
}
