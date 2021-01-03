package scu.edu.fastreading.fragment.book;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import scu.edu.fastreading.R;
import scu.edu.fastreading.entities.Book;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.MyViewHolder>{
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Book> bookList;



    public BookRecyclerViewAdapter(Context context, ArrayList<Book> ar) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.bookList = ar;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(mLayoutInflater.inflate(R.layout.book_recycleview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.book_title.setText(bookList.get(position).getBookName());
        holder.update_content.setText(bookList.get(position).getLastEditContent());
        holder.update_time.setText(bookList.get(position).getLastEditTime().toString());

        //holder.book_image.setImageResource(Integer.valueOf(bookList.get(position).getBookImg()));
        String url="http://pic17.nipic.com/20111101/8730615_113658400143_2.jpg";
        Glide.with(mContext).load(Integer.valueOf(bookList.get(position).getBookImg())).into(holder.book_image);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "click:" + holder.book_title.getText().toString(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mContext, ProductDetailActivity.class);
//
//                Bundle bundle = new Bundle();
//
//                bundle.putString("itemName", itemList.get(position).getItemName());
//                bundle.putString("item_brand", itemList.get(position).getBrand());
//                bundle.putDouble("item_price",itemList.get(position).getPrice());
//                bundle.putString("img_url", itemList.get(position).getImg_url());
//                bundle.putString("img_desc", itemList.get(position).getItemDesc());
//                intent.putExtras(bundle);
//                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView book_image;
        private TextView book_title;
        private TextView update_content;
        private TextView update_time;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_image = itemView.findViewById(R.id.book_image);
            book_title = itemView.findViewById(R.id.title);
            update_content = itemView.findViewById(R.id.update_content);
            update_time = itemView.findViewById(R.id.update_time);
        }
    }
}
