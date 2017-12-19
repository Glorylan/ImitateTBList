package com.woker.imitatetblist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ExpandableListView listView;

    private Context mcontext;
    private ExpAdapter adapter;
    private List<TitleInfo> groups; //组元素的列表
    private Map<String, List<ContentInfo>> childs; //子元素的列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initEvents();
    }

    private void initData() {
        mcontext = this;
        groups = new ArrayList<TitleInfo>();
        childs = new HashMap<String, List<ContentInfo>>();
        for (int i = 0; i < 6; i++) {
            groups.add(new TitleInfo(i + "", ""));
            List<ContentInfo> goods = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                goods.add(new ContentInfo("", "", "", ""));
            }
            childs.put(groups.get(i).getId(), goods);
        }
    }

    private void initEvents() {
        adapter = new ExpAdapter(groups, childs, mcontext);
        listView.setGroupIndicator(null); //设置属性 GroupIndicator 去掉向下箭头
        listView.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            listView.expandGroup(i); //关键步骤4:初始化，将ExpandableListView以展开的方式显示
        }
    }

}
