package scu.edu.fastreading.fragment.store;

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
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import scu.edu.fastreading.R;
import scu.edu.fastreading.fragment.FragmentAdapter;
import scu.edu.fastreading.fragment.TabFragment;


public class StoreFragment extends Fragment {

    private StoreViewModel dashboardViewModel;

    private ViewPager pager;
    private FragmentAdapter fragmentAdapter;
    private List<TabFragment> fragmentList;
    private TabLayout tabLayout;
    private List<String> mTitles;
    private String [] title={"精选","分类","榜单","书单"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(StoreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_store, container, false);

        pager=root.findViewById(R.id.viewpager);
        tabLayout=root.findViewById(R.id.tablayout);


        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        fragmentList=new ArrayList<>();
        mTitles=new ArrayList<>();
        for(int i=0;i<title.length;i++){
            mTitles.add(title[i]);
            fragmentList.add(new TabFragment(i));
        }

        fragmentAdapter=new FragmentAdapter(getActivity().getSupportFragmentManager(),fragmentList,mTitles);
        pager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(pager);//与ViewPage建立关系
    }
}