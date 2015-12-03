package com.jiang.android.recyclerviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jiang.android.recyclerviewadapter.adapter.BaseAdapter;
import com.jiang.android.recyclerviewadapter.adapter.BaseHeadFootAdapter;
import com.jiang.android.recyclerviewadapter.adapter.MyAdapter;
import com.jiang.android.recyclerviewadapter.adapter.MyAdapter3;
import com.jiang.android.recyclerviewadapter.holder.BaseViewHolder;
import com.jiang.android.recyclerviewadapter.inter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Character> mLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        initData();

      //  setBaseAdapter();
      //  setHeadFootItem();


      //  setItem();

        setHeadNotFooter();

     //   setHeaderFooterAdapter();


    }

    private void setHeaderFooterAdapter() {
        /**
         * 最省的写法 ,带header和不带footer
         */
        mRecyclerView.setAdapter(new BaseHeadFootAdapter<Character>(R.layout.item_main, this, mLists, R.layout.item_header, R.layout.item_header) {
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
            protected void onBindView(BaseViewHolder holder, final int position) {
                TextView mTitle = holder.getView(R.id.item_tv);
                mTitle.setText(this.getmLists().get(position) + "");
                holder.getmConvertView().setClickable(true);
                holder.getmConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast(position + "");
                    }
                });

            }

        });
    }

    private void setBaseAdapter() {
        /**
         * 最基础的adapter
         */
        MyAdapter adapter1 = new MyAdapter(mLists, this);
        adapter1.setonItemClick(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showToast(position + "");
            }
        });
        mRecyclerView.setAdapter(adapter1);
    }

    private void setHeadFootItem() {
        /**
         * 既有header 又有footer 又有 onitemclicklistener
         */
        MyAdapter3 adapter = new MyAdapter3(mLists, this, R.layout.item_main);
        adapter.addHeader(R.layout.item_header);
        adapter.addFooter(R.layout.item_header);
        mRecyclerView.setAdapter(adapter);
    }

    private void setItem() {
        /**
         * 最省的写法 ,不带header和footer
         */
        mRecyclerView.setAdapter(new BaseAdapter<Character>(mLists, this, R.layout.item_main) {
            @Override
            protected void onBindView(BaseViewHolder holder, final int position) {
                TextView mTitle = holder.getView(R.id.item_tv);
                mTitle.setText(this.getmLists().get(position) + "");
                holder.getmConvertView().setClickable(true);
                holder.getmConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast(position + "");
                    }
                });

            }

        });
    }

    private void setHeadNotFooter() {
        /**
         * 最省的写法 ,带header和不带footer
         */
        mRecyclerView.setAdapter(new BaseHeadFootAdapter<Character>(R.layout.item_main, this, mLists, R.layout.item_header, 0) {
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
            protected void onBindFooterView(BaseViewHolder holder, int position) {

            }

            @Override
            protected void onBindView(BaseViewHolder holder, final int position) {
                TextView mTitle = holder.getView(R.id.item_tv);
                mTitle.setText(this.getmLists().get(position) + "");
                holder.getmConvertView().setClickable(true);
                holder.getmConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast(position + "");
                    }
                });

            }

        });
    }

    private void showToast(String value) {
        Toast.makeText(MainActivity.this, "你点击了" + value + "", Toast.LENGTH_SHORT).show();
    }

    private void initData() {
        mLists = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            mLists.add((char) (i + 65));
        }
    }
}
