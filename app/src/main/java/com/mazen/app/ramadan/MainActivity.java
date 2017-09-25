package com.mazen.app.ramadan;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);


        TextView textView = (TextView) findViewById(R.id.textTitl);
        ListView listView = (ListView) findViewById(R.id.listMenu);
        String[] item = getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.row_item, R.id.textItem, item);
        listView.setAdapter(arrayAdapter);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        textView.setTypeface(typeface);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, PageWeb.class);
                intent.putExtra("page", i);
                startActivity(intent);
            }
        });


    }

    public void ImgShear(View view) {
        String share = " قم بتحميل تطبيق دليل في رمضان لتتعلم وتفهم شروط واحكام الصوم ";
        String LinkMyApp = "https://play.google.com/store/apps/details?id=com.mazen.app.ramadan";
        Intent link = new Intent(Intent.ACTION_SEND);
        link.putExtra(Intent.EXTRA_TEXT, share + "\n" + LinkMyApp);
        link.setType("text/plain");
        startActivity(link);
    }


    public void ImgClose(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}