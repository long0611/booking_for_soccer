package com.example.myapplication.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.Meta.LayID;
import com.example.myapplication.Meta.Post;
import com.example.myapplication.Meta.SanBongMeta;
import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.api.SpinnerInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DatsanActivity extends AppCompatActivity {
    private ArrayList<SanBongMeta> listSanBong;
    private ArrayList<String> listSan = new ArrayList<String>();
    private List<User> mUser;
    String checkout;
    int mYear;
    int mMonth;
    int mDay;
    String date_time = "";
    int mHour;
    int mMinute;
    private Button btnDatSan;
    private TextView tvLienHe,tvbg;
    private TextView tvTime;
    private TextView tvChonSan;
    private TextView tvThoiLuong,BackBook;
    private Spinner spnThoiLuong;
    private Spinner spnChonSan;
    private EditText edtChonNgay;
    private EditText edtSdt;

    ArrayList<String> arrayList1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datsan);
        ButterKnife.bind(this);
            Anhxa();
            getSan();
            getThoiLuong();
            getBtn();
        }

    private void getSan() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SpinnerInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        SpinnerInterface api =retrofit.create(SpinnerInterface.class);
        Call<String> call = api.getSanBong();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Thành công",response.body().toString());
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        Log.i("onSuccess", response.body().toString());
                        String jsonresponse = response.body().toString();
                        selectSan(jsonresponse);
                    }else {
                        Log.i("onEmptyResponse", "Returned empty response");
                    }
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }
    private void selectSan(String response){
        try {   JSONObject jsonObject = new JSONObject(response);
                listSanBong = new ArrayList<>();
            JSONArray dataArray = jsonObject.getJSONArray("data");
            for (int i = 0;i < dataArray.length();i++){
                SanBongMeta dataSan = new SanBongMeta();
                JSONObject dataObj = dataArray.getJSONObject(i);
                dataSan.setId(Integer.parseInt(dataObj.getString("id")));
                dataSan.setTensan(dataObj.getString("tensan"));
                dataSan.setSdt(dataObj.getString("sdt"));
                dataSan.setGiasan(Float.parseFloat(dataObj.getString("giasan")));
                dataSan.setTinhtrang(Integer.parseInt(dataObj.getString("tinhtrang")));
                dataSan.setAddress(dataObj.getString("diachi"));
                dataSan.setAnh(dataObj.getString("anh"));
                listSanBong.add(dataSan);
            }
                for (int i = 0;i < listSanBong.size();i++){
                    listSan.add(listSanBong.get(i).getTensan().toString());
                }
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(DatsanActivity.this, android.R.layout.simple_spinner_item,listSan);
            stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnChonSan.setAdapter(stringArrayAdapter);

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void getBtn() {
        spnChonSan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LayID.idSan = listSanBong.get(position).getId();
                Log.i("Thanh Cong","id" + LayID.idSan);
                return;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spnThoiLuong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkout = arrayList1.get(position);
                Toast.makeText(DatsanActivity.this, checkout, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        edtChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });

        btnDatSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerSan();
                Toast toast = new Toast(DatsanActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.success,(ViewGroup) findViewById(R.id.toast));
                tvbg = view.findViewById(R.id.tvbg);
                toast.setView(view);
                tvbg.setText("Đặt sân thành công");
                toast.setGravity(Gravity.CENTER,0,800);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
                edtChonNgay.getText().clear();
                edtSdt.getText().clear();
            }
        });

        BackBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatsanActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerSan() {
        ApiService.apiService.datsan(LayID.idSan,
                                        LoginActivity.idCustomer,
                                        edtChonNgay.getText().toString().trim(),
                                        spnThoiLuong.getSelectedItem().toString(),
                                        edtSdt.getText().toString().trim())
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                            Post post = response.body();
                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }
                });
    }

    private void getThoiLuong() {
        arrayList1.add("60p");
        arrayList1.add("90p");
        arrayList1.add("120p");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayList1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnThoiLuong.setAdapter(arrayAdapter);
    }

    private void Anhxa(){
        tvChonSan = findViewById(R.id.tvChonSan);
        tvLienHe = findViewById(R.id.tvLienHe);
        tvThoiLuong = findViewById(R.id.tvThoiLuong);
        tvTime = findViewById(R.id.tvTime);
        spnChonSan = findViewById(R.id.spnChonSan);
        spnThoiLuong = findViewById(R.id.spnThoiLuong);
        edtChonNgay = findViewById(R.id.edtChonNgay);
        edtSdt = findViewById(R.id.edtSoDienThoai);
        btnDatSan = findViewById(R.id.btnDatSan);
        BackBook = findViewById(R.id.backBook);
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
                        //*************Call Time Picker Here ********************
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
                        edtChonNgay.setText(date_time+" "+hourOfDay + ":" + minute);
                    }

                }, mHour, mMinute, false);
        timePickerDialog.show();
    }



}