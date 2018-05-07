package fr.eni.android.ch10_viewpagerexemple;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;


public class BusquedaFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_busqueda, container, false);

        Button buttonD = (Button) rootView.findViewById(R.id.buttonDia);
        Button buttonM = (Button) rootView.findViewById(R.id.buttonMes);

        buttonD.setOnClickListener((View.OnClickListener) this);
        buttonM.setOnClickListener((View.OnClickListener) this);


        return rootView;

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.buttonDia:
                fragment = new DiaFragment();
                replaceFragment(fragment);
                break;

            case R.id.buttonMes:
                fragment = new MesFragment();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}