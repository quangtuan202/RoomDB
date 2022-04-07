package com.example.roomdb.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataObjectAccess {

    @Insert
    void insertNote(NoteEntity note);

    @Query("SELECT * FROM Note ORDER BY created_at desc")
    LiveData<List<NoteEntity>> selectAllNote();

    @Query("SELECT * FROM Note WHERE id=:NoteId")
    LiveData<NoteEntity> getNote(int NoteId);

    @Update
    void updateNote(NoteEntity note);

    @Delete
    void deleteNote(NoteEntity note);




}
