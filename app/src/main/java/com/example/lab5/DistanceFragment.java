package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    RadioGroup radioGroup;
    RadioButton radioKmToMiles, radioMilesToKm;
    EditText editValue;
    Button btnConvert;
    TextView textResult;

    public DistanceFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        radioGroup = view.findViewById(R.id.radioGroup);
        radioKmToMiles = view.findViewById(R.id.radioKmToMiles);
        radioMilesToKm = view.findViewById(R.id.radioMilesToKm);
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

            if (radioKmToMiles.isChecked()) {
                result = value * 0.621;
                textResult.setText(result + " miles");
            } else if (radioMilesToKm.isChecked()) {
                result = value / 0.621;
                textResult.setText(result + " km");
            } else {
                textResult.setText("Choisir une option");
            }
        });

        return view;
    }
}