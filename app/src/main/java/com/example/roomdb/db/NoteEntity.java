package com.example.roomdb.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.roomdb.utils.HelperUtils;
import com.example.roomdb.utils.TimestampConverter;

import java.io.Serializable;
import java.util.Date;



/*
Implement the Serializable interface when you want to be able to convert an instance of a class into a series of bytes
or when you think that a Serializable object might reference an instance of your class.
*/
@Entity(tableName = "Note")
public class NoteEntity implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String title;
    private String description;

    @ColumnInfo(name = "created_at")
    @TypeConverters({TimestampConverter.class})
    private Date createdAt;

    @ColumnInfo(name = "modified_at")
    @TypeConverters({TimestampConverter.class})
    private Date modifiedAt;

    private boolean isEncrypted;
    private String password;


    NoteEntity(String title,
               String description,
               boolean encrypt,
               String password){
        this.setTitle(title);
        this.setDescription(description);
        this.setCreatedAt(HelperUtils.getCurrentDateTime());
        this.setModifiedAt(HelperUtils.getCurrentDateTime());
        this.setEncrypted(encrypt);

        if(encrypt) {
            this.setPassword(HelperUtils.generateHash(password));
        } else this.setPassword(null);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
