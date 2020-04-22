package com.example.proiecttandroid.Fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.proiecttandroid.Models.Trip;
import com.example.proiecttandroid.R;
import com.example.proiecttandroid.Repositories.TripRepository;
import com.example.proiecttandroid.Repositories.TripRepositoryActionListener;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddTripFragment extends Fragment {

    private TripRepository tripRepository;

    private EditText location;
    private EditText duration;
    private CheckBox setReminder;
    private Button addTrip;

    private TextView time_view;
    private TextView date_view;
    private Button time_button;
    private Button date_button;
    private DatePickerDialog datePicker;
    private TimePickerDialog timePicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_add_trip, container, false);

        tripRepository = new TripRepository(getActivity().getApplicationContext());

        location = layout.findViewById(R.id.location);
        duration = layout.findViewById(R.id.duration);
        setReminder = layout.findViewById(R.id.reminder);
        addTrip = layout.findViewById(R.id.addTrip);

        time_button = layout.findViewById(R.id.time_button);
        date_button = layout.findViewById(R.id.date_button);

        time_view = layout.findViewById(R.id.time_view);
        time_view.setInputType(InputType.TYPE_NULL);
        date_view = layout.findViewById(R.id.date_view);
        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                datePicker = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date_view.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();
            }
        });
        time_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                timePicker = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                time_view.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                timePicker.show();
            }
        });

        addTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Trip> trips = tripRepository.getAll(new TripRepositoryActionListener());
                Trip trip = new Trip(location.getText().toString(), ParseTime(), Integer.parseInt(duration.getText().toString()),setReminder.isChecked());
                tripRepository.insertTask(trip, new TripRepositoryActionListener());
            }
        });

        return layout;
    }

    private Date ParseTime()
    {
        int day = datePicker.getDatePicker().getDayOfMonth();
        int month = datePicker.getDatePicker().getMonth();
        int year =  datePicker.getDatePicker().getYear();
        String[] hourAndminutes = time_view.getText().toString().split(":");
        int hour = Integer.parseInt(hourAndminutes[0]);
        int minutes = Integer.parseInt(hourAndminutes[1]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
