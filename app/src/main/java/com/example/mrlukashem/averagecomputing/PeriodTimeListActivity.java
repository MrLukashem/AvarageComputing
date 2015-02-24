package com.example.mrlukashem.averagecomputing;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class PeriodTimeListActivity extends Activity {

    private List<PeriodTime> periodsList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_time_list);

        ListView _list = (ListView)findViewById(R.id.periodsListView);
        periodsList = new ArrayList<PeriodTime>();
        adapter = new ArrayAdapter<String>(this, R.layout.period_time_list_element);
        _list.setAdapter(adapter);

        Bundle _bundle = getIntent().getExtras();
        PeriodTime _period_time = _bundle.getParcelable("subjects");
        periodsList.add(_period_time);

        adapter.add(_period_time.getName());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.period_time_list, menu);
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
}
