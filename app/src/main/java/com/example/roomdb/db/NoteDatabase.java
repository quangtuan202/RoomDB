package com.example.roomdb.db;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {NoteEntity.class},version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract DataObjectAccess NoteDao();
    private static volatile NoteDatabase INSTANCE;
    private static final int NUM_OF_THREADS=4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUM_OF_THREADS);

    static NoteDatabase getInstance(Context context){
        if (INSTANCE==null){
            synchronized (NoteDatabase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_db").build();
                }
            }
        }
        return INSTANCE;
    }

}
