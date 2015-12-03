package com.jiang.android.recyclerviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jiang.android.recyclerviewadapter.adapter.MyAdapter2;
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

        MyAdapter2 adapter = new MyAdapter2(mLists, this, R.layout.item_main);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showToast(position + "");
            }
        });
        mRecyclerView.setAdapter(adapter);

    }

    private void showToast(String value) {
        Toast.makeText(MainActivity.this, "你点击了" + value + "", Toast.LENGTH_SHORT).show();
    }

    private void initData() {
        mLists = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mLists.add((char) (i + 65));
        }
    }
}
