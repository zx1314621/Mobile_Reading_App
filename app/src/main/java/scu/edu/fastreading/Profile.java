package scu.edu.fastreading;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Profile extends AppCompatActivity {
    ArrayList<HashMap<String, Object>> images;
    SimpleAdapter simpleAdapter = null;
    GridView gridView;
    Bitmap bmp;
    ImageButton portrait;
    ImageButton book;
    ImageButton message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        gridView = (GridView) findViewById(R.id.grid_view);
        portrait = (ImageButton)findViewById(R.id.portrait);
        book = (ImageButton)findViewById(R.id.book);
        message = (ImageButton)findViewById(R.id.message);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.recent_view);
        Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.share);
        Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.like);
        Bitmap bmp3 = BitmapFactory.decodeResource(getResources(), R.drawable.text_download);
        Bitmap bmp4 = BitmapFactory.decodeResource(getResources(), R.drawable.comic_download);
        images= new ArrayList<HashMap<String, Object>>();
        final HashMap<String, Object> map = new HashMap<String, Object>();
        final HashMap<String, Object> map1 = new HashMap<String, Object>();
        final HashMap<String, Object> map2 = new HashMap<String, Object>();
        final HashMap<String, Object> map3 = new HashMap<String, Object>();
        final HashMap<String, Object> map4 = new HashMap<String, Object>();

        map.put("itemImage", bmp);
        map.put("text", "recent");
        map1.put("itemImage", bmp1);
        map1.put("text", "share");
        map2.put("itemImage", bmp2);
        map2.put("text", "like");
        map3.put("itemImage", bmp3);
        map3.put("text", "text_download");
        map4.put("itemImage", bmp4);
        map4.put("text", "comic_download");

        images.add(map);
        images.add(map1);
        images.add(map2);
        images.add(map3);
        images.add(map4);
        String[] from = new String[]{"itemImage", "text"};
        int[] to = new int[]{R.id.imageView1, R.id.text1};

        simpleAdapter = new SimpleAdapter(this,
                images, R.layout.griditem_addpic,
                from, to);
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String s) {
                if(view instanceof ImageView && data instanceof Bitmap){
                    ImageView i = (ImageView)view;
                    i.setImageBitmap((Bitmap) data);
                    return true;
                }
                return false;
            }
        });
        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Profile.this, "click on the " + i, Toast.LENGTH_SHORT).show();
            }
        });

        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile.this, "click on the portrait", Toast.LENGTH_SHORT).show();
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile.this, "click on the my_book button", Toast.LENGTH_SHORT).show();
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile.this, "click on the my_message button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}