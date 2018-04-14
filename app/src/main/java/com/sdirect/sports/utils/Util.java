package com.sdirect.sports.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Util {

    private Context mContext;

    public Util(Context mContext) {
        this.mContext = mContext;
    }

    public void toastMsg(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }

    public void dismissKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus())
            imm.hideSoftInputFromWindow(activity.getCurrentFocus()
                    .getApplicationWindowToken(), 0);
    }

}
