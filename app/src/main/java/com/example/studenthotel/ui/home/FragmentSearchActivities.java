package com.example.studenthotel.ui.home;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import com.example.studenthotel.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class FragmentSearchActivities extends Fragment {
    private Long from;
    private Long to;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search_activities, container, false);
        final Calendar myCalendar = Calendar.getInstance();

        EditText range = root.findViewById(R.id.date_range_text);
//
//        DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
//            // TODO Auto-generated method stub
//            myCalendar.set(Calendar.YEAR, year);
//            myCalendar.set(Calendar.MONTH, monthOfYear);
//            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            updateLabel(range,myCalendar);
//        };
//
//        range.setOnClickListener(v -> {
//            // TODO Auto-generated method stub
//            new DatePickerDialog(getContext(), date, myCalendar
//                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//        });

        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select a date:");
        final MaterialDatePicker<Pair<Long, Long>> picker = builder.build();
        range.setOnClickListener(v -> picker.show(getChildFragmentManager(), picker.toString())
        );

        picker.addOnPositiveButtonClickListener(
                selection -> {
                    range.setText(picker.getHeaderText());
                    this.from = selection.first;
                    this.to = selection.second;
                });

        return root;
    }
//    private void updateLabel(EditText range, Calendar myCalendar) {
//        String myFormat = "dd/MM/yy";
//        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
//
//        range.setText(sdf.format(myCalendar.getTime()));
//    }

}
