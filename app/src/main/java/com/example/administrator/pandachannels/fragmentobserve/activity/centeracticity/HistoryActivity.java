package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;
import com.example.administrator.pandachannels.fragmentobserve.adapter.Myadapter111;
import com.example.greendao1.DaoMaster;
import com.example.greendao1.DaoSession;
import com.example.greendao1.StudentsDao;

import java.util.List;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listview;
    private StudentsDao studentsDao;
    private Myadapter111 myadapter111;
    private ImageView his_img888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        initData();
    }

    private void initData() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(HistoryActivity.this, "ss.db", null);

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());

        DaoSession daoSession = daoMaster.newSession();

        studentsDao = daoSession.getStudentsDao();
        final List<Students> list11 = studentsDao.queryBuilder().build().list();
        myadapter111 = new Myadapter111(HistoryActivity.this, list11);
        listview.setAdapter(myadapter111);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HistoryActivity.this);
                builder.setMessage("确认删除此条记录吗？~~");
                builder.setNegativeButton("算了吧", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("好的哦", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Students unique = studentsDao.queryBuilder().where(StudentsDao.Properties.Id.eq(list11.get(i).getId())).build().unique();
                        studentsDao.delete(unique);
                        list11.remove(i);
                        myadapter111.notifyDataSetChanged();
                        dialog.dismiss();

                    }
                });
                builder.create();
                builder.show();
            }
        });
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.list);
        his_img888 = (ImageView) findViewById(R.id.his_img888);
        his_img888.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
