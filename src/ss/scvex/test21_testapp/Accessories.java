package ss.scvex.test21_testapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
import android.app.ActionBar; 
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View; 
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Accessories extends ActionBarActivity implements OnItemClickListener {
	
public static final String WEB = "web";
	 
// key ��� ArrayList	
public static final String ACCESSORIES_NAME = "name";
private final String ACCESSORIES_DESCRIPTION = "description";
private final String IMAGE = "image";

// ������� ����������� ��� ���� View ������
String [] arrAccessories = {"��������� 1", "��������� 2"};
String [] arrAccessoriesDescription = 
{"�������� ���������� 1. ����� ���-�� ����� ����������� �, ��������, ����� ����� ������.",
		"�������� ���������� 2. ����� ���� ����� �����. ����� �����, � ����� � ����."};
String [] http = {"http://poisk-druga.ru/breeds/poroda-a/235-avstralijskij-shelkovistyj-terer.html", 
		"http://poisk-druga.ru/breeds/poroda-b/136-basendzhi.html"};
int [] image = {R.drawable.jp320, R.drawable.jp400};

TextView tvTop;
ListView list;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		ActionBar bar = getActionBar();
		bar.setDisplayShowTitleEnabled(true); // ���������� ����� ����� � ������� home
		bar.setDisplayShowHomeEnabled(true); // ���������� ������ ����������
		bar.setDisplayHomeAsUpEnabled(true); // ��������� ��������� �������� �� �������� �����
		bar.setTitle(R.string.accessories); // �������� ����������
		
		// ��������� ��� ����������� ������
		ArrayList <Map <String, Object>> array = 
				new ArrayList <Map <String, Object>> (arrAccessories.length);
		
		//���������� ��������� ���������� (3 �������� map ��� 3 View)
		for (int i = 0; i<arrAccessories.length; i++) {
			// ������� ���������
			Map <String, Object> map = new HashMap <String, Object> ();
			map.put(ACCESSORIES_NAME, arrAccessories[i]); // ������� �������� ����������
			map.put(ACCESSORIES_DESCRIPTION, arrAccessoriesDescription[i]); // ������� �������� ����������
			map.put(IMAGE, image[i]); // ������� ���� ����������
			array.add(map); // ���������� ��������� � ���������
		}
		
		//�������� ������a ������, �� ������� ����� ����������� ��������
		String [] from = {ACCESSORIES_NAME, ACCESSORIES_DESCRIPTION, IMAGE};
		//�������� ������a View, � ������� ����� ����������� ��������
		int [] to = {R.id.tvAccessoriesName, R.id.tvAccessoriesDescription, R.id.imgAccessories};
		
		//�������� ��������, ���������� ������ �� ����������� � ��������� ���������
		SimpleAdapter adapter = new SimpleAdapter 
				(this, array, R.layout.accessories_list, from, to);
		
		// ����������� ������� ListView
		list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(this);
	}
	
		// ���������� ������� ����
		public boolean onOptionsItemSelected (MenuItem item) {
			switch (item.getItemId()) {
			case (android.R.id.home):
				NavUtils.navigateUpFromSameTask (this); // ������� � ������������ ����������
	        	return  true;
			default: return super.onOptionsItemSelected(item);
			}
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent = new Intent (this, WebAccessories.class);
			intent.putExtra(ACCESSORIES_NAME, arrAccessories[position]);
			intent.putExtra(WEB, http [position]);
			startActivity(intent);
		}
	
		
}
