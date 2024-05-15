package com.example.mgp1_test.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mgp1_test.NotesActivity;
import com.example.mgp1_test.R;
import com.example.mgp1_test.TimerActivity;
import com.example.mgp1_test.activityQuotes;
import com.example.mgp1_test.chestActivity;
import com.example.mgp1_test.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    Activity context;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        context = getActivity();

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    //when the Quotes button is clicked it redirects
    //to the quotes page
    public void onStart() {
        super.onStart();
        Button quoteB = (Button) context.findViewById(R.id.quoteB);
        quoteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activityQuotes.class);
                startActivity(intent);
            }
        });


        //when the timer button is clicked it redirects
        //to the timer page
            //super.onStart();
            Button TimerB = (Button) context.findViewById(R.id.TimerB);
            TimerB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TimerActivity.class);
                    startActivity(intent);
                }
            });
        //when the notes button is clicked it redirects
        //to the notes page

        //super.onStart();
        Button Notebutton = (Button) context.findViewById(R.id.Notebutton);
        Notebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NotesActivity.class);
                startActivity(intent);
            }
        });


        }



}