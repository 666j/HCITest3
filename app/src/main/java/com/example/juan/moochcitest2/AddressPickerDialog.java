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

public class AddressPickerDialog extends Dialog {
    //定义回调事件
    public interface  OnMyDialogListener{
        public void back(Class diaClass);
    }
    //日期选择
    private DatePicker select_birth;
    private TextView title;
    private Button confirm_btn;
    private Button cancel_btn;
    private ListView address_list;
    //dialog的名字
    private  String dialogname;
    //回调的listener
    private  OnMyDialogListener onMyDialogListener;
    private String[] data ={"湖南省","山东省","河南省","湖北省","山西省","陕西省","广东省","河北省","吉林省","黑龙江省","甘肃省"};
    //自定义的dialog的构造方法
    public AddressPickerDialog(Context context, String name, OnMyDialogListener onMyDialogListener) {
        super(context);
        this.dialogname=name;
        this.onMyDialogListener=onMyDialogListener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_select);
        setTitle(dialogname);
        initViews();
        initListener();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView)findViewById(R.id.address_list);
        listView.setAdapter(adapter);
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_VERTICAL);


    }
    private void initListener() {
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressPickerDialog.this.dismiss();
                Log.d("回调back","MYDialog（）");
            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressPickerDialog.this.dismiss();
            }
        });
    }
    private void initViews() {

        title= (TextView) findViewById(R.id.adress_title);
        address_list= (ListView) findViewById(R.id.address_list);
        cancel_btn= (Button) findViewById(R.id.cancel);
        confirm_btn= (Button) findViewById(R.id.confirm);
    }
}