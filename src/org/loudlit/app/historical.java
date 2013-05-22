package org.loudlit.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class historical extends ListActivity{
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	String categories[] = { "declaration","gettysburgNew"};
	String dispcategories[] = {"The Declaration of Independence","The Gettysburg Address"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(historical.this, android.R.layout.simple_list_item_1, dispcategories));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try{
			Class<?> theClicked = Class.forName("org.loudlit.app.Reader");
			Intent toClick = new Intent(historical.this, theClicked);
			toClick.putExtra("book",categories[position]);
			startActivity(toClick);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
