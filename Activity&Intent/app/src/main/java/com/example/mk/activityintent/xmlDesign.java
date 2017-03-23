package com.example.mk.activityintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class xmlDesign extends AppCompatActivity {

    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup radioGroup = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        r1 = (RadioButton) findViewById(R.id.a);
        r2 = (RadioButton) findViewById(R.id.b);
        r3 = (RadioButton) findViewById(R.id.c);
        r4 = (RadioButton) findViewById(R.id.d);
        r1.setClickable(true);

        Button btn1_sure = (Button) findViewById(R.id.sure);
        Button btn2_cancel = (Button) findViewById(R.id.cancel);
        btn1_sure.setOnClickListener(new btn1_sure());
        btn2_cancel.setOnClickListener(new btn2_cancel());
    }

    class btn1_sure implements OnClickListener { //按钮事件监听器类，实现OnClickListener接口
        @Override
        public void onClick(View v) {//实现OnClickListener接口中的onClick方法
            String ans = "";
            if (r1.isChecked()) {
                ans = "A";
            } else if (r2.isChecked()) {
                ans = "B";
            } else if (r3.isChecked()) {
                ans = "C";
            } else if (r4.isChecked()) {
                ans = "D";
            }
            Intent intent = new Intent();
            intent.setClass (xmlDesign.this, otherActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("ans", ans);
            intent.putExtras(bundle);
            startActivityForResult(intent, 0);
        }
    }
    class btn2_cancel implements OnClickListener {
        /*
        (API中查找，android.widget public class RadioGroup
        void clearCheck()
        Clears the selection.
         */
        @Override
        public void onClick(View v) {
            radioGroup.clearCheck();
            setTitle("");
        }

    }


    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//当requestCode、resultCode同时为0，也就是处理特定的结果
        if (requestCode == 0
                && resultCode == 0) {


/* 取得来自Activity2 的数据，并显示于画面上 */
            Bundle bunde = data.getExtras();
            String ans = bunde.getString("ans");





        }
    }
}

