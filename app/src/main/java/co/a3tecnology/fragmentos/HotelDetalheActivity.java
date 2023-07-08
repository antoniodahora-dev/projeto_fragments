package co.a3tecnology.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class HotelDetalheActivity extends AppCompatActivity {

    public  static final String EXTRA_HOTEL = "hotel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detalhe);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Hotel hotel = (Hotel) intent.getSerializableExtra(EXTRA_HOTEL);
            HotelDetalhesFragment fragment = HotelDetalhesFragment.novaInstancia(hotel);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe, fragment, HotelDetalhesFragment.TAG_DETALHE);
            ft.commit();

        }
    }
}