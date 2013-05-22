package org.loudlit.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class poetry extends ListActivity{
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	String categories[] = { "alone","annabel","corinna","deever","cityshower","dream","eldorado","goblin","highwayman","mowerssong","westwind","raven","mariner","sonnets","virgins"};
	String dispcategories[] = {"Alone","Annabel Lee","Corinna's Going a Maying","Danny Deever","A Description of a City Shower","A Dream Within a Dream","Eldorado","Goblin Market","The Highwayman","The Mower's Song","Ode to the West Wind","The Raven","Rime of an Ancient Mariner","Selected Shakespearean Sonnets","To the Virgins to Make Much of Time"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(poetry.this, android.R.layout.simple_list_item_1, dispcategories));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try{
			Class<?> theClicked = Class.forName("org.loudlit.app.Reader");
			Intent toClick = new Intent(poetry.this, theClicked);
			toClick.putExtra("book",categories[position]);
			startActivity(toClick);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
