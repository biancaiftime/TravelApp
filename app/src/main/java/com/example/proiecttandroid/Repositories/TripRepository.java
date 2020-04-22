package com.example.proiecttandroid.Repositories;

import android.content.Context;
import android.os.AsyncTask;

import com.example.proiecttandroid.Controllers.ApplicationController;
import com.example.proiecttandroid.DataBase.AppDatabase;
import com.example.proiecttandroid.Models.Trip;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TripRepository {

    private AppDatabase appDatabase;

    public TripRepository(Context context)
    {
        appDatabase = ApplicationController.getAppDatabase();
    }

    public void insertTask(final Trip trip, final ITripRepositoryActionListener listener)
    {
        new InsertTask(listener).execute(trip);
    }
    public void deleteTask(final Trip trip, final ITripRepositoryActionListener listener)
    {
        new DeleteTask(listener).execute(trip);
    }

    public List<Trip> getAll(final ITripRepositoryActionListener listener){
        try {
            return new GetAllTask(listener).execute((Void[]) null).get();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private class InsertTask extends AsyncTask<Trip, Void, Void>{
        ITripRepositoryActionListener listener;

        InsertTask(ITripRepositoryActionListener listener)
        {
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Trip... trips) {
            appDatabase.tripDAO().insertAll((trips));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
            listener.actionSuccess();
        }
    }
    private class GetAllTask extends AsyncTask<Void, Void, List<Trip>> {
        ITripRepositoryActionListener listener;

        GetAllTask(ITripRepositoryActionListener listener) {
            this.listener = listener;
        }

        @Override
        protected List<Trip> doInBackground(Void... voids) {
            return appDatabase.tripDAO().getAll();
        }

        @Override
        protected void onPostExecute(List<Trip> trips) {
            super.onPostExecute(trips);
            listener.actionSuccess();
        }
    }

    private class DeleteTask extends AsyncTask<Trip, Void, Void> {
        ITripRepositoryActionListener listener;

        DeleteTask(ITripRepositoryActionListener listener)
        {
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Trip... trips) {
            appDatabase.tripDAO().delete(trips[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
            listener.actionSuccess();
        }
    }
}
