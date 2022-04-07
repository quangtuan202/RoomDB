package com.example.roomdb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.roomdb.R;
import com.example.roomdb.adapter.NoteListAdapter;
import com.example.roomdb.db.NoteEntity;
import com.example.roomdb.db.NoteRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ShowNoteActivity extends AppCompatActivity {
    private TextView emptyView;
    private RecyclerView recyclerView;
    private NoteListAdapter notesListAdapter;
    private FloatingActionButton floatingActionButton;
    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        noteRepository=new NoteRepository(getApplicationContext());
        floatingActionButton=findViewById(R.id.floating_button_add);
        recyclerView=findViewById(R.id.recyclerView);
        emptyView=findViewById(R.id.empty_view);


    }

    private void updateRecycleView(){
        noteRepository.selectAllNote().observe(this, new Observer<List<NoteEntity>>() {
            @Override
            public void onChanged(List<NoteEntity> noteEntities) {
                if(noteEntities.size()>0){
                    emptyView.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    if (notesListAdapter==null){
                        notesListAdapter=new NoteListAdapter(noteEntities);
                        recyclerView.setAdapter(notesListAdapter);
                    }
                    else{
                        notesListAdapter.addTasks(noteEntities);
                    }
                }
                else{
                    emptyView.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);

                }
            }
        });
    }
}