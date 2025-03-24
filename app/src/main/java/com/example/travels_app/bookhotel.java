package com.example.travels_app;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travels_app.model.Databook;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class bookhotel extends AppCompatActivity {
    EditText name, email, number, hotelname, AdharcardNumbe, set_CheckOutDate, set_time;
    TextView set_CheckInDate;

    Button buttonBookhotel;
    int year, month, day;
    int t1Hour, t1Minute;
    Databook databook;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_bookhotel);

        // Initialize UI elements
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        hotelname = findViewById(R.id.hotelname2);
        AdharcardNumbe = findViewById(R.id.adharcard2);
        set_CheckInDate = findViewById(R.id.set_checkindate);
        set_CheckOutDate = findViewById(R.id.set_checkoutdate);
        set_time = findViewById(R.id.set_time);
        buttonBookhotel = findViewById(R.id.bookhotel);

        databook = new Databook();

        // Set OnClickListener for the set_date EditText to open DatePickerDialog
        set_CheckInDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        set_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize time picker dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(bookhotel.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOFday, int minute) {
                        //Intialize hour and minute
                        t1Hour = hourOFday;
                        t1Minute = minute;
                        //Initialize calendar
                        Calendar calendar = Calendar.getInstance();
                        //set hour and minute
                        calendar.set(0,0,0,t1Hour,t1Minute);
                        //set selected time on text view
                        set_time.setText(DateFormat.format("hh:mm aa",calendar));
                    }
                },12,0,false);
                //Displayed previous selected time
                timePickerDialog.updateTime(t1Hour,t1Minute);
                //Show dialog
                timePickerDialog.show();
            }
        });

        buttonBookhotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }
        });
    }

    private void InsertData() {
        DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference("Hotelbook");

        // Retrieve input values from EditText fields
        String tname = name.getText().toString().trim();
        String pemail = email.getText().toString().trim();
        String tnumber = number.getText().toString().trim();
        String tac = AdharcardNumbe.getText().toString().trim();
        String thotelname=hotelname.getText().toString().trim();
        String tset_date = set_CheckInDate.getText().toString().trim();
        String tset_dateout = set_CheckOutDate.getText().toString().trim();
        String tset_time = set_time.getText().toString().trim();

        databook.setEmail(pemail);
        databook.setName(tname);
        databook.setNumber(tnumber);
        databook.setHotelname(thotelname);
        databook.setAdharcardNumber(tac);
        databook.setSet_CheckInDate(tset_date);
        databook.setSet_CheckOutDate(tset_dateout);
        databook.setSet_time(tset_time);

        DatabaseReference ref = eventsRef.push();
        String ref_id = ref.getKey();
        databook.setRef_id(ref_id);
        eventsRef.child(ref_id).setValue(databook);

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.setTime(sdf.parse(tset_date));

            Calendar currentDate = Calendar.getInstance();

            // Check if selected date is before the current date
            if (selectedDate.before(currentDate)) {
                Toast.makeText(bookhotel.this, "Please select a future date", Toast.LENGTH_SHORT).show();
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(bookhotel.this, "Error occurred while parsing date", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    // Function to show DatePickerDialog
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(bookhotel.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Update set_date EditText with selected date
                set_CheckInDate.setText((month + 1) + "/" + dayOfMonth + "/" + year);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}