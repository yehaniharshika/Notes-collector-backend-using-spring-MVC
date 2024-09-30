package lk.ijse.notescollectorbackend.dao;

import lk.ijse.notescollectorbackend.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDAO extends JpaRepository<NoteEntity,String> {
}
