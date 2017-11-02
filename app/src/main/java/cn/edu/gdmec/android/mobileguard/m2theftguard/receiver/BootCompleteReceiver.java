package cn.edu.gdmec.android.mobileguard.m2theftguard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.edu.gdmec.android.mobileguard.App;

/**
<<<<<<< HEAD
=======
<<<<<<< HEAD
 * Created by killer on 2017/10/19.
 */

public class BootCompleteReceiver extends BroadcastReceiver {
=======
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
 * Created by lt on 2017/10/19.
 */

public class BootCompleteReceiver extends BroadcastReceiver{

<<<<<<< HEAD
=======
>>>>>>> origin/master
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
    @Override
    public void onReceive(Context context, Intent intent) {
        ((App)(context.getApplicationContext())).correctSIM();
    }
}
