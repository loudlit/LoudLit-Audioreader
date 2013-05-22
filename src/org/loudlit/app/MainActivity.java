package org.loudlit.app;

import java.io.IOException;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//final String zipFile= "org.loudlit.app:assets/Archive.zip";
		//final String decompressLocation = "org.loudlit.app:assets/";
		//final AssetManager zipFinder = getAssets();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Thread timer = new Thread(){
			
			public void run(){
				//String[] files = null;
				try{
					/*try {
						files = zipFinder.list("");
					} catch (IOException e){
						Log.e("tag","Failed to get asset file list",e);
					}
					if(files[0]=="Archive.zip"){
						Decompress d = new Decompress(zipFile,decompressLocation);
						d.unzip();
					}*/
					sleep(4000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					Intent openMenu = new Intent("org.loudlit.app.MENU");
					startActivity(openMenu);
				}
			}
		};
		timer.start();
	};
	

}
