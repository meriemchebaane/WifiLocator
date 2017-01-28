package com.example.android.wifilocator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class PublicWifisActivity extends AppCompatActivity {


    //Firebase
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_wifis);

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

    private void attachDatabaseReadListener() {

        //Listener to listen to any item added, changed, removed, moved or cancelled in the Database
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
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
