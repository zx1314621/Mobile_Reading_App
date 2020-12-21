package scu.edu.fastreading.fragment.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import scu.edu.fastreading.R;
import scu.edu.fastreading.entities.Book;


public class BookFragment extends Fragment {

    private BookViewModel bookViewModel;

    private RecyclerView mGridRv;
    private BookRecyclerViewAdapter adapter;

    private ArrayList<Book> bookList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bookViewModel =
                ViewModelProviders.of(this).get(BookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_book, container, false);

        mGridRv = root.findViewById(R.id.RV_grid_id);


        mGridRv.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        getData();

        mGridRv.setAdapter(adapter);
        return root;
    }

    private void getData() {
        bookList = new ArrayList<>();

        Book book1 = new Book();
        book1.setBookName("回到三国战五胡");
        book1.setBookDesc("当三国演义里的撒豆成兵成了真，当豪桀纵横、熊据虎跱的三国争霸时代，撞上‘五胡’入侵，将会谱写一曲怎样可歌可泣的英雄史？最强蒙古！最强契丹！最强鲜卑！最强女真！最强突厥！还有众多的异族悍将降临此世！汉末粉墨登场的名将谋士，面对这曾属于汉族的至暗时代，面对这险象环生的旷古危局，当做出怎样的抉择？是束手就擒被当两脚羊？是俯首称臣去做卑躬屈膝的狗？亦或是拿起手中的兵器，吼出今生最强音：汉胡不两立、王业不偏安！一个全新的时代正在徐徐展开……天降英豪穿吕布，五胡入侵浑不怕，今这乱世我来平，汉家天下我来定，复我华夏炎黄土，名将谋臣四海赴，试问我有何资本，单凭吾叫吕奉先！……看惯了各式各样的三国争霸，那么就来些不同口味的新三国争霸，熟悉的名字，熟悉的背景，只是不同的是全新的战斗。书友群：938.887.683");
        book1.setLastEditContent("第一百一十四章 雒阳风波，人生百态");
        book1.setLastEditTime(new Date());
        book1.setBookImg(R.drawable.book1+"");


        Book book2 = new Book();
        book2.setBookName("诡秘之主");
        book2.setBookDesc("蒸汽与机械的浪潮中，谁能触及非凡？历史和黑暗的迷雾里，又是谁在耳语？我从诡秘中醒来，睁眼看见这个世界：　　枪械，大炮，巨舰，飞空艇，差分机；魔药，占卜，诅咒，倒吊人，封印物……光明依旧照耀，神秘从未远离，这是一段“愚者”的传说。");
        book2.setLastEditContent("新书已发");
        book2.setLastEditTime(new Date());
        book2.setBookImg(R.drawable.book2+"");

        Book book3 = new Book();
        book3.setBookName("吞噬星空");
        book3.setBookDesc("　　继《九鼎记》《盘龙》《星辰变》《寸芒》《星峰传说》后，番茄的第六本书！\n" +
                "——————\n" +
                "简介：\n" +
                "星空中。\n" +
                "“这颗星球，通体土黄色，没有任何生命存在，直径21000公里，咦，竟然蕴含‘星泪金’矿脉，真是天助我也，将这颗星球吞噬掉后，我的实力应该能恢复到受伤前的80％。”脸色苍白的罗峰盘膝坐在一颗飞行的陨石上，遥看远处的一颗无生命存在的行星。\n" +
                "——————\n" +
                "番茄第六部小说《吞噬星空》，将为大家展现出一个浩瀚广阔、神秘莫测的未来世界。\n" +
                "。");

        book3.setLastEditContent("更新时间公告");

        book3.setLastEditTime(new Date());
        book3.setBookImg(R.drawable.book3+"");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);



        adapter = new BookRecyclerViewAdapter(getActivity(), bookList);
    }


}