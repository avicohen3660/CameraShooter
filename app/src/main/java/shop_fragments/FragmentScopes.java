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

public class FragmentScopes extends Fragment {

        @Override @Nullable @SuppressLint("SetTextI18n")
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_scopes, container, false);

            ((TextView)getActivity().findViewById(R.id.tv_shop_type)).setText("Scopes Shop");

            return view;
        }
    }

