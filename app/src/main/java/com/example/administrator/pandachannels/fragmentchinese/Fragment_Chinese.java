package com.example.administrator.pandachannels.fragmentchinese;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.MountTai_fragment;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter.MyGridAdapter1;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter.MyGridAdapter2;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.presenter.Fragment_ChineseimplMain;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.example.greendao1.DaoMaster;
import com.example.greendao1.DaoSession;
import com.example.greendao1.StudentsDao;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

//实现V层接口
public class Fragment_Chinese extends BaseFragment implements MainContract.SubView, View.OnClickListener {
    //  http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json
    //30个已经有数据了
    ArrayList<BeanChinese.AlllistBean> list111 = new ArrayList<>();
    //5个已经有数据了
    ArrayList<BeanChinese.TablistBean> list222 = new ArrayList<>();
    ArrayList<String> titlelist = new ArrayList<>();//title集合
    ArrayList<Fragment> framlist = new ArrayList<>();//fragment集合
    //1.GridView1数据库存储
//2.GridView2 数据库
    ArrayList<Students> listgv2 = new ArrayList<>();
    ArrayList<Students> listgv1 = new ArrayList<>();
    ArrayList<String> urllist = new ArrayList<>();

    private ImageView img_persion;
    private ImageView img_add;
    private TabLayout tablayout_chinese;
    private ViewPager viewpager_chinese;
    int aa = 0;

    private Button pop_button;
    private RecyclerView pop_recy1;
    private RecyclerView pop_recy2;
    private ImageView pop_img1;
    private StudentsDao studentsDao;
    private GridView pop_gv1;
    private GridView pop_gv2;
    private MyGridAdapter1 gvadapter1;
    private Myadap myadap;
    private MyGridAdapter2 gvadapter2;
    private StudentsDao studentsDao2;
    private String s = "qq";


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
        //V层和P层关联
        Fragment_ChineseimplMain main = new Fragment_ChineseimplMain(this);
        main.requsetData();

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
        OkHttpUtils.getInstance().getNetData("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json", new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson = new Gson();
                BeanChinese beanChinese = gson.fromJson(ss, BeanChinese.class);
                List<BeanChinese.AlllistBean> alllist = beanChinese.getAlllist();
                List<BeanChinese.TablistBean> tablist = beanChinese.getTablist();

                list111.addAll(alllist);
                list222.addAll(tablist);
                //创建第一个数据库
                DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "students12.db", null);

                DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());

                DaoSession daoSession = daoMaster.newSession();

                studentsDao = daoSession.getStudentsDao();
                //查询所有 ，如果里边没有数据就添加
                //插入30个Studnet !!!
                List<Students> lists = studentsDao.queryBuilder().build().list();
                if (lists.size() == 0) {
                    for (int i = 0; i < list111.size(); i++) {
                        studentsDao.insert(new Students(null, 100 + i, list111.get(i).getTitle(), list111.get(i).getUrl()));

                    }
                }
