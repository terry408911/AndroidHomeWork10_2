package com.terry.nmy10_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private static String msg = null;
    private LocalChangeReceiver localChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        localChangeReceiver = new LocalChangeReceiver();
        registerReceiver(localChangeReceiver,intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localChangeReceiver);
    }

    class LocalChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context,Intent intent){
            Log.d("LocalChangeReceiver","语言已切换");
        }
    }
}
