package com.example.mange.mortgageapp;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {


    private EditText numMonths; //user input
    private EditText monthlyMortgage;
    private EditText userRate;

    private TextView monthlyPayment;
    private SeekBar numSeek;
    private EditText address;
    private EditText price;
    private TextView sqrFeet;
    private EditText usersqrFeet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//Creates the tabs
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Home");
        tabSpec.setContent(R.id.Home);
        tabSpec.setIndicator("Home");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Investment");
        tabSpec.setContent(R.id.Investment);
        tabSpec.setIndicator("Investment");
        tabHost.addTab(tabSpec);
//Defines the variables of the first page
        //Inputs of page 1
        numMonths = (EditText) findViewById(R.id.numMonths);
        monthlyMortgage = (EditText) findViewById(R.id.monthlyMortgage);
        userRate = (EditText) findViewById(R.id.userRate);
//Output
        monthlyPayment = (TextView) findViewById(R.id.monthlyPayment);

        address = (EditText) findViewById(R.id.address);


        sqrFeet = (TextView) findViewById(R.id.sqrTextView);

        numSeek = (SeekBar) findViewById(R.id.seekBar);
        price = (EditText) findViewById(R.id.price); // The price
        usersqrFeet = (EditText) findViewById(R.id.sqrUserInput); //sqr feet of home

        Button button = (Button) findViewById(R.id.but);//Button GO


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double num = Double.parseDouble(numMonths.getText().toString());
                double user = Double.parseDouble(userRate.getText().toString());
                double month = Double.parseDouble(monthlyMortgage.getText().toString());


                double inter = user / 100 / 12; //Default interest
                double nu = num *12; //Months
                double answer = month * ((inter * Math.pow(1 + inter, nu)) / (Math.pow(1 + inter, nu) - 1));

                monthlyPayment.setText((String.format("%.2f", answer)));
            }

        });
                //When user inputs value sqr feet automates answer


        usersqrFeet.addTextChangedListener(new TextWatcher()  {

            public void afterTextChanged(Editable s) {
                //Equation made to get square feet
                double priceOfHome = Double.parseDouble(price.getText().toString());
                double sqr = Double.parseDouble(usersqrFeet.getText().toString());

                double answer = (priceOfHome / sqr);
                // you can call or do what you want with your EditText here
               if(sqr < 0){
                   answer = 0.0;
               }

                if (s.length() > 0) {
                        sqrFeet.setText((String.format("%.2f", answer)));
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Toast.makeText(getApplicationContext(), " Test1", Toast.LENGTH_LONG).show();

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() <0)
                    sqrFeet.setText((String.format("%.2f", 1)));
            }

        });




        }


    }







/*


    private double mortgageFormula(double cost, double interest, double monthly) {
//Cost is the amount of the user mortgage
        double inter = interest / 100 / 12; //Default interest
        double month = monthly * 12; //Months
        //Mortgage Formula
        return cost * (inter * Math.pow(1 + inter, month)) / (Math.pow(1 + inter, month) - 1);
    }


    button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            // code will be here
        }
    });
        // calculate Here
        double input1 = Double.parseDouble(monthlyMortgage.getText().toString());
        double input2 = Double.parseDouble(numMonths.getText().toString());
        double input3 = Double.parseDouble(userRate.getText().toString());

        double answer = mortgageFormula(input1, input3, input2);
        // 10, 15 and 30 yr monthly payment EditTexts
        monthlyPayments.setText("$" + String.format("%.0f", answer));

*/

