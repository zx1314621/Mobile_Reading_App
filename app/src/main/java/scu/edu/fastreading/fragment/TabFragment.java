package scu.edu.fastreading.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import scu.edu.fastreading.R;


public class TabFragment extends Fragment {
    private TextView titleTv;

    private int postion;

    //这个构造方法是便于各导航同时调用一个fragment
    public TabFragment(int pos){
        postion=pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = null;
        if (postion == 0) {
            view = inflater.inflate(R.layout.fragment_great,container,false);
        } else if (postion == 1) {
            view = inflater.inflate(R.layout.fragment_classsify,container,false);

        } else if (postion == 2) {
            view = inflater.inflate(R.layout.fragment_rank,container,false);

        } else if (postion == 3) {
            view = inflater.inflate(R.layout.fragment_book_list,container,false);
        }

        return view;
    }
}