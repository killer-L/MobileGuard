package cn.edu.gdmec.android.mobileguard.m2theftguard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.edu.gdmec.android.mobileguard.R;

/**
<<<<<<< HEAD
 * Created by killer on 2017/10/9.
=======
 * Created by LT on 2017/9/26.
>>>>>>> origin/master
 */

public class InterPasswordDialog extends Dialog implements View.OnClickListener {
    private TextView mTitleTV;
    private EditText mInterET;
    private Button mOKBtn;
<<<<<<< HEAD
    private Button mCancleBtn;
    private MyCallBack myCallBack;
    private Context context;
    public InterPasswordDialog(@NonNull Context context){
        super(context,R.style.dialog_custom);
        this.context = context;
    }
=======
    private Button mCancelBtn;
    private MyCallBack myCallBack;
    private Context context;

>>>>>>> origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.inter_password_dialog);
        super.onCreate(savedInstanceState);
        initView();
    }

<<<<<<< HEAD
    private void initView(){
        mTitleTV = (TextView) findViewById(R.id.tv_interpwd_title);
        mInterET = (EditText) findViewById(R.id.et_inter_password);
        mOKBtn = (Button) findViewById(R.id.btn_comfirm);
        mCancleBtn = (Button) findViewById(R.id.btn_dismiss);
        mOKBtn.setOnClickListener(this);
        mCancleBtn.setOnClickListener(this);
    }

    public void setTitle(String title){
        if (!TextUtils.isEmpty(title)){
            mTitleTV.setText(title);
        }
    }


=======
    public InterPasswordDialog(@NonNull Context context) {
        super(context,R.style.dialog_custom);
        this.context = context;
    }

>>>>>>> origin/master
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_comfirm:
                myCallBack.confirm();
                break;
            case R.id.btn_dismiss:
<<<<<<< HEAD
                myCallBack.cancle();
=======
                myCallBack.cancel();
>>>>>>> origin/master
                break;
        }
    }
    public String getPassword(){
        return mInterET.getText().toString();
    }

    public void setCallBack(MyCallBack myCallBack){
        this.myCallBack = myCallBack;
    }

<<<<<<< HEAD




    public interface MyCallBack{
        void confirm();
        void cancle();
=======
    private void initView(){
        mTitleTV = (TextView) findViewById(R.id.tv_interpwd_title);
        mInterET = (EditText) findViewById(R.id.et_inter_password);
        mOKBtn = (Button) findViewById(R.id.btn_comfirm);
        mCancelBtn = (Button) findViewById(R.id.btn_dismiss);
        mOKBtn.setOnClickListener(this);
        mCancelBtn.setOnClickListener(this);
    }

    public void setTitle(String title){
        if (!TextUtils.isEmpty(title)){
            mTitleTV.setText(title);
        }
    }

    public interface MyCallBack{
        void confirm();
        void cancel();
>>>>>>> origin/master
    }

}
