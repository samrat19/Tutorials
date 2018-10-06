package com.example.samrat.tutorials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirstActivity extends AppCompatActivity {

    EditText editText,editText1,editText2,editText3;
    TextView textView;
    Button button;

    DatabaseReference databaseReference;

    final String verifedcode = "007abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText = (EditText)findViewById(R.id.editText4);
        editText1 = (EditText)findViewById(R.id.editText5);
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button3);

        databaseReference = FirebaseDatabase.getInstance().getReference("user");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String no = editText1.getText().toString();
                final String code = editText.getText().toString();

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(no).exists()){

                            if(code.equals(verifedcode)){
                                startActivity(new Intent(getApplicationContext(),StorageActivity.class));
                            }else{
                                Toast.makeText(FirstActivity.this, "Wrong code",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }else{

                           // databaseReference.child(user.getPhone()).setValue(user);

                            Toast.makeText(FirstActivity.this, " Credential expired or You are new to here",
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),RegActivity.class));
            }
        });
    }
}
