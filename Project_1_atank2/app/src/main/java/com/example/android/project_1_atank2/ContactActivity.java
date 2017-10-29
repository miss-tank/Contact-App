// Ankita Tank
// CS478
// Project 1 mp1
// Using Android Emulator Nexus 5 API 25
package com.example.android.project_1_atank2;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by MissTank on 9/20/17.
 */

public class ContactActivity extends AppCompatActivity
{
    // Required Variables
    static final int PICK_CONTACT_REQUEST = 1;
    protected Button proceedtocontacts;
    protected String status_string;
    protected TextView statustext;
    protected String first_name;
    protected String last_name;
    protected Intent intent;
    protected EditText edit;
    protected String result;


    // Set the layout view to contact_page xml
    // create an onClick Listener for the button(contact) to perform required functionality

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_page);
        proceedtocontacts = (Button) findViewById(R.id.contacts);
        proceedtocontacts.setOnClickListener(contact);
    }


    // This function checks the input string typed by the user
    // a valid string will switch the intent from contact_activity to an Action_insert contact page
    // an invalid string will show the status of invalid input.
    public View.OnClickListener contact = new View.OnClickListener()
    {
        public void onClick(View v)
        {
             edit = (EditText)findViewById(R.id.name);
             result = edit.getText().toString();

            statustext= (TextView)findViewById(R.id.statustext) ;
            String[] tokens = result.split(" ");

            if(tokens.length >= 2)
            {
                intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.NAME, result);
                intent.putExtra("finishActivityOnSaveCompleted",	true);

                if (intent.resolveActivity(getPackageManager()) != null)
                {
                    startActivityForResult(intent,1);
                }
            }
            else
            {
                status_string = "You entered an inappropriate Syntax for the name !";
                statustext.setText(status_string);
            }
        }
    };


    // This fucntions checks the requestCode from the Contact page in the app
    // requestCode == RESULT_OK : Contact was successfully saved
    // requestCode == RESULT_CANCELED : The Contact was not saved / process was cancelled
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String a = String.valueOf(requestCode);

        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                statustext.setText( "Your contact information has been saved. Thank you !!");
            }
            else if (resultCode == RESULT_CANCELED)
            {
                statustext.setText("You Cancelled an on going process. \n Contact Was not Saved!!");
            }
        }
    }
}
