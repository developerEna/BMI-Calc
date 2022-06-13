package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    android.widget.Button btnCalc;
    TextView currentHeight,currentAge,currentWeight;
    SeekBar seekBarHeight;
    RelativeLayout male,female;
    ImageView increaseWeight, decreaseWeight,increaseAge,decreaseAge;

    private int age = 22;
    private int weight = 55;
    private int currentProgress;
    private String progressText = "170";
    private String typeOfUser = "";
    private String weightText = "55";
    private String ageText = "22";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnCalc = findViewById(R.id.calculate_bmi);
        currentHeight = findViewById(R.id.current_height);
        currentAge = findViewById(R.id.current_age);
        currentWeight = findViewById(R.id.current_weight);
        seekBarHeight = findViewById(R.id.seekbar_for_height);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        increaseWeight = findViewById(R.id.increment_weight);
        decreaseWeight = findViewById(R.id.decrement_weight);
        increaseAge =findViewById(R.id.increment_age);
        decreaseAge =findViewById(R.id.decrement_age);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser = "Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser = "Female";
            }
        });

        seekBarHeight.setMax(300);
        seekBarHeight.setProgress(170);
        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentProgress = i;
                progressText = String.valueOf(currentProgress);
                currentHeight.setText(progressText);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        increaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight + 1;
                weightText = String.valueOf(weight);
                currentWeight.setText(weightText);
            }
        });

        decreaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight - 1;
                weightText = String.valueOf(weight);
                currentWeight.setText(weightText);
            }
        });

        increaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age + 1;
                ageText = String.valueOf(age);
                currentAge.setText(ageText);
            }
        });

        decreaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age - 1;
                ageText = String.valueOf(age);
                currentAge.setText(ageText);
            }
        });






        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(typeOfUser.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Your Gender First",Toast.LENGTH_SHORT).show();
                }
                else if(progressText.equals("0")){

                    Toast.makeText(getApplicationContext(),"Select Your Height First",Toast.LENGTH_SHORT).show();
                }
                else if(age == 0 || age < 0){
                    Toast.makeText(getApplicationContext(),"Your Age is not Correct",Toast.LENGTH_SHORT).show();
                }
                else if(weight == 0 || weight < 0 ){
                    Toast.makeText(getApplicationContext(),"Your Weight is not Correct",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,BMIResultActivity.class);
                    intent.putExtra("Gender",typeOfUser);
                    intent.putExtra("Height",progressText);
                    intent.putExtra("Weight",weightText);
                    intent.putExtra("Age",ageText);

                    startActivity(intent);
                    finish();

                }

            }
        });


    }
}