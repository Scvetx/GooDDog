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
	 
// key для ArrayList	
public static final String ACCESSORIES_NAME = "name";
private final String ACCESSORIES_DESCRIPTION = "description";
private final String IMAGE = "image";

// массивы содержимого для трех View списка
String [] arrAccessories = {"Аксессуар 1", "Аксессуар 2"};
String [] arrAccessoriesDescription = 
{"Описание Аксессуара 1. Здесь что-то будет описываться и, вероятно, будет много текста.",
		"Описание Аксессуара 2. Здесь тоже будет текст. Может много, а может и мало."};
String [] http = {"http://poisk-druga.ru/breeds/poroda-a/235-avstralijskij-shelkovistyj-terer.html", 
		"http://poisk-druga.ru/breeds/poroda-b/136-basendzhi.html"};
int [] image = {R.drawable.jp320, R.drawable.jp400};

TextView tvTop;
ListView list;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		ActionBar bar = getActionBar();
		bar.setDisplayShowTitleEnabled(true); // показывает текст рядом с кнопкой home
		bar.setDisplayShowHomeEnabled(true); // показывает иконку приложения
		bar.setDisplayHomeAsUpEnabled(true); // добавляет стрелочку возврата на активити вверх
		bar.setTitle(R.string.accessories); // название активности
		
		// Коллекция для содержимого списка
		ArrayList <Map <String, Object>> array = 
				new ArrayList <Map <String, Object>> (arrAccessories.length);
		
		//заполнение коллекции содержимым (3 элемента map для 3 View)
		for (int i = 0; i<arrAccessories.length; i++) {
			// Элемент коллекции
			Map <String, Object> map = new HashMap <String, Object> ();
			map.put(ACCESSORIES_NAME, arrAccessories[i]); // элемент названия аксессуара
			map.put(ACCESSORIES_DESCRIPTION, arrAccessoriesDescription[i]); // элемент описания аксессуара
			map.put(IMAGE, image[i]); // элемент фото аксессуара
			array.add(map); // добавление элементов в коллекцию
		}
		
		//создание массивa ключей, по которым будут добавляться элементы
		String [] from = {ACCESSORIES_NAME, ACCESSORIES_DESCRIPTION, IMAGE};
		//создание массивa View, в которые будут добавляться элементы
		int [] to = {R.id.tvAccessoriesName, R.id.tvAccessoriesDescription, R.id.imgAccessories};
		
		//создание адаптера, создающего список из добавленных в коллекцию элементов
		SimpleAdapter adapter = new SimpleAdapter 
				(this, array, R.layout.accessories_list, from, to);
		
		// присваиваем адаптер ListView
		list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(this);
	}
	
		// обработчик нажатия меню
		public boolean onOptionsItemSelected (MenuItem item) {
			switch (item.getItemId()) {
			case (android.R.id.home):
				NavUtils.navigateUpFromSameTask (this); // переход к родительской активности
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
