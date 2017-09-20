package com.example.administrator.pandachannels.fragmentobserve.fragemnt.setfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pandachannels.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetTwoFragment extends Fragment {


    public SetTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=View.inflate(getActivity(),R.layout.shi_two,null);
        return view;
    }

}
