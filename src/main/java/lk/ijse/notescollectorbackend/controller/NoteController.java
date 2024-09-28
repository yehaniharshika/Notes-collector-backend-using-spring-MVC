package lk.ijse.notescollectorbackend.controller;

import lk.ijse.notescollectorbackend.dto.impl.NoteDTO;
import lk.ijse.notescollectorbackend.service.NoteService;
import lk.ijse.notescollectorbackend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController magin NoteController class eka Application Context ekata danwa(spring ta manage karanna puluwan object ekak bawata path karnwa)
@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)


    //meke endpoint 5 k open karala thiyenawa
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO){
        //noteDTO.setNoteId(AppUtil.generateNoteId()); meka gihin demma NoteServiceImpl ekata(ekath business logic ekak)

        //direct methana service layer ekata call karala thiyenwa
        noteService.saveNote(noteDTO);
        return noteDTO;
    }
    public NoteDTO getSelectedNote(){
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes(){
        return noteService.getAllNotes();
    }

    public void  deleteNote(String noteId){

    }

    public void updateNote(String noteId){

    }
}
