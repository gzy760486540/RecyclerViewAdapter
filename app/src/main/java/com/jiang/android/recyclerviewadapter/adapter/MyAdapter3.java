/**
 * created by jiang, 12/3/15
 * Copyright (c) 2015, jyuesong@gmail.com All Rights Reserved.
 * *                #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

package com.jiang.android.recyclerviewadapter.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jiang.android.library.main.adapter.BaseHeadFootAdapter;
import com.jiang.android.library.main.holder.BaseViewHolder;
import com.jiang.android.recyclerviewadapter.R;

import java.util.List;

/**
 * Created by jiang on 12/3/15.
 */
public class MyAdapter3 extends BaseHeadFootAdapter<Character> {


    private static final String TAG = "MyAdapter3";


    public MyAdapter3(List<Character> mLists, Context mContext, int layoutID) {
        super(mLists, mContext, layoutID);
    }

    @Override
    protected void onBindHeaderView(BaseViewHolder holder, final int position) {
        holder.getView(R.id.item_header).setClickable(true);
        holder.getView(R.id.item_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onBindFooterView(BaseViewHolder holder, final int position) {
        holder.getView(R.id.item_header).setClickable(true);
        holder.getView(R.id.item_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBindView(BaseViewHolder holder, final int position) {
        TextView title = holder.getView(R.id.item_tv);
        title.setText(mLists.get(position) + "");
        holder.getmConvertView().setClickable(true);
        holder.getmConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你点击了(相对于ItemList而不是相对于整个List)" + position, Toast.LENGTH_SHORT).show();
            }
        });
        Log.i(TAG, mLists.get(position) + "; p" + position);
    }
}
