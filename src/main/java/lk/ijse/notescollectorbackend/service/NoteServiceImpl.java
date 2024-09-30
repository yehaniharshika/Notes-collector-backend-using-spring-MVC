package lk.ijse.notescollectorbackend.service;

import lk.ijse.notescollectorbackend.dao.NoteDAO;
import lk.ijse.notescollectorbackend.dao.UserDAO;
import lk.ijse.notescollectorbackend.dto.impl.NoteDTO;
import lk.ijse.notescollectorbackend.entity.NoteEntity;
import lk.ijse.notescollectorbackend.exception.DataPersistException;
import lk.ijse.notescollectorbackend.util.AppUtil;
import lk.ijse.notescollectorbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class NoteServiceImpl implements NoteService{
    private static List<NoteDTO> noteDTOList = new ArrayList<>();
    @Autowired
    private NoteDAO noteDAO;
    @Autowired
    private Mapping noteMapping;

    NoteServiceImpl(){
        noteDTOList.add(new NoteDTO("NOTE-dd4e176c-ce03-4ab3-bc5f-dd3104a073e5","Java","my Java","2024.09.14","priority 1","U002"));
        noteDTOList.add(new NoteDTO("NOTE-dd4e176c-ce03-4ab3-bc5f-dd3104a073e6","Python","my Python","2024.09.14","priority 2","U001"));
        noteDTOList.add(new NoteDTO("NOTE-dd4e176c-ce03-4ab3-bc5f-dd3104a073e7","MySQL","my MySQL","2024.09.14","priority 3","U002"));
        noteDTOList.add(new NoteDTO("NOTE-dd4e176c-ce03-4ab3-bc5f-dd3104a073e8","css","my css","2024.09.13","priority 4","U003"));
    }
    @Override
    public void saveNote(NoteDTO noteDTO) {
        //noteDTO.setNoteId(AppUtil.generateNoteId());
        noteDTO.setNoteId(AppUtil.generateNoteId());
        NoteEntity savedNote =
                noteDAO.save(noteMapping.toNoteEntity(noteDTO));
        if(savedNote == null){
            throw new DataPersistException("Note not saved");
        }
    }


    @Override
    public List<NoteDTO> getAllNotes() {
        return noteDTOList;
    }

    @Override
    public NoteDTO getNote() {
        return null;
    }

    @Override
    public boolean updateNote(String noteId) {
        return false;
    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
    }
}
