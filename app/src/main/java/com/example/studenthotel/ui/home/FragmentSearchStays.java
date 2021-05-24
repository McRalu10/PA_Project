package com.example.studenthotel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import com.example.studenthotel.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Date;

public class FragmentSearchStays extends Fragment {
    private Long from;
    private Long to;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search_stays, container, false);
        EditText range = root.findViewById(R.id.date_range_stays);
        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select a date:");
        final MaterialDatePicker<Pair<Long, Long>> picker = builder.build();
        range.setOnClickListener(v -> picker.show(getChildFragmentManager(), picker.toString())
        );
        picker.addOnPositiveButtonClickListener(selection -> {
            range.setText(picker.getHeaderText());
            this.from = selection.first;
            this.to = selection.second;
        });
        return root;
    }
}
