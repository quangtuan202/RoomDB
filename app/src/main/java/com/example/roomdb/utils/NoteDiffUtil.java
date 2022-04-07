package com.example.roomdb.utils;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.roomdb.db.NoteEntity;

import java.util.List;

// Compare Note List
public class NoteDiffUtil extends DiffUtil.Callback {
    List<NoteEntity> oldNoteList;
    List<NoteEntity> newNoteList;
    public NoteDiffUtil(List<NoteEntity> oldNoteList,List<NoteEntity> newNoteList){
        this.oldNoteList=oldNoteList;
        this.newNoteList=newNoteList;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldNoteList.get(oldItemPosition).getId()== newNoteList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldNoteList.get(oldItemPosition).equals(newNoteList.get(newItemPosition).getDescription());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }

    @Override
    public int getOldListSize() {
        return oldNoteList.size();
    }

    @Override
    public int getNewListSize() {
        return newNoteList.size();
    }
}
