package org.loudlit.app;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JoshActivity extends Activity implements OnErrorListener, OnPreparedListener, OnCompletionListener, OnBufferingUpdateListener {
	private Button buttonPlayStop;
	private Button stopbutton;
	private boolean boolMusicPlaying = false;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media_player);
		initViews();
		
		String url = "http://loudlit.org/mp3_downloads/heartofdarkness/01_heartofdarkness-text.mp3"; // your URL here
		final MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		try {
			mediaPlayer.setDataSource(url);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mediaPlayer.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // might take long! (for buffering, etc)
		
		stopbutton.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v) {
				if (boolMusicPlaying == true){
				mediaPlayer.stop();
				
				try {
					mediaPlayer.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mediaPlayer.seekTo(0);
				buttonPlayStop.setBackgroundResource(R.drawable.button_play_green);
				boolMusicPlaying = false;
			}
			}});
		buttonPlayStop.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				if (boolMusicPlaying == false) {
					
					buttonPlayStop.setBackgroundResource(R.drawable.button_pause_green);
					mediaPlayer.start();
					boolMusicPlaying = true;
				} else {
					if (boolMusicPlaying == true) {
						buttonPlayStop.setBackgroundResource(R.drawable.button_play_green);
						mediaPlayer.pause();
						boolMusicPlaying = false;
					}
				}
			}
		});
	}
	
	private void initViews() {
		buttonPlayStop = (Button) findViewById(R.id.buttonPlayStop);
		buttonPlayStop.setBackgroundResource(R.drawable.button_play_green);
		stopbutton = (Button) findViewById(R.id.stopbutton);
		stopbutton.setBackgroundResource(R.drawable.stopbutton);	
	
	}

	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onBufferingUpdate(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		
	}
	
}
