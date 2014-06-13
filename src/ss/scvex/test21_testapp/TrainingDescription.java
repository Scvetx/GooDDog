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
	
    FragmentPagerAdapter fragmentPagerAdapter; // ������� ��� �������������� ����������
    List<Fragment> fragments = new ArrayList<Fragment>(); // ������ ���������� ��� �����������
    ViewPager viewPager;  // ViewPager ��� ����������� ����������
	
    int length; // ���������� ��������� ������������� ������� �����
    
	//������ �������� ������� tab
	String [] arr = {"��� 1", "��� 2", "��� 3", "��� 4", "��� 5", "��� 6", "��� 7"};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.training_description);
		
		ActionBar bar = getActionBar();
		bar.setDisplayShowTitleEnabled(true); // ���������� ����� ����� � ������� home
		bar.setDisplayShowHomeEnabled(true); // ���������� ������ ����������
		bar.setDisplayHomeAsUpEnabled(true); // ��������� ��������� �������� �� �������� �����
		
		// ��������� �������� �������, ��������� � Training.java
		Intent intent = getIntent();
		String trainingName = intent.getStringExtra(TRAINING_NAME);
		// �������� ������� ����� ������������ ����� � ������� home
		bar.setTitle(trainingName); 
		
		// ��������� ������� �������� ������� ����������� �� Training ��� ������� �� ����� ������
		String [] arrDescription = intent.getStringArrayExtra(TRAINING_DESCRIPTION);
		length = arrDescription.length; // ���������� ���������� = ���������� ��������� �������
		
		// ��������� ������� �������� ������� ����������� �� Training ��� ������� �� ����� ������
		int [] arrImage = intent.getIntArrayExtra(TRAINING_IMAGE);
		
		for (int i = 0; i < length; i++) {
			// �������� ����������
			TrainingDescriptionFragment fr = new TrainingDescriptionFragment();
			fr.setFragmentContent(arrDescription[i], arrImage[i]); // ���������� ��������� ���������
			fragments.add(i, fr); // ���������� ��������� � ���������
		}
		
		 // ��������� ����������, ������������ ���������� ���������� � ������
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

        	// ���������� ����������
            @Override
            public int getCount() {
                return length;
            }
            
            @Override
            public Fragment getItem(final int position) {
                return fragments.get(position);
            }
                
               //�������� ������� tabs
        	@Override
            public CharSequence getPageTitle (int position) {
        		return arr[position];
        	}
        };
        
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(0);	// �� ��������� ������������ ������ ��������		
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

		
}
