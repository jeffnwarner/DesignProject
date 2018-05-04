package com.example.g.luciddreamgenerator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;


public class JournalActivity extends AppCompatActivity {

    List<String> dreams = new LinkedList<String>();

    CheckBox checkbox1;
    CheckBox checkbox2;
    CheckBox checkbox3;
    CheckBox checkbox4;
    CheckBox checkbox5;
    CheckBox checkbox6;

    EditText dreamEdit;
    EditText myEdit1;
    EditText myEdit2;
    EditText myEdit3;
    EditText myEdit4;
    EditText myEdit5;
    EditText myEdit6;
    String content;
    String content1;
    String content2;
    String content3;
    String content4;
    String content5;
    String content6;
    RatingBar dreamRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dreamEdit = (EditText)findViewById(R.id.editText0);
        myEdit1 = (EditText)findViewById(R.id.editText1);
        myEdit2 = (EditText)findViewById(R.id.editText2);
        myEdit3 = (EditText)findViewById(R.id.editText3);
        myEdit4 = (EditText)findViewById(R.id.editText4);
        myEdit5 = (EditText)findViewById(R.id.editText5);
        myEdit6 = (EditText)findViewById(R.id.editText6);



        content = dreamEdit.getText().toString();
        content1 = myEdit1.getText().toString();
        content2 = myEdit2.getText().toString();
        content3 = myEdit3.getText().toString();
        content4 = myEdit4.getText().toString();
        content5 = myEdit5.getText().toString();
        content6 = myEdit6.getText().toString();


        checkbox1 = findViewById(R.id.checkBox1);
        checkbox2 = findViewById(R.id.checkBox2);
        checkbox3 = findViewById(R.id.checkBox3);
        checkbox4 = findViewById(R.id.checkBox4);
        checkbox5 = findViewById(R.id.checkBox5);
        checkbox6 = findViewById(R.id.checkBox6);


        dreamRating = (RatingBar) findViewById(R.id.ratingBar);

