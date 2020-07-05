package com.example.menuwithradiobutton;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int itemSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectNetwork(View view) {
        registerForContextMenu(view);
        openContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.network_menu, menu);

        MenuItem wifiItem = menu.findItem(R.id.WifiId);
        MenuItem bluetoothItem = menu.findItem(R.id.BluetoothId);
        MenuItem mobileDataItem = menu.findItem(R.id.MobileDataId);

        switch (itemSelected){
            case 1:
                wifiItem.setChecked(true);
                break;
            case 2:
                bluetoothItem.setChecked(true);
                break;
            case 3:
                mobileDataItem.setChecked(true);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.WifiId:
                Toast.makeText(getApplicationContext(), "Wifi is selected....", Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                itemSelected = 1;
                return true;
            case R.id.BluetoothId:
                Toast.makeText(getApplicationContext(), "Bluetooth is selected....", Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                itemSelected = 2;
                return true;
            case R.id.MobileDataId:
                Toast.makeText(getApplicationContext(), "MobileData is selected....", Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                itemSelected = 3;
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}