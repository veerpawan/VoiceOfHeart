package minister.portal.com.voiceofheart;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Typeface;

/**
 * Created by Veer on 7/29/2015.
 */
public class PrimaryFragment extends Fragment {



    View view;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         view=inflater.inflate(R.layout.primary_layout,null);
        TextView tv = (TextView) view.findViewById(R.id.tv_news);


        tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getContext(), Broadcastnews.class);
                startActivity(i);
                // do something
            }
        });
        return view;
    }



    }

