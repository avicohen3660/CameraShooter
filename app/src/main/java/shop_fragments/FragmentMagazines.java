package shop_fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.camerashooter.R;

import java.util.Objects;

public class FragmentMagazines extends Fragment {

    @Override  @Nullable  @SuppressLint("SetTextI18n")
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_magazines, container, false);
        TextView shopType = view.findViewById(R.id.tv_shop_type);
        shopType.setText("Magazine Shop");
        return view;
    }
}