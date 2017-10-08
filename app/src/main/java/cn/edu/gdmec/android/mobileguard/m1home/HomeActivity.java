package cn.edu.gdmec.android.mobileguard.m1home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import cn.edu.gdmec.android.mobileguard.R;

import cn.edu.gdmec.android.mobileguard.m1home.adapter.HomeAdapter;
import cn.edu.gdmec.android.mobileguard.m2theftguard.dialog.SetupPasswordDialog;
import cn.edu.gdmec.android.mobileguard.m2theftguard.utils.MD5Utils;


public class HomeActivity extends AppCompatActivity {
    private GridView gv_home;
    private long mExitTime;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        mSharedPreferences = getSharedPreferences("config",MODE_APPEND);
        gv_home = (GridView) findViewById(R.id.gv_home);
        gv_home.setAdapter(new HomeAdapter(HomeActivity.this));
        gv_home.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        if(isSetupPassword()){
                            //打开设置密码对话框
                            showInterPswdDialog();
                        }else {
                            //打开输入密码对话框
                            showSetupPswdDialog();
                        }
                        break;
                }
            }
        });
    }

    public void startActivity(Class<?> cls){
        Intent intent = new Intent(HomeActivity.this,cls);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if ((System.currentTimeMillis()-mExitTime)<2000){
                System.exit(0);
            }else{
                Toast.makeText(this,"",Toast.LENGTH_LONG).show();
                mExitTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //判断用户是否设置过手机防盗密码
    private boolean isSetupPassword(){
        String password = mSharedPreferences.getString("PhoneAntiThreftPWD",null);
        if(TextUtils.isEmpty(password)){
            return false;
        }else {
            return true;
        }
    }

    private void showSetupPswdDialog(){
        final SetupPasswordDialog setupPasswordDialog = new SetupPasswordDialog(HomeActivity.this);
        setupPasswordDialog.setCallBack(new SetupPasswordDialog.MyCallBack(){
            @Override
            public void ok() {
                String firstPwsd = setupPasswordDialog.mFirstPWDET.getText().toString().trim();
                String affirmPwsd = setupPasswordDialog.mAffirmET.getText().toString().trim();
                if(!TextUtils.isEmpty(firstPwsd) && !TextUtils.isEmpty(affirmPwsd)){
                    if (firstPwsd.equals(affirmPwsd)){
                        //两次密码一致，储存密码
                        savePswd(affirmPwsd);
                        setupPasswordDialog.dismiss();
                        //显示输入密码对话框
                        showInterPswdDialog();
                    }else {
                        Toast.makeText(HomeActivity.this,"两次密码不一致！", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(HomeActivity.this,"密码不能为空！", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void cancel() {
                setupPasswordDialog.dismiss();
            }
        });
        setupPasswordDialog.setCancelable(true);
        setupPasswordDialog.show();
    }

    /*
        弹出输入密码对话框，本方法需要完成“手机防盗模块”之后才能启用
    */
    private void showInterPswdDialog(){
        final String password = getPassword();
    }

    /*
    保存密码，本方法需要完成“手机防盗模块”之后才能启用
    */
    private void savePswd(String affirmPwsd){
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        //为防止用户隐私被泄露，因此需要加密密码
        edit.putString("PhoneAntiTheftPWD", MD5Utils.encode(affirmPwsd));
        edit.commit();
    }

    /*
    获取密码
    */
    private String getPassword(){
        String password = mSharedPreferences.getString("PhoneAntiTheftPWD",null);
        if(TextUtils.isEmpty(password)){
            return "";
        }
        return password;
    }
}
