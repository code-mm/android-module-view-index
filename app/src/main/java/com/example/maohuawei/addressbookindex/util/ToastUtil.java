package com.example.maohuawei.addressbookindex.util;

import android.widget.Toast;

import com.example.maohuawei.addressbookindex.app.App;

public class ToastUtil {

    private static Toast toast;


    public static void showToast(String text) {

        if (toast == null) {

            toast = Toast.makeText(App.getContex(), "", Toast.LENGTH_LONG);

        }
        toast.setText(text);
        toast.show();

    }

}
