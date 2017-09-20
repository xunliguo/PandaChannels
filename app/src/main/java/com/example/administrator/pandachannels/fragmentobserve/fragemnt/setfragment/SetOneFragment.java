package com.example.administrator.pandachannels.fragmentobserve.fragemnt.setfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetOneFragment extends Fragment implements View.OnClickListener {


    private EditText edit_s;
    private Button submit;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.shi_frist, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        edit_s = (EditText) view.findViewById(R.id.edit_s);
        submit = (Button) view.findViewById(R.id.submit);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String s = edit_s.getText().toString().trim();
        if (TextUtils.isEmpty(s)) {
            Toast.makeText(getContext(), "请输入您的邮箱，方便我们及时给您回复", Toast.LENGTH_SHORT).show();
            return;
        }




    }
}
