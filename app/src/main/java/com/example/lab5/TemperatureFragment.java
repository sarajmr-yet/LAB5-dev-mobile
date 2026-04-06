package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.fragment.app.Fragment;

public class TemperatureFragment extends Fragment {

    RadioGroup radioGroup;
    RadioButton radioCtoF, radioFtoC;
    EditText editValue;
    Button btnConvert;
    TextView textResult;

    public TemperatureFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temperature, container, false);

        radioGroup = view.findViewById(R.id.radioGroup);
        radioCtoF = view.findViewById(R.id.radioCtoF);
        radioFtoC = view.findViewById(R.id.radioFtoC);
        editValue = view.findViewById(R.id.editValue);
        btnConvert = view.findViewById(R.id.btnConvert);
        textResult = view.findViewById(R.id.textResult);

        btnConvert.setOnClickListener(v -> {
            String input = editValue.getText().toString();

            if (input.isEmpty()) {
                textResult.setText("Entrer une valeur");
                return;
            }

            double value = Double.parseDouble(input);
            double result;

            if (radioCtoF.isChecked()) {
                result = (value * 9/5) + 32;
                textResult.setText(result + " °F");
            } else if (radioFtoC.isChecked()) {
                result = (value - 32) * 5/9;
                textResult.setText(result + " °C");
            } else {
                textResult.setText("Choisir une option");
            }
        });

        return view;
    }
}