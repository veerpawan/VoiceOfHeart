package minister.portal.com.voiceofheart;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by VEER on 8/30/2016.
 */
public class Speech extends Fragment {
    MediaPlayer mp;
    String tevar = "tevar";

    View view;
    Boolean isPlaying = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.speech_layout, null);


        Button buttonHello = (Button) view.findViewById(R.id.btn_aud_1);

        buttonHello.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                          public void onClick(View view) {
                                               go();


                                               /*mp = MediaPlayer.create(getContext(), R.raw.tevar);
                                               mp.start();*/
                                           }

                                       }


        );


        return view;
    }
    public void go() {
        if(mp == null) {
            mp=MediaPlayer.create(getContext(), R.raw.tevar);
        }
        if(mp.isPlaying()){
            mp.pause();
            /*try {
                mp.prepare();
            } catch (IllegalStateException e) {

                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mp.seekTo(0);*/
        }
        else {
            mp.start();
        }


/*
            if(mp!=null && mp.isPlaying())
            {
                mp.release();
                mp = null;
            }*/
    }



}






