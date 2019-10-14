package com.example.whatsapp;

import android.content.res.Resources;
import android.os.Bundle;

import com.example.whatsapp.Adaptadores.AdaptadorChat;
import com.example.whatsapp.Adaptadores.AdaptadorEstado;
import com.example.whatsapp.Adaptadores.AdaptadorLlamadas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;


public class WhatsAppTabbed extends AppCompatActivity {

    ArrayList<Contacto> arrayContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app_tabbed);


        Resources res = getResources();
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        //Tab Camera
        TabHost.TabSpec spec=tabs.newTabSpec("tabCamera");
        spec.setContent(R.id.tabCamera);
        spec.setIndicator("",res.getDrawable(R.drawable.ic_camera_alt_black_24dp,null));
        tabs.addTab(spec);

        //Tab Chat

        arrayContacto = new ArrayList<Contacto>();

        arrayContacto.add(new Contacto(R.mipmap.ic_contacto1,"Rodrigo","Hey!!","01:00"));

        spec=tabs.newTabSpec("tabChat");

        ListView listChat = findViewById(R.id.tabChat);

        final AdaptadorChat adaptadorChat = new AdaptadorChat(this,arrayContacto);

        listChat.setAdapter(adaptadorChat);

        spec.setContent(R.id.tabChat);
        spec.setIndicator("Chat");
        tabs.addTab(spec);
        tabs.setCurrentTab(0);

        //Tab Estados


        spec=tabs.newTabSpec("tabEstados");

        ListView listEstado = findViewById(R.id.tabEstados);

        final AdaptadorEstado adaptadorEstado = new AdaptadorEstado(this,arrayContacto);

        listEstado.setAdapter(adaptadorEstado);

        spec.setContent(R.id.tabEstados);
        spec.setIndicator("Estados");
        tabs.addTab(spec);
        tabs.setCurrentTab(1);

        //Tab Llamadas
        spec=tabs.newTabSpec("tabLlamadas");

        ListView listLlamadas = findViewById(R.id.tabLlamadas);

        final AdaptadorLlamadas adaptadorLlamadas = new AdaptadorLlamadas(this,arrayContacto);

        listLlamadas.setAdapter(adaptadorLlamadas);

        spec.setContent(R.id.tabLlamadas);
        spec.setIndicator("Llamadas");
        tabs.addTab(spec);
        tabs.setCurrentTab(2);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                Log.i("AndroidTabsDemo","Pulsada pestaña: "+s);
            }
        });
    }


}