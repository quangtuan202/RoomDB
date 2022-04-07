package com.example.roomdb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roomdb.R;
import com.example.roomdb.db.NoteEntity;

public class AddNoteActivity extends AppCompatActivity {
    private NoteEntity note;
    private boolean pwdVisible;

    public AddNoteActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        EditText editTitle = findViewById(R.id.text_edit_title);
        EditText editDesc = findViewById(R.id.text_edit_desc);
        EditText editPwd = findViewById(R.id.text_edit_pass);
        TextView toolbarTitle = findViewById(R.id.text_view_tool_bar);
        TextView textTime = findViewById(R.id.text_view_time);
        CheckBox checkBox=findViewById(R.id.check_box_lock_note);
        ImageView btnDelete=findViewById(R.id.img_btn_close);
        ImageView btnDone=findViewById(R.id.img_btn_ok);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteTilte=editTitle.getText().toString();
                String noteDescription=editDesc.getText().toString();



            }
        });

        //Update RecycleView

    }

    public void updateRecycleView(){

    }

}