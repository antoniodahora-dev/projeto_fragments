package co.a3tecnology.fragmentos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class HotelListFragment extends ListFragment {

    List<Hotel> mHoteis; // lista de hoteis
    ArrayAdapter<Hotel> mAdapter; // irá exibir na tela a lista de hoteis na tela

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHoteis = carregarHoteis(); // iniciar a lista de hoteis chamando o metodo
        mAdapter = new ArrayAdapter<Hotel>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                mHoteis);
        setListAdapter(mAdapter);
    }

    private List<Hotel> carregarHoteis() {
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel ("New Beach", "Av. Boa Viagem", 4.5f));
        hotels.add(new Hotel ("Feira de Santana", "Av. Boa Viagem", 4f));
        hotels.add(new Hotel ("Santo Antonio de Jesus", "Av. Boa Viagem", 4.5f));
        hotels.add(new Hotel ("Salvador", "Av. Boa Viagem", 5f));
        hotels.add(new Hotel ("Ipirá", "Av. Boa Viagem", 3.5f));
        hotels.add(new Hotel ("Madre de Deus", "Av. Boa Viagem", 2.5f));

        hotels.add(new Hotel ("New Beach", "Av. Boa Viagem", 4.5f));
        hotels.add(new Hotel ("Feira de Santana", "Av. Boa Viagem", 4f));
        hotels.add(new Hotel ("Santo Antonio de Jesus", "Av. Boa Viagem", 4.5f));
        hotels.add(new Hotel ("Salvador", "Av. Boa Viagem", 5f));
        hotels.add(new Hotel ("Ipirá", "Av. Boa Viagem", 3.5f));
        hotels.add(new Hotel ("Madre de Deus", "Av. Boa Viagem", 2.5f));
        return hotels;
    }

    //ira ouvir o evento de click
    @Override
    public void onListItemClick(ListView l, View v,int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();
        if (activity instanceof AoClicarNoHotel) {
            Hotel hotel = (Hotel)l.getItemAtPosition(position);
             AoClicarNoHotel listener = (AoClicarNoHotel)activity;
             listener.clicouNoHotel(hotel);
        }
    }

    public interface AoClicarNoHotel{
        void clicouNoHotel(Hotel hotel);
    }
}
