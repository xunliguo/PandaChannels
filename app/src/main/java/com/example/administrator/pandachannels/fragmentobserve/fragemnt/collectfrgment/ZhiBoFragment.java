package com.example.administrator.pandachannels.fragmentobserve.fragemnt.collectfrgment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private List<Students> lists;

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
        lists = studentsDao.queryBuilder().build().list();

        for (int i = 0; i < lists.size(); i++) {
            mlist.add(new HomeShou(lists.get(i).getTitle(), lists.get(i).getUrl()));
        }

        adap = new Adap(getActivity(), mlist);
        zhibo_lv.setAdapter(adap);

        zhibo_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {
                AlertDialog.Builder normalDialog = new AlertDialog.Builder(getActivity());
                 normalDialog.setMessage("确认删除这条收藏？");
                normalDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Students students = lists.get(i);
                                studentsDao.delete(students);
                                mlist.clear();
                                List<Students> list = studentsDao.queryBuilder().build().list();
                                for (int j = 0; j < list.size(); j++) {
                                    mlist.add(new HomeShou(list.get(j).getTitle(),list.get(j).getUrl()));
                                }

                                adap.notifyDataSetChanged();


                            }
                        });
                normalDialog.setNegativeButton("关闭",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //...To-do
                            }
                        });

       normalDialog.show();

            }
        });

    }


    private void initView(View view) {
        zhibo_lv = (ListView) view.findViewById(R.id.zhibo_lv);
    }
}
