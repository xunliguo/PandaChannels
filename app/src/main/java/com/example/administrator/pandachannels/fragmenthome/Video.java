package com.example.administrator.pandachannels.fragmenthome;

//import io.vov.vitamio.Vitamio;
//import io.vov.vitamio.MediaPlayer;
//import io.vov.vitamio.widget.MediaController;
//import io.vov.vitamio.widget.VideoView;
//
//
//public class Video extends AppCompatActivity {
//
//    private VideoView video;
//    private HomeShiping homeShiping;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Vitamio.isInitialized(this);
//        setContentView(R.layout.activity_video);
//
//        initView();
//    }
//    private void initView() {
//        video = (VideoView) findViewById(R.id.video);
//        String homelunbo = getIntent().getStringExtra("homelunbo");
//        OkHttpUtils.getInstance().getNetData(Url.VIDEOPLAY + homelunbo, new OkHttpUtils.CallBacks() {
//            @Override
//            public void getString(String ss) {
//                homeShiping = new Gson().fromJson(ss, HomeShiping.class);
//                final String str = homeShiping.getVideo().getChapters().get(0).getUrl();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        video.setVideoPath(str);
//                        System.out.println(str+"toto");
//                        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                            @Override
//                            public void onPrepared(MediaPlayer mp) {
//                                video.start();
//                            }
//                        });
//                        video.setMediaController(new MediaController(Video.this));
//                    }
//                });
//            }
//        });
//    }
//
//}
