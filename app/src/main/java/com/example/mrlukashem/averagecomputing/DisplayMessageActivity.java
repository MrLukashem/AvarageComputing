package com.example.mrlukashem.averagecomputing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;


public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    Dodanie przedmiotu do listy w menu glownym
     */
    public void addItem(View view) {
        //pobranie stringow od spinnerow i pola tekstowego
        EditText _name = (EditText)findViewById(R.id.editText);
   //     EditText _weight = (EditText)findViewById(R.id.editText);
    //    EditText _grade = (EditText)findViewById(R.id.editText);
        Spinner _weight = (Spinner)findViewById(R.id.spinner_weight);
        Spinner _grade = (Spinner)findViewById(R.id.spinner_grade);

        String _name_string = _name.getText().toString();
        String _weight_string = _weight.getSelectedItem().toString();
        String _grade_string = _grade.getSelectedItem().toString();

        //stworzenie listy pobranych rzeczy od uzytkownika, ktore nastepnie
        //zostana wyslane do glownego activity za pomoca instencji
        ArrayList<String> _array_list = new ArrayList<String>();
        _array_list.add(_name_string);
        _array_list.add(_weight_string);
        _array_list.add(_grade_string);

        Intent _this_i = new Intent();
        _this_i.putStringArrayListExtra("result", _array_list);
        setResult(RESULT_OK, _this_i);
        this.finish();
    }
}
