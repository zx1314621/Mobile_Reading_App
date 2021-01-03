package scu.edu.fastreading.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

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
            CarouselView carouselView;
            int[] sampleImages = {R.drawable.book1, R.drawable.book2, R.drawable.book3, R.drawable.image_4};
            //int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};

            view = inflater.inflate(R.layout.fragment_great,container,false);

            ImageListener imageListener = new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    imageView.setImageResource(sampleImages[position]);
                }
            };

            carouselView = (CarouselView) view.findViewById(R.id.carouselView);
            if (carouselView != null) {
                carouselView.setPageCount(sampleImages.length);

                carouselView.setImageListener(imageListener);
            }

            carouselView.setImageClickListener(new ImageClickListener() {
                @Override
                public void onClick(int position) {
                    Toast.makeText(getActivity(), "Clicked item: "+ position, Toast.LENGTH_SHORT).show();
                }
            });


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