package com.example.mynotes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    //fetch data from repo class
    private NoteRepo noteRepo;
    private LiveData<List<Note>> noteList;
    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRepo = new NoteRepo(application);
        noteList = noteRepo.getAll();
    }

    // call all CRUD methods

    public  void insert(Note note){
        noteRepo.insertData(note);
    }public  void update(Note note){
        noteRepo.updatetData(note);
    }public  void delete(Note note){
        noteRepo.deleteData(note);
    }
    public LiveData<List<Note>> getAllNotes(){
        return noteList;
    }
}
