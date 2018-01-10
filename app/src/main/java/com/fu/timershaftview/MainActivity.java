package com.fu.timershaftview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;   //设置false 就是禁止RecyclerView滑动
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);

        //模拟数据集
        ArrayList<LogisticsBean> logisticsBeans = new ArrayList<>();
        logisticsBeans.add(new LogisticsBean("昨天", "20:10", 1, "已签收", "[自提柜]已签收，签收人凭取货码签收。感谢使用CQ高朋花园蜂巢【自提柜】，期待再次为您服务。"));
        logisticsBeans.add(new LogisticsBean("昨天", "10:05", 0, "待取件", "[自提柜]你的快件已被CQ高朋花园蜂巢【自提柜】代收，请及时取件。"));
        logisticsBeans.add(new LogisticsBean("昨天", "09:09", 0, "派送中", "[重庆市]重庆机场公司派送"));
        logisticsBeans.add(new LogisticsBean("昨天", "08:09", 0, "运输中", "【重庆机场公司】已收入"));
        logisticsBeans.add(new LogisticsBean("01-08", "16:31", 0, "", "快件已到达【重庆机场公司】 扫描员是【石海波】"));
        logisticsBeans.add(new LogisticsBean("01-07", "23:23", 0, "", "由【广东航空部】发往【重庆航空部】"));
        logisticsBeans.add(new LogisticsBean("01-06", "16:23", 0, "已揽件", "【华强营业点】已收件"));

        MyAdapter adapter = new MyAdapter(this, logisticsBeans);
        recyclerView.setAdapter(adapter);
    }
}
