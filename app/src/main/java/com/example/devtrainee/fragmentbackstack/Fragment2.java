package com.example.devtrainee.fragmentbackstack;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment2 extends Fragment implements View.OnClickListener{
    FragmentManager fragmentManager;

    @BindView(R.id.bt_second)
    Button bt_second;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(" Fragment 1 OnCreateView called");
        View view = inflater.inflate(R.layout.frag_second, container, false);
        fragmentManager= getFragmentManager();
        if (view != null) {
            ButterKnife.bind(this, view);
            bt_second.setOnClickListener(this);
        }
        return view;
    }
    private void openFragment() {

        Fragment3 fragment3= new Fragment3();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.child_container,fragment3);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        openFragment();
    }
}

