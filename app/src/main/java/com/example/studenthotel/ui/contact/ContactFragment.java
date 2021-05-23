package com.example.studenthotel.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.studenthotel.R;
import com.example.studenthotel.ui.about.AboutViewModel;

public class ContactFragment extends Fragment {
    private AboutViewModel aboutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel = new ViewModelProvider(this).get(AboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
//        final TextView textView = root.findViewById(R.id.text_about);
//        AboutViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
