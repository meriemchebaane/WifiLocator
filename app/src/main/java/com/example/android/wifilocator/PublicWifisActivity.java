package com.example.android.wifilocator;

        import android.content.Intent;
        import android.support.v4.app.NavUtils;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.ExpandableListAdapter;
        import android.widget.ExpandableListView;

        import com.example.android.wifilocator.models.Region;
        import com.example.android.wifilocator.models.SSID;
        import com.google.firebase.database.ChildEventListener;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

/**
 * Created by Sherif Meimari on 1/25/2017.
 */

public class PublicWifisActivity extends AppCompatActivity {

    //Expandable List
    ExpandableListView mExpandableListView;
    ExpandableListAdapter mExpandableListAdapter;
    List<String> regionNames;
    HashMap<String,List<String>> regionsMap;

    //Firebase
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_wifis);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //Expandable ListView Components
        mExpandableListView = (ExpandableListView) findViewById(R.id.exp_list);
        regionsMap = new HashMap<>();
        regionNames = new ArrayList<String>(regionsMap.keySet());
        mExpandableListAdapter = new WifiExpandableListAdapter(this, regionNames, regionsMap);

    }

    @Override
    protected void onResume() {
        super.onResume();
        attachDatabaseReadListener();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detachDatabaseListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.settings:
                Intent myIntent = new Intent(PublicWifisActivity.this,
                        SettingsActivity.class);
                startActivity(myIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void attachDatabaseReadListener() {

        //Listener to listen to any item added, changed, removed, moved or cancelled in the Database
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {

                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                    Region region = dataSnapshot.getValue(Region.class);
                    String regionName = region.getRegion();
                    List<String> ssidNames = new ArrayList<String>();
                    for(SSID ssid : region.getListSSID()){
                        String ssidName = ssid.getSSID();
                        ssidNames.add(ssidName);
                    }
                    regionNames.add(regionName);
                    regionsMap.put(regionName, ssidNames);
                    mExpandableListView.setAdapter(mExpandableListAdapter);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            };
            MainActivity.mWifisDatabaseReference.addChildEventListener(mChildEventListener);
        }
    }

    private void detachDatabaseListener() {
        if (mChildEventListener != null) {
            MainActivity.mWifisDatabaseReference.removeEventListener(mChildEventListener);
            mChildEventListener = null;
        }
    }
}
