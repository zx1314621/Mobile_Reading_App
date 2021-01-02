package scu.edu.fastreading.fragment.book;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.xyz.xswitch.XyzSwitch;

import scu.edu.fastreading.R;
import scu.edu.fastreading.activities.MainActivity;


public class BookFragment extends Fragment {

    private BookViewModel bookViewModel;
    ImageButton arrow;
    ImageButton search1;
    Context mcontext;
    XyzSwitch xswtich;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bookViewModel =
                ViewModelProviders.of(this).get(BookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_book, container, false);
        final TextView textView = root.findViewById(R.id.text_book);
        this.mcontext = getActivity();
        arrow = root.findViewById(R.id.arrow);
        search1 = root.findViewById(R.id.search1);
        xswtich = root.findViewById(R.id.xswitch);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"this is an arrow button", Toast.LENGTH_SHORT).show();
            }
        });

        search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"this is a search1 button", Toast.LENGTH_SHORT).show();
            }
        });

        xswtich.setOnXyzSwitchChangeListener(new XyzSwitch.XyzSwitchChange() {
            @Override
            public void changed(boolean isRight) {
                Toast.makeText(mcontext,isRight?"this is Comic page":"This is Novel page",Toast.LENGTH_SHORT).show();
            }
        });

        bookViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}