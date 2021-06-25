package com.iraqoz.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Properties
    EditText usernameEDT, passwordEDT;
    Button loginBTN;
    TextView attemptsTXT;
    int attempt=5;
    int counter;
    //end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEDT=findViewById(R.id.editText_username);
        passwordEDT=findViewById(R.id.editText_password);
        loginBTN=findViewById(R.id.button_login);
        attemptsTXT=findViewById(R.id.textView_attempts);

        //USer Objects
        User eben=new User("Eben","Tz","HRM",12);
        Bundle b= new Bundle();
        b.putString("EBEN_INFO",eben.toString());


        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=usernameEDT.getText().toString().trim();
                String password=passwordEDT.getText().toString().trim();


                //Authenticate user credentials
                boolean isAuthenticated=authUserInputs(username,password);

                if (isAuthenticated){
                    //Navigate to the Information Activity 
                    Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                    startActivity(intent);
                }
                else
                {
                    attempt--;
                    attemptsTXT.setText("You have "+attempt+" attempts left.");
                    if (attempt==0){
                        loginBTN.setEnabled(false);

                        new CountDownTimer(30000, 1000){
                            public void onTick(long millisUntilFinished){
                                attemptsTXT.setText("Please, wait for "+counter+ " seconds to try again");
                                counter++;
                            }
                            public  void onFinish(){
                                attemptsTXT.setText("");
                                loginBTN.setEnabled(true);
                            }
                        }.start();
                    }

                    return;
                }



            }
        });
    }
    private boolean validateUserInputs(String username, String password){
        if (username.isEmpty()){
            usernameEDT.setError("Username Required");
            return false;
        }
        else if(password.isEmpty()){
            passwordEDT.setError("Password Required");
            return false;
        }
        else
            return true;
    }
    private boolean authUserInputs(String username, String password){
        boolean isValid=validateUserInputs(username,password);
        if(isValid){

            //check if the username == Admin and Password==admin12345
            if (username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("admin12345"))
                return true;
            else
                return false;

        }
        else
            return false;
    }
}