package lk.ijse.notescollectorbackend.controller;

import lk.ijse.notescollectorbackend.customStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.notescollectorbackend.dto.NoteStatus;
import lk.ijse.notescollectorbackend.dto.impl.NoteDTO;
import lk.ijse.notescollectorbackend.dto.impl.UserDTO;
import lk.ijse.notescollectorbackend.exception.DataPersistException;
import lk.ijse.notescollectorbackend.service.NoteService;
import lk.ijse.notescollectorbackend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

//@RestController magin NoteController class eka Application Context ekata danwa(spring ta manage karanna puluwan object ekak bawata path karnwa)
@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    //meke endpoint 5 k open karala thiyenawa
    public ResponseEntity<Void> saveNote(@RequestBody NoteDTO noteDTO){
        //noteDTO.setNoteId(AppUtil.generateNoteId()); meka gihin demma NoteServiceImpl ekata(ekath business logic ekak)
        try {
            noteService.saveNote(noteDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteStatus getSelectedNote(@PathVariable ("noteId") String noteId){
        String regexForUserID = "^NOTE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(noteId);
        if (!regexMatcher.matches()) {
            return new SelectedUserAndNoteErrorStatus(1,"Note ID is not valid");
        }
        return noteService.getNote(noteId);
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
