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
import android.widget.TextView;

import com.jiang.android.recyclerviewadapter.BaseViewHolder;
import com.jiang.android.recyclerviewadapter.R;

import java.util.List;

/**
 * Created by jiang on 12/3/15.
 */
public class MyAdapter2 extends BaseAdapter<Character> {

    private MyAdapter.CallBack mCallBack;

    public MyAdapter2(List<Character> mLists, Context mContext, int layoutID, MyAdapter.CallBack callBack) {
        super(mLists, mContext, layoutID);
        this.mCallBack = callBack;
    }

    public MyAdapter2(List<Character> mLists, Context mContext, int layoutID) {
        super(mLists, mContext, layoutID);
    }

    @Override
    public void onBindView(BaseViewHolder holder, final int position) {
        TextView title = holder.getView(R.id.item_tv);
        title.setText(mLists.get(position) + "");

    }
}
