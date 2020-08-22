package com.ihfazh.hitungvolume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String STATE_RESULT = "state_result";
    private EditText edtLebar;
    private EditText edtTinggi;
    private EditText edtPanjang;
    private Button btnHitung;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLebar = findViewById(R.id.edt_lebar);
        edtTinggi = findViewById(R.id.edt_tinggi);
        edtPanjang = findViewById(R.id.edt_panjang);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);

        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvHasil.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hitung){

            String inpLebar = edtLebar.getText().toString().trim();
            String inpTinggi = edtTinggi.getText().toString().trim();
            String inpPanjang = edtPanjang.getText().toString().trim();

            Boolean fieldEmpty = false;

            if (TextUtils.isEmpty(inpLebar)){
                fieldEmpty = true;
                edtLebar.setError("Field Ini Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inpPanjang)){
                fieldEmpty = true;
                edtPanjang.setError("Field Ini Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inpTinggi)){
                fieldEmpty = true;
                edtTinggi.setError("Field Ini Tidak Boleh Kosong");
            }

            if (!fieldEmpty){
                Double volume = Double.valueOf(inpLebar) * Double.valueOf(inpTinggi) * Double.valueOf(inpPanjang);
                tvHasil.setText(String.valueOf(volume));
            }
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }
}