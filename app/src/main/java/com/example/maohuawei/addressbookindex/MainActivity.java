package com.example.maohuawei.addressbookindex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.addressbookviewlibrary.Person;
import com.example.maohuawei.addressbookindex.adapter.AddressBookAdapter;
import com.example.maohuawei.addressbookindex.util.ToastUtil;
import com.example.maohuawei.addressbookindex.view.IndexView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private IndexView indexView;
    private RecyclerView recyclerView;

    private List<Person> personList;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        initData();


    }

    @Override
    protected void onResume() {
        super.onResume();


        linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        AddressBookAdapter addressBookAdapter = new AddressBookAdapter(MainActivity.this, personList);

        recyclerView.setAdapter(addressBookAdapter);
        indexView.setIndexViewLetterChangeListener(new IndexView.IndexViewLetterChangeListener() {
            @Override
            public void onIndexLetterChange(String letter) {

                ToastUtil.showToast(letter);

                updateRecyclerView(letter);

            }
        });


    }

    private void updateRecyclerView(String letter) {


        for (int i = 0; i < personList.size(); i++) {
            String let = personList.get(i).getPinyin().substring(0, 1);

            if (let.equals("#")) {
                MoveToPosition(linearLayoutManager, 0);
            }

            if (let.equals(letter)) {
                MoveToPosition(linearLayoutManager, i);

                return;
            }

        }


    }

    /**
     * 设置RecyclerView 到指定位置
     *
     * @param manager
     * @param n
     */
    public static void MoveToPosition(LinearLayoutManager manager, int n) {
        manager.scrollToPositionWithOffset(n, 0);
        manager.setStackFromEnd(true);
    }

    private void initData() {

        personList = new ArrayList<>();


        personList.add(new Person("女娲", "http://img.18183.com/uploads/allimg/171114/36-1G114151F1.jpg", "18935398186"));
        personList.add(new Person("铠", "http://img.18183.com/uploads/allimg/170717/70-1FGGA951.jpg", "18935398186"));
        personList.add(new Person("程咬金", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/15.png", "18935398186"));
        personList.add(new Person("明世隐", "http://img.18183.com/uploads/allimg/171117/36-1G11G50U9.jpg", "18935398186"));
        personList.add(new Person("马可波罗", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/56.png", "18935398186"));
        personList.add(new Person("妲己", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/9.png", "18935398186"));
        personList.add(new Person("高渐离", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/1.png", "18935398186"));
        personList.add(new Person("扁鹊", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/12.png", "18935398186"));
        personList.add(new Person("哪吒", "http://img.18183.com/uploads/allimg/170112/70-1F112154602.jpg", "18935398186"));
        personList.add(new Person("成吉思汗", "http://img.18183.duoku.com/uploads/160602/36-1606021K55X42.jpg", "18935398186"));
        personList.add(new Person("成吉思汗", "http://img.18183.duoku.com/uploads/160602/36-1606021K55X42.jpg", "18935398186"));

        personList.add(new Person("蔡文姬", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/53.png", "18935398186"));

        personList.add(new Person("阿轲", "http://img.18183.duoku.com/uploads/allimg/161124/36-1611241H642.jpg", "18935398186"));

        personList.add(new Person("张飞", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/47.png", "18935398186"));

        personList.add(new Person(" 杨玉环", "http://img.18183.com/uploads/allimg/180106/194-1P106153531.jpg", "18935398186"));

        personList.add(new Person("亚瑟", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/7.png", "18935398186"));

        personList.add(new Person("娜可露露", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/39.png", "18935398186"));

        personList.add(new Person("安琪拉", "http://img.bugu.18183.com/db_18183/static/wzry/static/images/heros/icon/11.png", "18935398186"));


        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getPinyin().compareTo(o2.getPinyin());
            }
        });

    }

    private void initView() {
        indexView = findViewById(R.id.indexView);
        recyclerView = findViewById(R.id.recyclerView);
    }
}
