// Ankita Tank
// CS478
// Project 1 mp1
// Using Android Emulator Nexus 5 API 25

package com.example.android.project_1_atank2;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by MissTank on 9/20/17.
 */
public class MainActivity extends AppCompatActivity
{

    protected Button textButton;

    // Set the layout to activity_main as the start screen of the App
    // Get the textbutton id to set the onClickListener functionality
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textButton = (Button) findViewById(R.id.contactpage);
        textButton.setOnClickListener(editorListener);
    }

    // Call to a function which switches intent from mainActivity to ContactActivity
    public View.OnClickListener editorListener = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            activityContacts();
        }
    };

    // Start the ContactActivity
    private void activityContacts()
    {
        Intent newview = new Intent(MainActivity.this, ContactActivity.class);
        startActivity(newview);
    }
}
