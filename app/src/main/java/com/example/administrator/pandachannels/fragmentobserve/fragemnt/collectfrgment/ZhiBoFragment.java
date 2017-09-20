package com.example.administrator.pandachannels.fragmentobserve.fragemnt.collectfrgment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;
import com.example.administrator.pandachannels.fragmenthome.adap.Adap;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeShou;
import com.example.greendao1.DaoMaster;
import com.example.greendao1.DaoSession;
import com.example.greendao1.StudentsDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiBoFragment extends Fragment {


    private ListView zhibo_lv;
    private StudentsDao studentsDao;
    private List<HomeShou> mlist = new ArrayList<>();
    private Adap adap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhibofragment, null);
        initView(view);
        initData();

        return view;
    }

    private void initData() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "aa.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        studentsDao = daoSession.getStudentsDao();
        List<Students> lists = studentsDao.queryBuilder().build().list();

        for (int i = 0; i <lists.size() ; i++) {
            mlist.add(new HomeShou(lists.get(i).getTitle(),lists.get(i).getUrl()));
        }
        adap = new Adap(getActivity(), mlist);
        zhibo_lv.setAdapter(adap);

    }

    private void initView(View view) {
        zhibo_lv = (ListView) view.findViewById(R.id.zhibo_lv);
    }
}
