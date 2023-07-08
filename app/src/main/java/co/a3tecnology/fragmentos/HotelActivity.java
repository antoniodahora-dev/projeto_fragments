package co.a3tecnology.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class HotelActivity extends AppCompatActivity implements  HotelListFragment.AoClicarNoHotel{


    @Override
    protected void onCreate(Bundle savenInstanceState) {
        super.onCreate(savenInstanceState);

        setContentView(R.layout.activity_hotel);
    }

    @Override
    public void clicouNoHotel(Hotel hotel) {
        if(isTablet()) {
            HotelDetalhesFragment fragment = HotelDetalhesFragment.novaInstancia(hotel);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe, fragment, HotelDetalhesFragment.TAG_DETALHE);
            ft.commit();
        } else {

            Intent it = new Intent(this, HotelDetalheActivity.class);
            it.putExtra(HotelDetalheActivity.EXTRA_HOTEL, hotel);
            startActivity(it);
        }
    }

    private boolean isTablet() {
        return findViewById(R.id.detalhe) != null;
    }

}
