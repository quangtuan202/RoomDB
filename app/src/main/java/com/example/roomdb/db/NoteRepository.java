package com.example.roomdb.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.roomdb.utils.HelperUtils;

import java.util.Date;
import java.util.List;

public class NoteRepository {
    private NoteDatabase db;
    private DataObjectAccess dao;
    private LiveData<List<NoteEntity>> note;

    public NoteRepository(Context context){
        db=NoteDatabase.getInstance(context);
        dao=db.NoteDao();
    }

    void insertNote(String title,
                    String description,
                    boolean encrypt,
                    String password){
        NoteEntity note=new NoteEntity(title,description,encrypt,password);
        insertNote(note);

    }

    void insertNote(NoteEntity note){
        // can use a thread instead
        NoteDatabase.databaseWriteExecutor.execute(()->dao.insertNote(note));
    }

    void updateNote(NoteEntity note){
        NoteDatabase.databaseWriteExecutor.execute(()->dao.updateNote(note));
    }

    public LiveData<NoteEntity> getNote(int id) {
        return dao.getNote(id);
    }

    public LiveData<List<NoteEntity>> selectAllNote() {
        return dao.selectAllNote();
    }

}
