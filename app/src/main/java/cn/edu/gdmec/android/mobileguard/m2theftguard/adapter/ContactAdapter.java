package cn.edu.gdmec.android.mobileguard.m2theftguard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.w3c.dom.Text;

=======
>>>>>>> origin/master
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
import java.util.List;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m2theftguard.entity.ContactInfo;

/**
<<<<<<< HEAD
=======
<<<<<<< HEAD
 * Created by killer on 2017/10/19.
 */

public class ContactAdapter extends BaseAdapter {
=======
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
 * Created by lt on 2017/10/19.
 */

public class ContactAdapter extends BaseAdapter{

<<<<<<< HEAD
=======
>>>>>>> origin/master
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
    private List<ContactInfo> contactInfos;
    private Context context;
    public ContactAdapter(List<ContactInfo> contactInfos,Context context){
        super();
<<<<<<< HEAD
=======
<<<<<<< HEAD
        this.contactInfos= contactInfos;
        this.context=context;
    }
=======
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
        this.contactInfos = contactInfos;
        this.context = context;
    }

<<<<<<< HEAD
=======
>>>>>>> origin/master
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
    @Override
    public int getCount() {
        return contactInfos.size();
    }

    @Override
    public Object getItem(int i) {
        return contactInfos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
<<<<<<< HEAD
=======
<<<<<<< HEAD
        if (view==null){
            view = View.inflate(context, R.layout.item_list_contact_select,null);
            holder = new ViewHolder();
            holder.mNameTV=(TextView) view.findViewById(R.id.tv_name);
            holder.mPhoneTV = (TextView) view.findViewById(R.id.tv_phone);
            view.setTag(holder);
        }else{
=======
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
        if (view == null){
            view = View.inflate(context, R.layout.item_list_contact_select,null);
            holder = new ViewHolder();
            holder.mNameTV = (TextView) view.findViewById(R.id.tv_name);
            holder.mPhoneTV = (TextView) view.findViewById(R.id.tv_phone);
            view.setTag(holder);
        }else {
<<<<<<< HEAD
=======
>>>>>>> origin/master
>>>>>>> 8d5b340909dc5ebe38957b1bdeddc64d28dd3680
            holder = (ViewHolder) view.getTag();
        }
        holder.mNameTV.setText(contactInfos.get(i).name);
        holder.mPhoneTV.setText(contactInfos.get(i).phone);
        return view;
    }
    static class ViewHolder{
        TextView mNameTV;
        TextView mPhoneTV;
    }
}
