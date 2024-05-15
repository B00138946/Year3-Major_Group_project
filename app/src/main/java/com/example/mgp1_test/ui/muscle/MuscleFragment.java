package com.example.mgp1_test.ui.muscle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mgp1_test.R;
import com.example.mgp1_test.chestActivity;
import com.example.mgp1_test.databinding.FragmentMuscleBinding;


public class MuscleFragment extends Fragment {

    Activity context;

    private FragmentMuscleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MuscleViewModel notificationsViewModel =
                new ViewModelProvider(this).get(MuscleViewModel.class);

        context = getActivity();

        binding = FragmentMuscleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMuscle;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//https://www.youtube.com/watch?v=fws4f8RE7lY&ab_channel=WithSam
    //when the chest is clicked it redirects
    //to the chest video
    public void onStart() {
        super.onStart();
        ImageButton imageChest = (ImageButton) context.findViewById(R.id.imageChest);
        imageChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/shorts/dMllsMHxD6s"));
                startActivity(intent);

            }
        });

        ImageButton imageBack = (ImageButton) context.findViewById(R.id.imageBack);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/shorts/YHi0SWPJQU4"));
                startActivity(intent);

            }
        });

        ImageButton imageBicep = (ImageButton) context.findViewById(R.id.imageBicep);
        imageBicep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/shorts/hSKzFBa5lFY"));
                startActivity(intent);

            }
        });

        ImageButton imageQuad = (ImageButton) context.findViewById(R.id.imageQuad);
        imageQuad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/shorts/3QmM_JCkdhc"));
                startActivity(intent);

            }
        });



    }

}