package com.example.administrator.pandachannels.fragmenthome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;
import com.example.administrator.pandachannels.fragmenthome.bean.Livehome;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.example.greendao1.DaoMaster;
import com.example.greendao1.DaoSession;
import com.example.greendao1.StudentsDao;
import com.google.gson.Gson;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class Homelive extends AppCompatActivity {

    private JCVideoPlayer homeocontroller1;
    private StudentsDao studentsDao;
    int aa = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_homelive);
        initView();
    }

    private void initView() {
        homeocontroller1 = (JCVideoPlayer) findViewById(R.id.homeocontroller1);
        final String livehome = getIntent().getStringExtra("livehome");
        final String livetitle = getIntent().getStringExtra("livetitle");
        final String img = getIntent().getStringExtra("liveimm");
        final String str="http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+livehome+"&amp;client=androidapp";
        System.out.println(str+"aaasss");
        OkHttpUtils.getInstance().getNetData(str, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Livehome live = new Gson().fromJson(ss, Livehome.class);
                final String s=live.getHls_url().getHls1();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeocontroller1.setUp(s,livetitle);
                    }
                });
            }
        });
        final ImageView imm = (ImageView) findViewById(R.id.pppopop);
        imm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aa == 0) {
                    DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Homelive.this, "aa.db", null);
                    DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
                    DaoSession daoSession = daoMaster.newSession();
                    studentsDao = daoSession.getStudentsDao();
                    studentsDao.queryBuilder().build().list();
                    studentsDao.insert(new Students(null, 0, livetitle, img));
                    Toast.makeText(Homelive.this, "已收藏，请到【我的收藏】中查看", Toast.LENGTH_SHORT).show();

                    imm.setImageResource(R.drawable.collect_yes);
                    aa = 1;
                }else {
                    /*Students stu1 = studentsDao.queryBuilder().where(StudentsDao.Properties.Title.eq(homeTitile)).build().unique();//查询单
                    if (stu1 != null) {
                        studentsDao.delete(stu1);
                    }*/
                    imm.setImageResource(R.drawable.collect_no);
                    Toast.makeText(Homelive.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
