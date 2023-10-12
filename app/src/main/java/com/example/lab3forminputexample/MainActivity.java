package com.example.lab3forminputexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem i = menu.findItem(R.id.itemNext);
        i.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                handleButtonClick(null);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void handleButtonClick(View v){
        CheckBox cb = (CheckBox)findViewById(R.id.checkBox);
        if (!cb.isChecked()){
            Toast t = Toast.makeText(this, "You must agree to the term", Toast.LENGTH_SHORT);
            t.show();
        } else {
            displayAlert();
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        }
    }

    private void displayAlert() {
        EditText edtName = (EditText) findViewById(R.id.edt1);
        String name = edtName.getText().toString();
        EditText edtEmail = (EditText) findViewById(R.id.edt2);
        String email = edtEmail.getText().toString();
        EditText edtPhone = (EditText) findViewById(R.id.edt3);
        String phone = edtPhone.getText().toString();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        String workStatus = rb.getText().toString();
        new AlertDialog.Builder(this)
                .setTitle("Details entered:\n"
                + name + "\n"
                + email + "\n"
                + phone + "\n"
                + workStatus + "\n").setNeutralButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lab 3 part 2", "onStart event call");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lab 3 part 2", "onRestart event call");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lab 3 part 2", "onResume event call");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lab 3 part 2", "onPause event call");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lab 3 part 2", "onStop event call");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lab 3 part 2", "onDestroy event call");
    }
}