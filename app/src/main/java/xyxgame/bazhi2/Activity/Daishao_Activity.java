package xyxgame.bazhi2.Activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import xyxgame.bazhi2.Activity.util.SendMail;
import xyxgame.bazhi2.R;

public class Daishao_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daishao_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        //Getting content for email
//        String email = editTextEmail.getText().toString().trim();
//        String subject = editTextSubject.getText().toString().trim();
//        String message = editTextMessage.getText().toString().trim();
        String email = "316375076@qq.com";
        String subject = "AHCDE";
        String message = "ASWDEDEEDD";
        TextView textView=findViewById(R.id.say);

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message,textView);

        //Executing sendmail to send email
         sm.execute();

//        Intent emails = new Intent(Intent.ACTION_SEND);
//        emails.putExtra(Intent.EXTRA_EMAIL, );
//        emails.putExtra(Intent.EXTRA_SUBJECT, "subject");
//        emails.putExtra(Intent.EXTRA_TEXT, "message");
//        emails.setType("message/rfc822");
//        startActivity(Intent.createChooser(emails, "Choose an Email client :"));+
//



    }




}

