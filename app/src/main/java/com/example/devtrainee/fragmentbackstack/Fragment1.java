package com.example.devtrainee.fragmentbackstack;

import android.content.Intent;
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

public class Fragment1 extends Fragment implements View.OnClickListener{


    @BindView(R.id.bt_first)
    Button bt_first;
    FragmentManager fragmentManager;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(" Fragment 1 OnCreateView called");
        View view = inflater.inflate(R.layout.frag_first, container, false);
        fragmentManager= getChildFragmentManager();
        if (view != null) {
            ButterKnife.bind(this, view);
           bt_first.setOnClickListener(this);
        }
        return view;
    }
    private void openFragment() {

            Fragment2 fragment2= new Fragment2();
            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.child_container,fragment2);
            fragmentTransaction.addToBackStack("Yes");
            fragmentTransaction.commit();
        }

    @Override
    public void onClick(View view) {
        openFragment();
    }
}
