package com.iraqoz.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InformationActivity extends AppCompatActivity {

    EditText dateEDT, namesEDT, idNoEDT,whereFromEDT,whoToVisitEDT, timeInEDT,timeOutEDT,signatureEDT;
    Button proceedBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        dateEDT=findViewById(R.id.editText_date);
        namesEDT=findViewById(R.id.editText_names);
        idNoEDT=findViewById(R.id.editText_idno);
        whereFromEDT=findViewById(R.id.editText_wherefrom);
        whoToVisitEDT=findViewById(R.id.editText_person_to_visit);
        timeInEDT=findViewById(R.id.editText_timein);
        timeOutEDT=findViewById(R.id.editText_timeout);
        signatureEDT=findViewById(R.id.editText_signature);
        proceedBTN=findViewById(R.id.button_proceed);

        proceedBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date=dateEDT.getText().toString().trim();
                String names=namesEDT.getText().toString().trim();
                String idno=idNoEDT.getText().toString().trim();
                String wherefrom=whereFromEDT.getText().toString().trim();
                String whotovisit=whoToVisitEDT.getText().toString().trim();
                String timein=timeInEDT.getText().toString().trim();
                String timeout=timeOutEDT.getText().toString().trim();
                String signature=signatureEDT.getText().toString().trim();

                //validate inputs
                boolean isValid=validateUserInputs(date,names,idno,wherefrom,whotovisit,timein,timeout,signature);
                if (isValid){
                    Intent intent=new Intent(InformationActivity.this,SummaryActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("DATE",date);
                    bundle.putString("NAMES",names);
                    bundle.putString("ID",idno);
                    bundle.putString("WHEREFROM",wherefrom);
                    bundle.putString("WHOMTOVISIT",whotovisit);
                    bundle.putString("TIMEIN",timein);
                    bundle.putString("TIMEOUT",timeout);
                    bundle.putString("SIGNATURE",signature);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                    return;
            }
        });

    }

    private boolean validateUserInputs(String date, String names, String idno, String wherefrom, String whotovisit, String timein, String timeout, String signature){
        if (names.isEmpty()){
            namesEDT.setError("Names Required");
            return false;
        }
        if(idno.isEmpty()){
            idNoEDT.setError("Id Number Required");
            return false;
        }
        if (date.isEmpty()){
            namesEDT.setError("Date Required");
            return false;
        }
        if(wherefrom.isEmpty()){
            whereFromEDT.setError("Required");
            return false;
        }
        if (whotovisit.isEmpty()){
            whoToVisitEDT.setError("Required");
            return false;
        }
        if(wherefrom.isEmpty()){
            whereFromEDT.setError("Required");
            return false;
        }
        if (timein.isEmpty()){
            timeInEDT.setError("Required");
            return false;
        }
        if(timeout.isEmpty()){
           timeOutEDT.setError("Required");
            return false;
        }
        if(signature.isEmpty()){
            signatureEDT.setError("Required");
            return false;
        }
        else
            return true;
    }
}
