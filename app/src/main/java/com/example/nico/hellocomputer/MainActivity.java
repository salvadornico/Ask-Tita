package com.example.nico.hellocomputer;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    private TextView answerDisplay;
    private Button askButton;
    private ImageView picture;
    private TextView countDisplay;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerDisplay = (TextView) findViewById(R.id.answer);
        askButton = (Button) findViewById(R.id.button);
        picture = (ImageView) findViewById(R.id.imageView);
        countDisplay = (TextView) findViewById(R.id.ask_count);

        countDisplay.setText(R.string.ask_count_start);
    }

    public void askTita(View view) {
        generateEntry();
        askButton.setText(R.string.button_v2);
        ++count;
        updateCount();
    }

    private void updateCount() {
        Resources res = getResources();
        countDisplay.setText(String.format(res.getString(R.string.ask_count),count));
    }

    public void generateEntry() {
        Random rand = new Random(System.currentTimeMillis());
        int randNum;
        randNum = rand.nextInt(16);
        if (randNum == 1)
            answerDisplay.setText(R.string.option1);
        else if (randNum == 2)
            answerDisplay.setText(R.string.option2);
        else if (randNum == 3)
            answerDisplay.setText(R.string.option3);
        else if (randNum == 4)
            answerDisplay.setText(R.string.option4);
        else if (randNum == 5)
            answerDisplay.setText(R.string.option5);
        else if (randNum == 6)
            answerDisplay.setText(R.string.option6);
        else if (randNum == 7)
            answerDisplay.setText(R.string.option7);
        else if (randNum == 8)
            answerDisplay.setText(R.string.option8);
        else if (randNum == 9)
            answerDisplay.setText(R.string.option9);
        else if (randNum == 10)
            answerDisplay.setText(R.string.option10);
        else if (randNum == 11)
            answerDisplay.setText(R.string.option11);
        else if (randNum == 12)
            answerDisplay.setText(R.string.option12);
        else if (randNum == 13)
            answerDisplay.setText(R.string.option13);
        else if (randNum == 14)
            answerDisplay.setText(R.string.option14);
        else if (randNum == 15)
            answerDisplay.setText(R.string.option15);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.twitter) {
            openWebPage("https://twitter.com/titasofmanila");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
