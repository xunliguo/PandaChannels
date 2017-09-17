package com.example.administrator.pandachannels.fragmentchinese;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.Funghwang_fragment;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.MountEmei_fragment;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.MountHang_fragment;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.MountTai_fragment;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter.PopRecyAdapter1;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.data.ArrayListData1;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Chinese extends BaseFragment implements View.OnClickListener {

    //  http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json
    private ImageView img_persion;
    private ImageView img_add;
    private TabLayout tablayout_chinese;
    private ViewPager viewpager_chinese;

    ArrayList<String> titlelist = new ArrayList<>();
    ArrayList<Fragment> framlist = new ArrayList<>();
    private Button pop_button;
    private RecyclerView pop_recy1;
    private RecyclerView pop_recy2;
    private ImageView pop_img1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment like bottom ... and run LayoutCreator again
        View view = View.inflate(getActivity(), R.layout.fragment_fragment__chinese, null);
        initView(view);
        initData();
        return view;
    }

    @Override
    protected void initView(View view) {
        img_add = (ImageView) view.findViewById(R.id.img_add);
        img_add.setOnClickListener(this);
        tablayout_chinese = (TabLayout) view.findViewById(R.id.tablayout_chinese);
        viewpager_chinese = (ViewPager) view.findViewById(R.id.viewpager_chinese);


    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment__chinese;
    }

    @Override
    protected void initData() {
        titlelist.add("泰山");
        titlelist.add("黄山");
        titlelist.add("凤凰古城");
        titlelist.add("峨眉山");
//titlelist.add("张家界");
//titlelist.add("黄果树");
//titlelist.add("天涯海角");
//titlelist.add("中央电视塔");
        tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(0)));
        tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(1)));
        tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(2)));
        tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(3)));
        framlist.add(new MountTai_fragment());
        framlist.add(new MountHang_fragment());
        framlist.add(new Funghwang_fragment());
        framlist.add(new MountEmei_fragment());

        Myadap myadap = new Myadap(getFragmentManager());
        tablayout_chinese.setupWithViewPager(viewpager_chinese);
        viewpager_chinese.setAdapter(myadap);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_add:

                showPopwindow();
                break;

            case R.id.pop_button:
                break;
        }
    }

  //PopWindow的   设置
    private void showPopwindow() {
        //获取网络数据
        OkHttpUtils.getInstance().getNetData("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json", new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                BeanChinese beanChinese = gson.fromJson(ss, BeanChinese.class);
                //30个Tablist
                List<BeanChinese.AlllistBean> alllist = beanChinese.getAlllist();
                //5个默认的
                List<BeanChinese.TablistBean> tablist = beanChinese.getTablist();

            }
        });






        //PopupWindow ：显示位置更加灵活 。先定义pop.item
        View view = View.inflate(getActivity(), R.layout.popadd_chinese, null);
        pop_button = (Button) view.findViewById(R.id.pop_button);
        pop_img1 = (ImageView) view.findViewById(R.id.pop_img1);
        pop_button.setOnClickListener(this);
        pop_recy1 = (RecyclerView) view.findViewById(R.id.pop_recy1);
        pop_recy1.setOnClickListener(this);
        pop_recy2 = (RecyclerView) view.findViewById(R.id.pop_recy2);
        pop_recy2.setOnClickListener(this);

        //创建pop 必须传递三个参数  当前可以是500  260
        final PopupWindow pop = new PopupWindow(view, DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
        pop.setFocusable(true);
        pop.setBackgroundDrawable(new ColorDrawable(1));
        pop.setOutsideTouchable(true);
        //获取屏幕的宽高
        WindowManager wm = getActivity().getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        //设置显示位置
        // pop.showAsDropDown(shouye_img3);
        pop.showAtLocation(view, 0, width, -height);


        pop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = pop_button.getText().toString();
                if (s.equals("编辑")) {
                    pop_button.setText("完成");
                }
                if (s.equals("完成")) {
                    pop_button.setText("编辑");
                }

            }
        });
        pop_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });

        final ArrayList<String> list1tab = ArrayListData1.getlist();
        PopRecyAdapter1 ada1Adapter = new PopRecyAdapter1(getActivity(), list1tab);
        pop_recy1.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        pop_recy1.setAdapter(ada1Adapter);
        ada1Adapter.setonitenclicklistener(new PopRecyAdapter1.Listener() {
            @Override
            public void setonduanclick(View v, int postion) {
                list1tab.get(postion);
                Toast.makeText(getActivity(), list1tab.get(postion), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setonlongclick(View v, int postion) {

            }
        });

    }


    private class Myadap extends FragmentPagerAdapter {
        public Myadap(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return framlist.get(position);
        }

        @Override
        public int getCount() {
            return framlist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);
        }
    }
}
