package scu.edu.fastreading.fragment.store;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.Slider;
import com.google.android.material.tabs.TabLayout;
import com.xyz.xswitch.XyzSwitch;

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
    ImageButton search;
    ImageButton girl;
    Context mcontext;
    XyzSwitch xyzSwitch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(StoreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_store, container, false);
        search = root.findViewById(R.id.search);
        girl = root.findViewById(R.id.girl);
        xyzSwitch = root.findViewById(R.id.xswitch1);
        this.mcontext = getActivity();

        pager=root.findViewById(R.id.viewpager);
        tabLayout=root.findViewById(R.id.tablayout);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"this is a search button", Toast.LENGTH_SHORT).show();
            }
        });

        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"this is a girl button", Toast.LENGTH_SHORT).show();
            }
        });

        xyzSwitch.setOnXyzSwitchChangeListener(new XyzSwitch.XyzSwitchChange() {
            @Override
            public void changed(boolean isRight) {
                Toast.makeText(mcontext,isRight?"this is Comic page":"This is Novel page",Toast.LENGTH_SHORT).show();
            }
        });

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