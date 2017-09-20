package com.example.administrator.pandachannels.fragmentobserve.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentobserve.entity.WenBean;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.id;

public class ItemActivity extends AppCompatActivity implements View.OnClickListener,UMShareListener {


    private ImageView item_back;
    private TextView item_name;
    private TextView item_from;
    private TextView item_time;
    private TextView item_info;
    private ImageView item_shou;
    private ImageView item_fen;
    public String htmlid;
    private Handler handler;
    int a=0;
    private String title;
    private String content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Intent intent = getIntent();
        htmlid = intent.getStringExtra("id");
        Log.e("id", "======>" + id);
        initView();
        showWen();
    }

    protected void initView() {
        item_back = (ImageView) findViewById(R.id.item_back);
        item_fen = (ImageView) findViewById(R.id.item_fen);
        item_shou = (ImageView) findViewById(R.id.item_shou);
        item_name = (TextView) findViewById(R.id.item_name);
        item_info = (TextView) findViewById(R.id.item_info);
        item_time = (TextView) findViewById(R.id.item_time);
        item_from = (TextView) findViewById(R.id.item_from);
        item_back.setOnClickListener(this);
        item_shou.setOnClickListener(this);
        item_fen.setOnClickListener(this);

    }


    public void showWen() {

        OkHttpUtils.getInstance().getNetData("http://api.cntv.cn/article/contentinfo?id=" + htmlid + "&serviceId=panda", new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Log.e("TAGssss", "===========>" + ss);
                Gson gson = new Gson();
                WenBean wenBean = gson.fromJson(ss, WenBean.class);
                title = wenBean.getTitle();
                String source = wenBean.getSource();
                String pubtime = wenBean.getPubtime();
                content = wenBean.getContent();
                item_name.setText(title);
                item_time.setText(pubtime);
                item_from.setText(source);


                item_info.setMovementMethod(ScrollingMovementMethod.getInstance());
                handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 0 * 101) {
                            item_info.setText((CharSequence) msg.obj);
                        }
                    }
                };
                Thread thread = new Thread(new Runnable() {
                    Message msg = Message.obtain();

                    @Override
                    public void run() {
                        Html.ImageGetter imageGetter = new Html.ImageGetter() {
                            @Override
                            public Drawable getDrawable(String s) {
                                URL url;
                                Drawable drawable = null;
                                try {
                                    url = new URL(s);
                                    drawable = Drawable.createFromStream(url.openStream(), null);
                                    drawable.setBounds(20, 0, 900, 600);

                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return drawable;
                            }
                        };
                        CharSequence test = Html.fromHtml(content, imageGetter, null);
                        msg.what = 0 * 101;
                        msg.obj = test;
                        handler.sendMessage(msg);
                    }
                });
                thread.start();

            }
        });
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.item_back:
                finish();
                break;
            case R.id.item_shou:
                if (a == 0) {
                    item_shou.setImageResource(R.drawable.collect_yes);
                    a = 1;
                    Toast.makeText(this, "已收藏，请到[我的收藏]去查看", Toast.LENGTH_SHORT).show();
                } else {
                    item_shou.setImageResource(R.drawable.collect_no);
                    a = 0;
                    Toast.makeText(this, "已取消收藏", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.item_fen:
                share();
                break;
        }
    }

    private void share() {
        UMImage thumb =  new UMImage(this, R.mipmap.ic_launcher
        );
        UMWeb web = new UMWeb("http://mobile.umeng.com/social");
        web.setTitle(title);//标题
        web.setThumb(thumb);  //缩略图
        web.setDescription(content);//描述                             `
        new ShareAction(ItemActivity.this)
                .withMedia(web).setPlatform(SHARE_MEDIA.QQ)
                .setCallback(shareListener)
                .share();
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {

    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ItemActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ItemActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ItemActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
