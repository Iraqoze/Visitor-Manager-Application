package com.iraqoz.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    TextView dateTXT, namesTXT, idNoTXT,whereFromTXT,whoToVisitTXT, timeInTXT,timeOutTXT,signatureTXT;
    Button grantBTN, denyBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        dateTXT=findViewById(R.id.textView_date);
        namesTXT=findViewById(R.id.textView_names);
        idNoTXT=findViewById(R.id.textView_id_no);
        whereFromTXT=findViewById(R.id.textView_wherefrom);
        whoToVisitTXT=findViewById(R.id.textView_whomtovisit);
        timeInTXT=findViewById(R.id.textView_timein);
        timeOutTXT=findViewById(R.id.textView_timeout);
        signatureTXT=findViewById(R.id.textView_signature);
        grantBTN=findViewById(R.id.button_approved);
        denyBTN=findViewById(R.id.button_denied);



        //Getting the bundle
        Bundle bundle=getIntent().getExtras();

        String date=bundle.getString("DATE");
        String names=bundle.getString("NAMES");
        String idno=bundle.getString("ID");
        String wherefrom=bundle.getString("WHEREFROM");
        String whotovisit=bundle.getString("WHOMTOVISIT");
        String timein=bundle.getString("TIMEIN");
        String timeout=bundle.getString("TIMEOUT");
        String signature=bundle.getString("EBEN_INFO");

        //Setting the textview
        dateTXT.setText(date);
        namesTXT.setText(names);
        idNoTXT.setText(idno);
        whereFromTXT.setText(wherefrom);
        whoToVisitTXT.setText(whotovisit);
        timeInTXT.setText(timein);
        timeOutTXT.setText(timeout);
        signatureTXT.setText(signature);

        grantBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SummaryActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
        denyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SummaryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}