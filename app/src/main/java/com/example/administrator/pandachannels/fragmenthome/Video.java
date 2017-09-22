package com.example.administrator.pandachannels.fragmenthome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
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


public class Video extends AppCompatActivity {

    private HomeShiping homeShiping;
    private JCVideoPlayer jcvideoplayer;
    private ImageView homeshou;
    private StudentsDao studentsDao;
    int aa = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video);
        initView();

    }
    private void initView() {
        jcvideoplayer = (JCVideoPlayer) findViewById(R.id.homeshi_vide);
        String homelunbo = getIntent().getStringExtra("homeflunbo");
        final String homeTitile = getIntent().getStringExtra("homeTitile");
        final String homimg = getIntent().getStringExtra("homimg");

        OkHttpUtils.getInstance().getNetData(Urls.VIDEOPLAY + homelunbo, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                homeShiping = new Gson().fromJson(ss, HomeShiping.class);
                final String str = homeShiping.getVideo().getChapters().get(0).getUrl();
                System.out.println(str+"aaa");
                Log.e("AAAAA",str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        jcvideoplayer.setUp(str,homeTitile);
                    }
                });

            }
        });
        homeshou = (ImageView) findViewById(R.id.homeshou);
        homeshou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (aa == 0) {
                    DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Video.this, "aa.db", null);
                    DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
                    DaoSession daoSession = daoMaster.newSession();
                    studentsDao = daoSession.getStudentsDao();
                    studentsDao.queryBuilder().build().list();
                    studentsDao.insert(new Students(null, 0, homeTitile, homimg));
                    Toast.makeText(Video.this, "已收藏，请到【我的收藏】中查看", Toast.LENGTH_SHORT).show();

                    homeshou.setImageResource(R.drawable.collect_yes);
                    aa = 1;
                }else {

                    homeshou.setImageResource(R.drawable.collect_no);
                    Toast.makeText(Video.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
        
    }
}
