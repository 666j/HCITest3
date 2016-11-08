package com.example.juan.moochcitest2;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Juan on 2016/10/16.
 */

public class BirthpickerDialog extends Dialog {
    //定义回调事件
    public interface  OnMyDialogListener{
        public void back(Class diaClass);
    }
    //日期选择
    private DatePicker select_birth;
    private TextView title;
    private Button confirm_btn;
    private Button cancel_btn;

    //dialog的名字
    private  String dialogname;
    //回调的listener
    private  OnMyDialogListener onMyDialogListener;

    //自定义的dialog的构造方法
    public BirthpickerDialog(Context context, OnMyDialogListener onMyDialogListener) {
        super(context);

        this.onMyDialogListener=onMyDialogListener;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brith_select);
        setTitle(dialogname);
        initViews();
        initListener();

        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_VERTICAL);


    }
    private void initListener() {
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BirthpickerDialog.this.dismiss();
                Log.d("回调back","MYDialog（）");
            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BirthpickerDialog.this.dismiss();
            }
        });
    }
    private void initViews() {

        title= (TextView) findViewById(R.id.adress_title);
        select_birth = (DatePicker) findViewById(R.id.select_birth);
        cancel_btn= (Button) findViewById(R.id.cancel);
        confirm_btn= (Button) findViewById(R.id.confirm);
    }
}