package ss.scvex.test21_testapp;

import static ss.scvex.test21_testapp.Training.TRAINING_IMAGE;
import static ss.scvex.test21_testapp.Training.TRAINING_DESCRIPTION;
import static ss.scvex.test21_testapp.Training.TRAINING_NAME;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class TrainingDescription extends ActionBarActivity {
	
	Intent intent;
	
    FragmentPagerAdapter fragmentPagerAdapter; // адаптер для перелистывания фрагментов
    List<Fragment> fragments = new ArrayList<Fragment>(); // список фрагментов для отображения
    ViewPager viewPager;  // ViewPager для отображения фрагментов
	
    int length; // количество элементов передаваемого массива строк
    
	//массив названий вкладок tab
	String [] arr = {"Шаг 1", "Шаг 2", "Шаг 3", "Шаг 4", "Шаг 5", "Шаг 6", "Шаг 7"};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.training_description);
		
		ActionBar bar = getActionBar();
		bar.setDisplayShowTitleEnabled(true); // показывает текст рядом с кнопкой home
		bar.setDisplayShowHomeEnabled(true); // показывает иконку приложения
		bar.setDisplayHomeAsUpEnabled(true); // добавляет стрелочку возврата на активити вверх
		
		// получение названия команды, выбранной в Training.java
		Intent intent = getIntent();
		String trainingName = intent.getStringExtra(TRAINING_NAME);
		// название команды будет отображаться рядом с кнопкой home
		bar.setTitle(trainingName); 
		
		// получение массива описания команды переданного из Training при нажатии на пункт списка
		String [] arrDescription = intent.getStringArrayExtra(TRAINING_DESCRIPTION);
		length = arrDescription.length; // количество фрагментов = количеству элементов массива
		
		// получение массива картинок команды переданного из Training при нажатии на пункт списка
		int [] arrImage = intent.getIntArrayExtra(TRAINING_IMAGE);
		
		for (int i = 0; i < length; i++) {
			// создание фрагментов
			TrainingDescriptionFragment fr = new TrainingDescriptionFragment();
			fr.setFragmentContent(arrDescription[i], arrImage[i]); // заполнение фрагмента контентом
			fragments.add(i, fr); // добавление фрагмента в коллекцию
		}
		
		 // Настройка фрагментов, определяющих количество фрагментов и экраны
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

        	// количество фрагментов
            @Override
            public int getCount() {
                return length;
            }
            
            @Override
            public Fragment getItem(final int position) {
                return fragments.get(position);
            }
                
               //название вкладок tabs
        	@Override
            public CharSequence getPageTitle (int position) {
        		return arr[position];
        	}
        };
        
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(0);	// по умолчанию показывается первый фрагмент		
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

		
}
