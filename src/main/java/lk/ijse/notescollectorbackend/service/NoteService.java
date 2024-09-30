package lk.ijse.notescollectorbackend.service;

import lk.ijse.notescollectorbackend.dto.impl.NoteDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteDTO getNote();
    boolean updateNote(String noteId);
    boolean deleteNote(String noteId);

}
