package com.example.juan.moochcitest2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.juan.moochcitest2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout addressBtn;
    private LinearLayout sexBtn;
    private LinearLayout birthBtn;
    private String[] addressItems = {"湖南","新疆","山东","湖北"};
    private String[] sexItems = {"男","女"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        setContentView(R.layout.activity_main);

        addressBtn = (LinearLayout) findViewById(R.id.user_address_input);
        sexBtn  = (LinearLayout)findViewById(R.id.user_sex_input);
        birthBtn = (LinearLayout)findViewById(R.id.user_birth_input);
        initListener();

    }
    private void initListener(){
        addressBtn.setOnClickListener(this);
        sexBtn.setOnClickListener(this);
        birthBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_address_input:
                showAddressDialog();
                break;
            case  R.id.user_sex_input:
                showSexDialog();
                break;
            case R.id.user_birth_input:
                showBirthDialog();
        }
    }
    private void showAddressDialog() {

        AddressPickerDialog builder = new AddressPickerDialog(MainActivity.this,null, new AddressPickerDialog.OnMyDialogListener(){
            public void back(Class myClass) {

            }
        });
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.show();
    }

    private void showSexDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(sexItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, sexItems + "", Toast.LENGTH_SHORT);
            }
        });

        AlertDialog mDialog = builder.create();
        mDialog.show();
        Window window = mDialog.getWindow();
        window.setGravity(Gravity.CENTER_VERTICAL);
//        window.setWindowAnimations(R.style.popupAnimation);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.setCancelable(true);


    }

    private void showBirthDialog() {

        BirthpickerDialog builder = new BirthpickerDialog(MainActivity.this, new BirthpickerDialog.OnMyDialogListener(){
            public void back(Class myClass) {

            }
        });
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.show();
    }

}

