package com.eventapp.eventapp;import android.content.res.Configuration;import android.content.res.Resources;import android.os.Bundle;import android.support.v4.widget.DrawerLayout;import android.support.v7.app.ActionBarDrawerToggle;import android.support.v7.app.AppCompatActivity;import android.view.Menu;import android.view.MenuItem;import android.view.View;import android.widget.ArrayAdapter;import android.widget.ListView;public class MainActivity extends AppCompatActivity {    private String[] mPlanetTitles;    private ListView mDrawerList;    private DrawerLayout mDrawerLayout;    private ActionBarDrawerToggle mDrawerToggle;    private CharSequence mDrawerTitle = "Navigation";    private CharSequence mTitle = "Event App";    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        Resources res = getResources();        mPlanetTitles = res.getStringArray(R.array.planets_array);        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);        mDrawerList = (ListView) findViewById(R.id.left_drawer);        // Set the adapter for the list view        mDrawerList.setAdapter(new ArrayAdapter<String>(this,        R.layout.drawer_list_item, mPlanetTitles));        // Set the list's click listener        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);        mDrawerToggle = new ActionBarDrawerToggle(                this,                  /* host Activity */                mDrawerLayout,         /* DrawerLayout object */                //R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */                R.string.drawer_open,  /* "open drawer" description */                R.string.drawer_close  /* "close drawer" description */        ) {            /** Called when a drawer has settled in a completely closed state. */            public void onDrawerClosed(View view) {                super.onDrawerClosed(view);                getSupportActionBar().setTitle(mTitle);            }            /** Called when a drawer has settled in a completely open state. */        public void onDrawerOpened(View drawerView) {            super.onDrawerOpened(drawerView);            getSupportActionBar().setTitle(mDrawerTitle);        }    };    // Set the drawer toggle as the DrawerListener    mDrawerLayout.setDrawerListener(mDrawerToggle);        getSupportActionBar().setDisplayHomeAsUpEnabled(true);        getSupportActionBar().setHomeButtonEnabled(true);        }    @Override    protected void onPostCreate(Bundle savedInstanceState) {        super.onPostCreate(savedInstanceState);        // Sync the toggle state after onRestoreInstanceState has occurred.        mDrawerToggle.syncState();        }    @Override    public void onConfigurationChanged(Configuration newConfig) {        super.onConfigurationChanged(newConfig);        mDrawerToggle.onConfigurationChanged(newConfig);        }    @Override    public boolean onOptionsItemSelected(MenuItem item) {        // Pass the event to ActionBarDrawerToggle, if it returns        // true, then it has handled the app icon touch event        if (mDrawerToggle.onOptionsItemSelected(item)) {        return true;        }        // Handle your other action bar items...        return super.onOptionsItemSelected(item);    }    @Override    public boolean onCreateOptionsMenu(Menu menu) {        // Inflate the menu; this adds items to the action bar if it is present.        getMenuInflater().inflate(R.menu.listings_menu, menu);        return true;    }}