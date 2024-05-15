package com.example.mgp1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
//References:
//https://stackoverflow.com/questions/67219782/how-to-make-notes-section-in-an-app-already-created-in-android-studio
//https://www.youtube.com/watch?v=or_pH92l-IQ
public class NoteViewerAdapter extends ArrayAdapter<Note> {

    private Context mContext;
    private int mResource;

    public NoteViewerAdapter(Context context, int resource, List<Note> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(mResource, parent, false);
        }

        Note note = getItem(position);

        TextView titleTextView = view.findViewById(R.id.noteTitle);
        titleTextView.setText(note.getTitle());

        TextView contentTextView = view.findViewById(R.id.noteContent);
        contentTextView.setText(note.getContent());

        return view;
    }
}