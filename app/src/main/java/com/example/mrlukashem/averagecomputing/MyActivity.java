package com.example.mrlukashem.averagecomputing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.content.Intent;
import java.util.*;
import java.util.zip.Inflater;

import android.widget.Toast;


public class MyActivity extends Activity {
    private List<Subject> subjectsList;

    static final int PICK_CONTACT_REQUEST = 1;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        subjectsList = new ArrayList<Subject>();

        ListView _list = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, R.layout.list_element);
        _list.setAdapter(adapter);
    }

    public void addRecord(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivityForResult(intent, PICK_CONTACT_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
  //      this.finish();
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
    //        this.finish();
            if (resultCode == RESULT_OK) {
                ArrayList<String> _result = data.getStringArrayListExtra("result");

                String _name = _result.get(0);
                String _weight_string = _result.get(1);
                String _grade_string = _result.get(2);

                String _result_string = _name;
                _result_string += "\nWaga: " + _weight_string + "\nOcena: " + _grade_string;
                adapter.add(_result_string);

                subjectsList.add(
                        new Subject(Integer.valueOf(_weight_string), Double.valueOf(_grade_string), _name));
            }
        }
    }

    public void calculation(View view) {
        double _result = 0.0;
        int _weight_sum = 0;

        for(Subject _subject : subjectsList) {
            _result += _subject.getGrade() * _subject.getWeight();
            _weight_sum += _subject.getWeight();
        }

        if(_weight_sum != 0)
            _result /= _weight_sum;

        Toast _t = Toast.makeText(getApplicationContext(), Double.toString(_result), Toast.LENGTH_LONG);
        _t.show();
    }

    public void archive(View view) {
        AlertDialog.Builder _builder = new AlertDialog.Builder(this);
        LayoutInflater _inflater = this.getLayoutInflater();

        _builder.setMessage("Proszę podać nazwę: ")
                .setView(_inflater.inflate(R.layout.period_time_name_getter, null))
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        _builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_clear:
                adapter.clear();
                subjectsList.clear();
                return true;
            case R.id.action_settings:
                return true;
            case R.id.archive:
                Intent intent = new Intent(this, PeriodTimeListActivity.class);

                intent.putExtra("subjects",new PeriodTime("semestr", new ArrayList<Subject>(subjectsList)));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
