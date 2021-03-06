package ru.artempugachev.tempconverter;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends ActionBarActivity {
    private TextView m_tvCelsius;
    private TextView m_tvFahr;
    private ImageButton m_btnCtoF;
    private ImageButton m_btnFtoC;
    private Temperature m_temperature;
    private AdView m_adView;
    private Button m_btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();

//        m_tvCelsius.setText(R.string.banner_ad_unit_id);
    }

    private void getViews() {
        //  Получаем все элементы управления
        m_tvCelsius = (TextView) findViewById(R.id.tvCelsius);
        m_tvFahr = (TextView) findViewById(R.id.tvFahr);
        m_btnCtoF = (ImageButton) findViewById(R.id.btnCtoF);
        m_btnFtoC = (ImageButton) findViewById(R.id.btnFtoC);

        m_btnCtoF.setOnClickListener(ctoFListener);
        m_btnFtoC.setOnClickListener(fToCListener);

        m_temperature = new Temperature();

        m_adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        m_adView.loadAd(adRequest);

        m_btnRefresh = (Button) findViewById(R.id.btnRefresh);

        m_btnRefresh.setOnClickListener(refreshListener);
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
//        if (id == R.id.action_settings) {
//            return true;
//        }

//        if(id == R.id.action_refresh) {
//            refreshFields();
//        }

        return super.onOptionsItemSelected(item);
    }

    private void refreshFields() {
        //  Очищаем поля ввода
        m_tvCelsius.setText("");
        m_tvFahr.setText("");
    }

    private View.OnClickListener refreshListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            refreshFields();
        }
    };

    private View.OnClickListener ctoFListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String sCelsius = m_tvCelsius.getText().toString();
            if(sCelsius.length() > 0) {
                m_temperature.setCelsius(Float.parseFloat(sCelsius));
                m_temperature.celsiusToFahrenheit();
                m_tvFahr.setText(String.valueOf(m_temperature.getFahrenheit()));
            }

        }
    };

    private View.OnClickListener fToCListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String sFahr = m_tvFahr.getText().toString();
            if(sFahr.length() > 0) {
                m_temperature.setFahrenheit(Float.parseFloat(sFahr));
                m_temperature.fahrrenheitToCelsius();
                m_tvCelsius.setText(String.valueOf(m_temperature.getCelsius()));
            }

        }
    };
}

