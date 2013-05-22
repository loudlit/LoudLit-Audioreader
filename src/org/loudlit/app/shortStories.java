package org.loudlit.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class shortStories extends ListActivity{
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	String categories[] = { "cask","magi","prince","paper","decay","window","pitandpendulum","heart","fire"};
	String dispcategories[] = {"The Cask of Amontillado","The Gift of the Magi","The Happy Prince","How I Edited an Agricultural Paper","On the Decay of the Art of Lying","The Open Window","The Pit and the Pendulum","The Tell-Tale Heart","To Build a Fire"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(shortStories.this, android.R.layout.simple_list_item_1, dispcategories));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try{
			Class<?> theClicked = Class.forName("org.loudlit.app.Reader");
			Intent toClick = new Intent(shortStories.this, theClicked);
			toClick.putExtra("book",categories[position]);
			startActivity(toClick);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
