package shop_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.camerashooter.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Shop extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shop);
//    }
//
//    public void OnItemSelectedListener(MenuItem item) {
//
//        switch (item.getItemId()){
//
//            case R.id.guns:
//                //fragment guns
//                break;
//
//            case R.id.scopes:
//                //fragment scopes
//                break;
//
//            case R.id.magazines:
//                //fragment magazines
//                break;
//
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        BottomNavigationView bottomNav = findViewById(R.id.shop_navigation);
        Log.e("taginu",(bottomNav==null)+"");
        bottomNav.setOnNavigationItemSelectedListener(navListener);
//        I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentGuns()).commit();
        }
    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = new FragmentGuns();
                    switch (item.getItemId()) {

                        case R.id.guns:
                            //fragment guns
                            selectedFragment = new FragmentGuns();
                            break;

                        case R.id.scopes:
                            //fragment scopes
                            selectedFragment = new FragmentScopes();
                            break;

                        case R.id.magazines:
                            //fragment magazines
                            selectedFragment = new FragmentMagazines();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