        setUpSaveButton();
        setUpCancelButton();
        loadCustomFields();
    }

    protected void loadCustomFields() {
        String[] temp_loaded_fields;
        SharedPreferences settings = getApplicationContext().getSharedPreferences("stored_fields", 0);
        String loaded_dreams = settings.getString("fields", "");
        temp_loaded_fields = loaded_dreams.split("~");
        if (temp_loaded_fields.length == 6) {
            if (temp_loaded_fields[0].equals("`"))
                myEdit1.setText("");
            else
                myEdit1.setText(temp_loaded_fields[0]);
            if (temp_loaded_fields[1].equals("`"))
                myEdit2.setText("");
            else
                myEdit2.setText(temp_loaded_fields[1]);
            if (temp_loaded_fields[2].equals("`"))
                myEdit3.setText("");
            else
                myEdit3.setText(temp_loaded_fields[2]);
            if (temp_loaded_fields[3].equals("`"))
                myEdit4.setText("");
            else
                myEdit4.setText(temp_loaded_fields[3]);
            if (temp_loaded_fields[4].equals("`"))
                myEdit5.setText("");
            else
                myEdit5.setText(temp_loaded_fields[4]);
            if (temp_loaded_fields[5].equals("`"))
                myEdit6.setText("");
            else
                myEdit6.setText(temp_loaded_fields[5]);
        }

    }


    protected void saveCustomFields() {
        SharedPreferences settings = getApplicationContext().getSharedPreferences("stored_fields", 0);
        SharedPreferences.Editor editor = settings.edit();
        StringBuilder sb = new StringBuilder();
        if (myEdit1.getText().toString().isEmpty())
            sb.append("`").append("~");
        else
            sb.append(myEdit1.getText().toString()).append("~");
        if (myEdit2.getText().toString().isEmpty())
            sb.append("`").append("~");
        else
            sb.append(myEdit2.getText().toString()).append("~");
        if (myEdit3.getText().toString().isEmpty())
            sb.append("`").append("~");
        else
            sb.append(myEdit3.getText().toString()).append("~");
        if (myEdit4.getText().toString().isEmpty())
            sb.append("`").append("~");
        else
            sb.append(myEdit4.getText().toString()).append("~");
        if (myEdit5.getText().toString().isEmpty())
            sb.append("`").append("~");
        else
            sb.append(myEdit5.getText().toString()).append("~");
        if (myEdit6.getText().toString().isEmpty())
            sb.append("`").append("~");
        else
            sb.append(myEdit6.getText().toString()).append("~");


        editor.putString("fields", sb.toString());
        editor.apply();
    }

    public void setUpCancelButton() {
        Button cancel_button = (Button) findViewById(R.id.button4);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCustomFields();
                startActivity(new Intent(JournalActivity.this, MainActivity.class));
            }
        });


    }

    public void setUpSaveButton() {
        Button save_button = (Button) findViewById(R.id.button3);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                content = dreamEdit.getText().toString();
                content1 = myEdit1.getText().toString();
                content2 = myEdit2.getText().toString();
                content3 = myEdit3.getText().toString();
                content4 = myEdit4.getText().toString();
                content5 = myEdit5.getText().toString();
                content6 = myEdit6.getText().toString();


                checkbox1 = findViewById(R.id.checkBox1);
                checkbox2 = findViewById(R.id.checkBox2);
                checkbox3 = findViewById(R.id.checkBox3);
                checkbox4 = findViewById(R.id.checkBox4);
                checkbox5 = findViewById(R.id.checkBox5);
                checkbox6 = findViewById(R.id.checkBox6);


                if (content.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Can't Save Empty Dream Log!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if ( (content1.isEmpty() && checkbox1.isChecked()) ||
                        (content2.isEmpty() && checkbox2.isChecked()) ||
                        (content3.isEmpty() && checkbox3.isChecked()) ||
                        (content4.isEmpty() && checkbox4.isChecked()) ||
                        (content5.isEmpty() && checkbox5.isChecked()) ||
                        (content6.isEmpty() && checkbox6.isChecked()) ) {
                    Toast.makeText(getBaseContext(), "Can't Check Empty Custom Field!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getBaseContext(), JournalListActivity.class);

                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDream = df.format(c);
               // Toast.makeText(getBaseContext(), formattedDream, Toast.LENGTH_SHORT).show();

                formattedDream = formattedDream.concat(" - \"");
                formattedDream = formattedDream.concat(content);
                formattedDream = formattedDream.concat("\"");

                if (checkbox1.isChecked())
                    formattedDream = formattedDream.concat("\n" + content1);
                if (checkbox2.isChecked())
                    formattedDream = formattedDream.concat("\n" + content2);
                if (checkbox3.isChecked())
                    formattedDream = formattedDream.concat("\n" + content3);
                if (checkbox4.isChecked())
                    formattedDream = formattedDream.concat("\n" + content4);
                if (checkbox5.isChecked())
                    formattedDream = formattedDream.concat("\n" + content5);
                if (checkbox6.isChecked())
                    formattedDream = formattedDream.concat("\n" + content6);


                if (dreamRating.getRating() != 0)
                    formattedDream = formattedDream.concat("\nDream Quality: " + String.valueOf(dreamRating.getRating()) + " stars.");

                saveCustomFields();
                loadDreams();
                dreams.add(formattedDream);
                saveDreams();
                //intent.putExtra("DREAM_CONTENT", formattedDream);
                //startActivity(intent);

                Toast.makeText(getBaseContext(), "Journal Entry Added.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(JournalActivity.this, MenuActivity.class));
            }
        });
    }

    protected void loadDreams() {
        String[] temp_loaded_dreams;
        SharedPreferences settings = getApplicationContext().getSharedPreferences("stored_dreams", 0);
        String loaded_dreams = settings.getString("dreams", "");
        temp_loaded_dreams = loaded_dreams.split("~>_");
        dreams = new ArrayList<String>(Arrays.asList(temp_loaded_dreams));

        if (temp_loaded_dreams[0].isEmpty()) // remove initial empty dream
            dreams.clear();
    }


    protected void saveDreams() {
        SharedPreferences settings = getApplicationContext().getSharedPreferences("stored_dreams", 0);
        SharedPreferences.Editor editor = settings.edit();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dreams.size(); i++) {
            sb.append(dreams.get(i)).append("~>_");
        }
        editor.putString("dreams", sb.toString());
        editor.apply();
    }

}
