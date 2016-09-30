package minister.portal.com.voiceofheart;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by VEER on 9/2/2016.
 */
public class AudioActivity extends Activity {

    MediaPlayer mp        = null;
    String tevar         = "tevar";
    String terimeri        = "terimeri";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speech_layout);

        /**
         * Talking with the buttonHello
         */
        final Button buttonHello = (Button) findViewById(R.id.btn_aud_1);
        buttonHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerOfSound(tevar);
            } // END onClick()
        }); // END buttonHello

        /**
         * Talking with the buttonGoodBye
         */
        final Button buttonGoodBye = (Button) findViewById(R.id.btn_aud_2);
        buttonGoodBye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerOfSound(terimeri);
            } // END onClick()
        }); // END buttonGoodBye
    } // END onCreate()

    /**
     * Manager of Sounds
     */
    protected void managerOfSound(String theText) {
        if (mp != null) {
            mp.reset();
            mp.release();
        }
        if (theText == terimeri)
            mp = MediaPlayer.create(this, R.raw.terimeri);
        else if (theText == tevar)
            mp = MediaPlayer.create(this, R.raw.tevar);

        mp.start();
    }
}


