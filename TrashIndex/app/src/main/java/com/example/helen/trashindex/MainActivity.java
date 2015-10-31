package com.example.helen.trashindex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.google.zxing.integration.android.IntentIntegrator;
import android.content.Intent;
import android.hardware.Camera;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Open Product Scanner", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                scanBarcodeBackCamera(view);

                // If you're using the support library, use IntentIntegrator.forSupportFragment(this) instead.
            }
        });
    }

    public void scanBarcodeBackCamera(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCameraId(Camera.CameraInfo.CAMERA_FACING_BACK);
        integrator.initiateScan(IntentIntegrator.PRODUCT_CODE_TYPES);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String toast = null;
        if(result != null) {
            if(result.getContents() == null) {
                toast = "Cancelled from fragment";
                return;
            } else {
                toast = "Scanned from fragment: " + result.getContents();
            }

            // At this point we may or may not have a reference to the activity
            //displayToast();
            Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), ItemDetailActivity.class);
            i.putExtra(ItemDetailFragment.ARG_ITEM_ID, result.getContents());
            startActivity(i);
        }
    }

}
