package com.example.studenthotel.ui.rooms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.studenthotel.R;
import com.example.studenthotel.ui.rooms.RoomsViewModel;

public class RoomsFragment extends Fragment {

    private RoomsViewModel roomsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        roomsViewModel = new ViewModelProvider(this).get(RoomsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rooms, container, false);
//        final TextView textView = root.findViewById(R.id.text_Rooms);
//        RoomsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}