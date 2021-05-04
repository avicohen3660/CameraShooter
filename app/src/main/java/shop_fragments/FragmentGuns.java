package shop_fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.camerashooter.R;

import java.util.ArrayList;

import CustomCard.RecyclerViewAdapter;
import CustomCard.ElementInfo;

public class FragmentGuns extends Fragment {


        @Override @Nullable @SuppressLint("SetTextI18n")
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_guns, container, false);


            ArrayList<ElementInfo> elements = new ArrayList<>();
            elements.add(new ElementInfo("Pistol",100,R.drawable.ic_gun_24));
            elements.add(new ElementInfo("Pistol",100,R.drawable.ic_gun_24));
            elements.add(new ElementInfo("Pistol",100,R.drawable.ic_gun_24));
            elements.add(new ElementInfo("Pistol",100,R.drawable.ic_gun_24));
            elements.add(new ElementInfo("Pistol",100,R.drawable.ic_gun_24));
            elements.add(new ElementInfo("Pistol",100,R.drawable.ic_gun_24));
            elements.add(new ElementInfo("Pistol2",200,R.drawable.ic_gun_24));


            RecyclerView recyclerView = view.findViewById(R.id.recycle_view_guns);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(), elements);
            recyclerView.setAdapter(adapter);

            return view;

        }
}
