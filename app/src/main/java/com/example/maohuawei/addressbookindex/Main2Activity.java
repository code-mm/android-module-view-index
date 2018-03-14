package com.example.maohuawei.addressbookindex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.maohuawei.addressbookindex.bean.Person;
import com.example.maohuawei.addressbookindex.view.AddressBookView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private AddressBookView addressBookView;

    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addressBookView = findViewById(R.id.addressBookView);
        initData();

        addressBookView.setpersonList(personList);
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
}
