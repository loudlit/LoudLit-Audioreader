package org.loudlit.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class childrens extends ListActivity{
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	String categories[] = { "rose","gretel","clothes","grisly","matchgirl","rapunzel","musicians"};
	String dispcategories[] = {"Briar Rose","Clever Gretel","The Emperor\'s New Clothes","King Grisly-beard","The Little Match Girl","Rapunzel","The Travelling Musicians"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(childrens.this, android.R.layout.simple_list_item_1, dispcategories));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try{
			Class<?> theClicked = Class.forName("org.loudlit.app.Reader");
			Intent toClick = new Intent(childrens.this, theClicked);
			toClick.putExtra("book",categories[position]);
			startActivity(toClick);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
