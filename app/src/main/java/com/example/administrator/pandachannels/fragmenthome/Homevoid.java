package com.example.administrator.pandachannels.fragmenthome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeShiping;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.example.administrator.pandachannels.framework.utils.Urls;
import com.example.greendao1.DaoMaster;
import com.example.greendao1.DaoSession;
import com.example.greendao1.StudentsDao;
import com.google.gson.Gson;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class Homevoid extends AppCompatActivity {

    private JCVideoPlayer hommm;
    private ImageView iiiii;
    private HomeShiping homeShiping;
    private StudentsDao studentsDao;
    int aa = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_homevoid);
        initView();
    }

    private void initView() {
        hommm = (JCVideoPlayer) findViewById(R.id.hommm);
        iiiii = (ImageView) findViewById(R.id.iiiii);
        String homelunbo = getIntent().getStringExtra("homeflunbo");
        final String homeTitile = getIntent().getStringExtra("homeTitile");
        final String homimg = getIntent().getStringExtra("homimg");
        OkHttpUtils.getInstance().getNetData(Urls.VIDEOPLAY + homelunbo, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                homeShiping = new Gson().fromJson(ss, HomeShiping.class);
                final String str = homeShiping.getVideo().getChapters().get(0).getUrl();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hommm.setUp(str,homeTitile);
                    }
                });
            }
        });
        iiiii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (aa == 0) {
                    DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Homevoid.this, "aa.db", null);
                    DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
                    DaoSession daoSession = daoMaster.newSession();
                    studentsDao = daoSession.getStudentsDao();
                    studentsDao.queryBuilder().build().list();
                    studentsDao.insert(new Students(null, 0, homeTitile, homimg));
                    Toast.makeText(Homevoid.this, "已收藏，请到【我的收藏】中查看", Toast.LENGTH_SHORT).show();

                    iiiii.setImageResource(R.drawable.collect_yes);
                    aa = 1;
                }else {
                    /*Students stu1 = studentsDao.queryBuilder().where(StudentsDao.Properties.Title.eq(homeTitile)).build().unique();//查询单
                    if (stu1 != null) {
                        studentsDao.delete(stu1);
                    }*/
                    iiiii.setImageResource(R.drawable.collect_no);
                    Toast.makeText(Homevoid.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                    aa = 0;
                }

            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}
