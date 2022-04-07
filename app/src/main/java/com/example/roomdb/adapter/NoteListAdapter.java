package com.example.roomdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdb.R;
import com.example.roomdb.db.NoteEntity;
import com.example.roomdb.db.NoteRepository;
import com.example.roomdb.utils.HelperUtils;
import com.example.roomdb.utils.NoteDiffUtil;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    // Data list for adapter
    private List<NoteEntity> notes;
    // Repository for query db
    private NoteRepository noteRepository;

    public NoteListAdapter(List<NoteEntity> notes) {
        this.notes = notes;
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item,parent,false);
        NoteViewHolder noteViewHolder=new NoteViewHolder(itemView);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        NoteEntity note=notes.get(position);
        holder.textViewTitle.setText(note.getTitle());
        holder.textViewDescription.setText(HelperUtils.getFormattedDateString(note.getCreatedAt()));
        //set icon
        if(note.isEncrypted()){
            holder.textViewDescription.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_baseline_lock_24,0);
        }
    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    public NoteEntity getItem(int position) {
        return notes.get(position);
    }

    public void addTasks(List<NoteEntity> newNotes) {
        NoteDiffUtil noteDiffUtil = new NoteDiffUtil(notes, newNotes);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(noteDiffUtil);
        notes.clear();
        notes.addAll(newNotes);
        diffResult.dispatchUpdatesTo(this);
    }
}
