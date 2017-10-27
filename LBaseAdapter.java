package com.gsww.wwxq.utils;


import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gsww.wwxq.WApplication;


/**
 * Created by Liz on 2016/5/6.
 * 实现了listView的优化
 */
public abstract class LBaseAdapter extends BaseAdapter {
    //实现了listView的优化
    public ViewHolder holder = null;

    @Override
    public abstract int getCount();

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    //回调init、setLayoutId
    public View initView(int position, View convertView, ViewGroup parent) {
        int layoutId = setLayoutId();
        if (convertView == null) {
            convertView = View.inflate(WApplication.getInstance(), layoutId, null);
            holder = new ViewHolder();
            bindHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return setWidget(position, convertView, parent);
    }

    //回调setHolder
    public void bindHolder(View convertView) {
         setHolder(convertView);//把getView的converView传递给Holder
    }

    /**
     * 设置控件UI,返回convertView,返回值不能为空,为convertView
     */
    public abstract
    @NonNull
    View setWidget(int position, View convertView, ViewGroup parent);

    /**
     * 找到控件并设置给ViewHolder,convertView是getView()传递下来的即setLayoutId()所设置View，重写setHolder方法时注意用convertView.findViewById()找控件;
     */
    public abstract void setHolder(View convertView);

    /**
     * 设置Adapter所在的View的Id
     */
    public abstract int setLayoutId();

    //添加自己的控件类型
    public class ViewHolder {
        public ImageView img_01;
        public ImageView img_02;
        public TextView tv_01;
        public TextView tv_02;
        public TextView tv_03;
        public TextView tv_04;
        public TextView tv_05;
        public TextView tv_06;
        public RadioButton rb_01;
        public GridView gv_01;
        public CheckBox cb_01;

    }
}
