package com.example.hemendra.servicetest;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   // MyBroadcastRecieve myBroadcastRecieve;
    MyBroadcastRecieveBaz myBroadcastRecieveBaz;
    MyBroadcastRecieveFoo myBroadcastRecieveFoo;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBroadcastRecieveBaz=new MyBroadcastRecieveBaz();
        IntentFilter ifilter=new IntentFilter();
        ifilter.addAction(MyIntentService2.ACTION_BAZ);
        registerReceiver(myBroadcastRecieveBaz, ifilter);
        myBroadcastRecieveFoo=new MyBroadcastRecieveFoo();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(MyIntentService2.ACTION_FOO);
        registerReceiver(myBroadcastRecieveFoo, intentFilter);

        MyIntentService2.startActionBaz(this, "hemendra", "singh");
        MyIntentService2.startActionFoo(this,"raj","chauhan");

//        myBroadcastRecieve = new MyBroadcastRecieve();
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(MyIntentService.ACTION_FOO);
//        registerReceiver(myBroadcastRecieve, filter);

//        Intent startservice = new Intent(this, MyIntentService.class);
//        startservice.setAction(MyIntentService.ACTION_FOO);
//        startservice.putExtra(MyIntentService.EXTRA_PARAM1, "hemendra");
//        startservice.putExtra(MyIntentService.EXTRA_PARAM2, "chauhan");
//        startService(startservice);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
       // unregisterReceiver(myBroadcastRecieve);
        unregisterReceiver(myBroadcastRecieveBaz);
        unregisterReceiver(myBroadcastRecieveFoo);

    }

//    private class MyBroadcastRecieve extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent != null) {
//                String name = intent.getStringExtra(MyIntentService.OUT);
//                String lname = intent.getStringExtra(MyIntentService.OUT1);
//                Log.i("MSG", "HHHHHHHHHHHHHHHHHHHHHH" + name + "jjjjjj" + lname);
//                toast = Toast.makeText(context, "dsfgsgasg", Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        }
  //  }
    private class MyBroadcastRecieveFoo extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String name = intent.getStringExtra(MyIntentService2.FOO_PARAM1_OUT);
                String lname = intent.getStringExtra(MyIntentService2.FOO_PARAM2_OUT);
                Log.i("MSG", "HHHHHHHHHHHHHHHHHHHHHH" + name + "jjjjjj" + lname);
                toast = Toast.makeText(context, "dsfgsgasg", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
    private class MyBroadcastRecieveBaz extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String name = intent.getStringExtra(MyIntentService2.BAZ_PARAM1_OUT);
                String lname = intent.getStringExtra(MyIntentService2.BAZ_PARAM2_OUT);
                Log.i("MSG", "HHHHHHHHHHHHHHHHHHHHHH" + name + "jjjjjj" + lname);
                toast = Toast.makeText(context, "dsfgsgasg", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}