// 查询第一个数据库所有数据库内容添加到Tablayout 和ViewPager ，Fragment联动
                List<Students> lists1 = studentsDao.queryBuilder().build().list();
                for (int i = 0; i < lists1.size(); i++) {
                    String title = lists1.get(i).getTitle();
                    String url = lists1.get(i).getUrl();
                    titlelist.add(title);
                    urllist.add(url);
                    tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(i)));
                    framlist.add(new MountTai_fragment(urllist.get(i)));//传递了一个参数url
                }
                myadap = new Myadap(getFragmentManager());
                tablayout_chinese.setupWithViewPager(viewpager_chinese);
                viewpager_chinese.setAdapter(myadap);

            }
        });

        //创建第二个数据库
        DaoMaster.DevOpenHelper devOpenHelper2 = new DaoMaster.DevOpenHelper(getActivity(), "shujuku2.db", null);

        DaoMaster daoMaster2 = new DaoMaster(devOpenHelper2.getReadableDb());

        DaoSession daoSession2 = daoMaster2.newSession();

        studentsDao2 = daoSession2.getStudentsDao();

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


        //PopupWindow ：显示位置更加灵活 。先定义pop.item
        View view = View.inflate(getActivity(), R.layout.popadd_chinese, null);
        pop_button = (Button) view.findViewById(R.id.pop_button);
        pop_img1 = (ImageView) view.findViewById(R.id.pop_img1);
        pop_gv1 = view.findViewById(R.id.pop_gv1);
        pop_gv2 = view.findViewById(R.id.pop_gv2);

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
                s = pop_button.getText().toString();
                if (s.equals("编辑")) {
                    pop_button.setText("完成");
                }
                if (s.equals("完成")) {
                    pop.dismiss();
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

        //查询数据库内容添加到第一个GridView 里，点击x号关闭PopWindow同时更新viewPager 和Fragment
        final List<Students> lists11 = studentsDao.queryBuilder().build().list();
        listgv1.clear();
        listgv1.addAll(lists11);
        // ==================第一个GridView的设置及监听=====================
        gvadapter1 = new MyGridAdapter1(getActivity(), listgv1, s);
        pop_gv1.setAdapter(gvadapter1);
        pop_gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (s.equals("编辑")) {
                    //点击查询所有数据库1内容
                    List<Students> lists112 = studentsDao.queryBuilder().build().list();
                    if (lists112.size() > 4) {
                        //TODO 先添加到grildView2 集合，再删除
                        String title11 = listgv1.get(i).getTitle();
                        String url11 = listgv1.get(i).getUrl();
                        Log.e("wwwwwww", "wwwwwwwwwww" + title11);

                        //查询数据库有没有这条数据，如果有就在数据库1里删除
                        Students stu1 = studentsDao.queryBuilder().where(StudentsDao.Properties.Title.eq(title11)).build().unique();//查询单
                        //数据库删除一个Studnets以后，30个那个tablayout那个集合 和framlist，titlelist都要及时删除
                        if (stu1 != null) {
                            //TODO 这里了插入到数据库2。查询数据库2，刷新
                            studentsDao2.insert(listgv1.get(i));
                            listgv2.clear();
                            List<Students> list2221 = studentsDao2.queryBuilder().build().list();
                            listgv2.addAll(list2221);


                            studentsDao.delete(stu1);
                            listgv1.remove(i);
                            gvadapter1.notifyDataSetChanged();
                        }

                        list111.remove(i);
                        framlist.remove(i);
                        titlelist.remove(i);
                        myadap.notifyDataSetChanged();
                        gvadapter2.notifyDataSetChanged();

                    } else {
                        Toast.makeText(getActivity(), "不能少于4个标签", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //========点击第二个GridView条目删除，同时添加到第一个GridView。==============
        //TODO 查询数据库2内容
        List<Students> li01 = studentsDao2.queryBuilder().build().list();
        listgv2.clear();
        listgv2.addAll(li01);
        gvadapter2 = new MyGridAdapter2(getActivity(), listgv2);
        pop_gv2.setAdapter(gvadapter2);

        pop_gv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (s.equals("编辑")) {
                    //TODO 点击gv2 时也是删除该条目，  添加到gv1.的数据库并刷新gv1的列表
                    //查询数据库2有没有这条数据，如果有就在数据库2里删除,在数据库1里添加，并刷新
                    Students stu1 = studentsDao2.queryBuilder().where(StudentsDao.Properties.Title.eq(listgv2.get(i).getTitle())).build().unique();//查询单
                    //数据库删除一个Studnets以后
                    if (stu1 != null) {
                        //TODO 这里了插入到数据库1。查询数据库1，刷新
                        studentsDao.insert(stu1);
                        List<Students> list2221 = studentsDao.queryBuilder().build().list();
                        listgv1.clear();

                        listgv1.addAll(list2221);
                        gvadapter1.notifyDataSetChanged();
                        //TODO 更新Tablayout
                        framlist.add(new MountTai_fragment(listgv2.get(i).getUrl()));
                        titlelist.add(listgv2.get(i).getTitle());
                        myadap.notifyDataSetChanged();
                        //TODO=============删除数据库2的内容，刷新========
                        studentsDao2.delete(stu1);
                        listgv2.remove(stu1);
                        gvadapter2.notifyDataSetChanged();


                    }
                }


            }
        });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dissmissLoading() {

    }

    @Override
    public void showData(ArrayList<BeanTaishan.LiveBean> list) {


    }

    @Override
    public void showrror() {

    }


    @Override
    public void showDataChina(ArrayList<BeanChinese> list111) {


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
