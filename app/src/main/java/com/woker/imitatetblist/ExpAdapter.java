package com.woker.imitatetblist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 适配器
 */

public class ExpAdapter extends BaseExpandableListAdapter {
    private List<TitleInfo> groups;
    private Map<String, List<ContentInfo>> childrens;
    private Context mcontext;

    public ExpAdapter(List<TitleInfo> groups, Map<String, List<ContentInfo>> childrens, Context mcontext) {
        this.groups = groups;
        this.childrens = childrens;
        this.mcontext = mcontext;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String groupId = groups.get(groupPosition).getId();
        return childrens.get(groupId).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        List<ContentInfo> childs = childrens.get(groups.get(groupPosition).getId());
        return childs.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mcontext, R.layout.item_shopcat_group, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        final TitleInfo group = (TitleInfo) getGroup(groupPosition);
        groupViewHolder.storeName.setText("中关村民住宅小区" + groupPosition);
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mcontext, R.layout.item_shopcat_product, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        final ContentInfo child = (ContentInfo) getChild(groupPosition, childPosition);
        if (child != null) {
            childViewHolder.tv_my_node_title2.setText("29.1 施工图预算编制-业主单位" + childPosition);
            childViewHolder.tv_my_node_plan_time.setText("计划用时：1天");
            childViewHolder.tv_my_node_finish_time.setText("截止时间：2017年10月22日");
            childViewHolder.iv_status.setImageResource(R.drawable.icon_superior_isleading);
            childViewHolder.tv_my_node_ok.setText("完成");
            childViewHolder.layout_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mcontext, "当前在：" + groupPosition + "///" + childPosition, Toast.LENGTH_LONG).show();
                }
            });
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class GroupViewHolder {
        @BindView(R.id.store_name)
        TextView storeName;

        public GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildViewHolder {
        @BindView(R.id.iv_status)
        ImageView iv_status;
        @BindView(R.id.tv_my_node_title2)
        TextView tv_my_node_title2;
        @BindView(R.id.tv_my_node_plan_time)
        TextView tv_my_node_plan_time;
        @BindView(R.id.tv_my_node_finish_time)
        TextView tv_my_node_finish_time;
        @BindView(R.id.tv_my_node_ok)
        TextView tv_my_node_ok;
        @BindView(R.id.layout_item)
        LinearLayout layout_item;

        public ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
