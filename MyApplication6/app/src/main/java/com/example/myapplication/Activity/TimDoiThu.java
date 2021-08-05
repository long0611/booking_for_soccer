package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.Meta.SearchDoiThu;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimDoiThu extends AppCompatActivity {
    private Spinner spnTieuDe;
    private TextView btnDang;
    private TextView tvbg;
    private EditText edtNoiDung,edtTime,edtPhone,edtAddress;
    ArrayList<String> arr = new ArrayList<>();
    int mYear;
    int mMonth;
    int mDay;
    String date_time = "";
    int mHour;
    int mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_doi_thu);
        anhxa();
        getTieuDe();
        xuly();
    }

    private void xuly() {
        spnTieuDe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arr.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        edtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });
        btnDang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data();
                Toast toast = new Toast(TimDoiThu.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.success,(ViewGroup) findViewById(R.id.toast));
                tvbg = view.findViewById(R.id.tvbg);
                toast.setView(view);
                tvbg.setText("Đăng bài thành công");
                toast.setGravity(Gravity.CENTER,0,800);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
                edtNoiDung.getText().clear();
                edtTime.getText().clear();
                edtPhone.getText().clear();
                edtAddress.getText().clear();
            }
        });
    }
    private void data(){
        ApiService.apiService.timdoithu(LoginActivity.name,
                                        spnTieuDe.getSelectedItem().toString(),
                                        edtNoiDung.getText().toString().trim(),
                                        edtTime.getText().toString().trim(),
                                        Integer.parseInt(edtPhone.getText().toString().trim()),
                                        edtAddress.getText().toString().trim()
                                        ).enqueue(new Callback<SearchDoiThu>() {
            @Override
            public void onResponse(Call<SearchDoiThu> call, Response<SearchDoiThu> response) {
            }
            @Override
            public void onFailure(Call<SearchDoiThu> call, Throwable t) {
            }
        });
    }

    private void anhxa() {
        spnTieuDe = findViewById(R.id.spnTieuDe);
        edtNoiDung = findViewById(R.id.tvNoiDung);
        edtTime = findViewById(R.id.edtTime);
        edtPhone = findViewById(R.id.edtSdtTDT);
        edtAddress = findViewById(R.id.edtAddressTDT);
        btnDang = findViewById(R.id.btnDang);
    }
    private void getTieuDe() {
        arr.add("Tìm đối thủ");
        arr.add("Tuyển thành viên");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTieuDe.setAdapter(arrayAdapter);
    }

    private void datePicker() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date_time = dayOfMonth + "-" + (month + 1) + "-" + year;
                        timePicker();
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    private void timePicker() {
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mHour = hourOfDay;
                        mMinute = minute;
                        edtTime.setText(date_time+" "+hourOfDay + ":" + minute);
                    }

                }, mHour, mMinute, false);
        timePickerDialog.show();
    }
}