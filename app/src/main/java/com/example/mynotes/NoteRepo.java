package com.example.mynotes;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NoteRepo {

    private NoteDao dao;
    private LiveData<List<Note>> notelist;

    public NoteRepo(Application application){
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        dao = noteDatabase.noteDao();
        notelist = dao.getAll();
    }

    public void insertData(Note note){new InsertTask(dao).execute(note);}
    public void updatetData(Note note){new UpdateTask(dao).execute(note);}
    public void deleteData(Note note){new DeleteTask(dao).execute(note);}
    public LiveData<List<Note>> getAll(){
        return notelist;
    }


    //Insert Data
    private static class InsertTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        public InsertTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }

        //Update data
    }private static class UpdateTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        public UpdateTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }

        //Delete data
    }private static class DeleteTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        public DeleteTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
}
