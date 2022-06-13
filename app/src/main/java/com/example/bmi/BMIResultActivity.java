package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIResultActivity extends AppCompatActivity {

    android.widget.Button reCalBtn;
    TextView genderDisplay,bmiDisplay,categoryDisplay;
    ImageView resultImage;
    RelativeLayout background;
    Intent intent;
    private float bmi;
    private String bmiText;

    private String heightText,weightText;
    private float height,weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);
        getSupportActionBar().hide();


        intent = getIntent();

        reCalBtn =findViewById(R.id.back_main);
        genderDisplay = findViewById(R.id.gender_display);
        bmiDisplay = findViewById(R.id.display_bmi);
        categoryDisplay = findViewById(R.id.category_display);
        background = findViewById(R.id.content_layout);
        resultImage  = findViewById(R.id.result_image);

        heightText = intent.getStringExtra("Height");
        weightText = intent.getStringExtra("Weight");

        height = Float.parseFloat(heightText);
        weight = Float.parseFloat(weightText);

        height = height/100;

        bmi = weight/(height * height);

        bmiText = Float.toString(bmi);


        if(bmi < 16){
            categoryDisplay.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            resultImage.setImageResource(R.drawable.crosss);
        }
        else  if(bmi < 16.9 && bmi > 16){
            categoryDisplay.setText("Moderate Thinness");
            background.setBackgroundColor(Color.RED);
            resultImage.setImageResource(R.drawable.warning);
        }
        else  if(bmi < 18.4 && bmi > 17){
            categoryDisplay.setText("Mild Thinness");
            background.setBackgroundColor(Color.RED);
            resultImage.setImageResource(R.drawable.warning);
        }
        else  if(bmi < 25 && bmi > 18.4){
            categoryDisplay.setText("Normal");
//            background.setBackgroundColor(Color.YELLOW);
            resultImage.setImageResource(R.drawable.mark_green);
        }
        else  if(bmi < 29.4 && bmi > 25){
            categoryDisplay.setText("OverWeight");
            background.setBackgroundColor(Color.RED);
            resultImage.setImageResource(R.drawable.warning);
        }
        else{
            categoryDisplay.setText("Obese Class");
            background.setBackgroundColor(Color.RED);
            resultImage.setImageResource(R.drawable.warning);
        }

        genderDisplay.setText(intent.getStringExtra("Gender"));
        bmiDisplay.setText(bmiText);



        reCalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BMIResultActivity.this,MainActivity.class));
                finish();
            }
        });

    }
}