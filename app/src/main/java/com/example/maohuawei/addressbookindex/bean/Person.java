

import com.example.maohuawei.addressbookindex.util.PinyinUtil;

/**
 * Created by maohuawei on 2018/2/5.
 */

public class Person {
    private String name;
    private String tel;
    private String image;
    private String pinyin;


    public Person(String name, String image, String tel) {
        this.name = name;
        this.tel = tel;
        this.image = image;
        pinyin = PinyinUtil.hanZi2Pinyin(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
