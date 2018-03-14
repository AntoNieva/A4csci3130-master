package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class DetailViewActivity extends Activity {

    private EditText nameField, emailField, businessField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            businessField.setText(receivedPersonInfo.business);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        String userid = receivedPersonInfo.uid;
        String username = nameField.getText().toString();
        String useremail = emailField.getText().toString();
        String userbusiness = businessField.getText().toString();
        String useraddress = addressField.getText().toString();
        String userprovince = provinceField.getText().toString();
        Contact update = new Contact(userid, username, useremail, userbusiness, useraddress, userprovince);
        appState.firebaseReference.child(userid).setValue(update);
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void eraseContact(View v)
    {
        String userid = receivedPersonInfo.uid;
        appState.firebaseReference.child(userid).removeValue();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
