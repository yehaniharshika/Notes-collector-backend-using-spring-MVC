package lk.ijse.notescollectorbackend.service;

import lk.ijse.notescollectorbackend.dto.NoteStatus;
import lk.ijse.notescollectorbackend.dto.impl.NoteDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNote(String noteId);
    void updateNote(String noteId,NoteDTO noteDTO);
    void deleteNote(String noteId);

}
