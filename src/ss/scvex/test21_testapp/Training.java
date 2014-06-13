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

public class Training extends ActionBarActivity implements OnItemClickListener {
	// ����������� ���������� ��������������� ������ �������� ������� ������ �������
	
	public static final String TRAINING_NAME = "name";
	public static final String TRAINING_DESCRIPTION = "description";
	public static final String TRAINING_IMAGE = "image";
	
	//  key ��� ArrayList
	private static final String KEY_TRAINING = "training";
	private static final String KEY_IMAGE = "image";
	
	TextView tvTop;
	ListView list;
	
	// ������� "��"
	String [] arrFu = {"�������� ���������: ������ ����� ����� ����. ����� ����� ������� ���������� �������. � ������ ���� ������ ���������.",
				"�� ��������� �������� ������ �������� ��������� � ���� ������ ���, ����� �� ���������� ������  ���.",
				"��� ������ ������ ���������� � ���������, �������� ��� � ����� � ������� ������ ����������� ����� ������. ������������ ���������� ���!�. ��� ��������� ��������� ��� �� ��� ���, ���� ������ �� �������� ������� � ���������. ����� ����� �� �������� ������� ������� �������, ����� ������ � ���� ������ �� ������� �� ���.",
				"��� ������ ������ �� ��������� ������ �������� ������� � ���������, ������ ��������� �� ����� � ������ ������.",
				"����� ������� ���� � ���������� ��-�� �����. �� �������� ������ �� ������� ���!� ���� ������ ��� ������."};
	// ������� "������"
	String [] arrSit = {"�������� ���������: ������ ����� ����� ����. � ��� � ������ ���� ���������.",
				"���������� ����� �� �������. ������ ����� ����� ����� ������ ������������� ���������, �� �������� ��� ������.",
				"�������� �������� ���� � ���������� �����, ������ ����� �������� ����� ������ �� ������� �� ����������� � ���� � �����. ��� ���� ������ �� ������ �������� �������� � ���������. ��� ����� �� ������� ������� ������ �� �����. ��� ���� ������������ ������ �����.",
				"���������� ������� �������!�  � ������������ ���� ������ ���������. ������ �������."};
	// ������� "������"
	String [] arrRest = {"�������� ���������: ������ ����� ����� �� ���. � ������ ���� �� ������� ���������.",
				"����� ���� ������ �� ����� ������, �� ����� ������ ��������. ������ ����� ����� ����� ������ �������������  ���������, �� �������� ��� ������.",
				"��������� ������ ����� � ������� ���������, ������ ����� �������� �������� ��������� ����. ������ ��� ���� ������ ���������� �� ��������, ��� ����� �������� ������ � �����.",
				"�� ��������������, ������ ��������� �� ������ �� ������� �� �����. ������ ��� ���� ������� �� ���������� � ��������� � ������� ���������.  ����� ���� ������� �� ����� ������, ����� ��� �� ��������.",
				"���� ������ ���������, ������������ ���������� �������!�. ������ ������."};
	// ������� "������"
	String [] arrStand = {"�������� ���������: ������ ����� ����� ��������.",
				"����� ����� ���������� �� �� �������. ������ ����� ������������� ������ ��������� ����� ������.",
				"�������� ������� ��������� �� ������ ���, ����� ������ ���������� �� ��� �, ��� ����, ������.",
				"����������� ������ �� �������� � ������ �� �� ����������� �������."};
	// ������� "�� ���"
	String [] arrCome = {"�������� ���������: ��������� �� ���������� ���������� ����� �� ������, � ���� ������ ���������. � ������ �������� ����� �������� � ����������, ������� ����� ���������� ������ �� ���������� ���������� �����.",
				"������������� ������ ��������� � ������������ ���������� ��� ���!�. ���� ��������� ������� ������� � ����������, �� � ���� ������ �� ��������� ��.",
				"������ ��������� �� ����������, ������ ��� ������ � ������������ ������ �� �� ����������� �������.",  
				"����� ���������� ��������� ������� �� �������� � ���������� ������, ����� ���: �� ���-�� ����������,  ��������� �� ��� �� ������� ���������� ��� �� ����� ������� ������� � ������� �������� � ������. ��������� ������� � ������ ���������, �� ������� ��������� ������ � ����� ������, ����� ��� �����������."};
	// ������� "�����"
	String [] arrPlace = {"�������� � ����������. ����� ���������� ��������.",
				"������ ����� � ������� � ���������� �� ����� � ����� �� �������. �������� ����� ����� � �������� � ������ � ����� ���������. ����� �� ��������������, �� ������ � ������, ������ ��������� �� ������.",
				"������ ���� ������ ������� ������ � ��������� ������.",
				"������ ��������� � ���������, �������� �� �������, � ������� ���. � ���� ������ �������� ������� ������ ������� ���������. ������ ������ ������ �� ����������� �������."};
	//������� "��� ����"
	String [] arrGivePaw = {"�������� ���������: ������ ����� ����� ����.",
				"���������� ������� ���� ����. ��� ���� ����� ����� �������� ����������� �� ������� ������� �������� ���� ������ �� ����������� � ����.",
				"����������� ����������� ������� ���� ���� �� ��� ���, ���� ������ �� ������ ����.",
				"� ���� ������ �������� �� �� ���� � ���������."};
	//������� "�����" � ������� ����������
	String [] arrYipPlay = {"��������� � ������� � ����� (��� ������ ������� �� ������������ ������ �������).", 
		"� ������, ����� ������ ������� ������, ��������� ����� �� ��������� ����� � �����. ������� ��� ����� �������, �� ���, ����� ��� �� ������� �������.", 
		"�� ���������� ������ ������ �����. � ���� ������ ����������� ������� ������  � ����� �� ��������� ������, ��� ���������."};
	//������� "�����" � ������� ����������
	String [] arrYipFood = {"����� ������ ����� ��������� ������, �������� ���� � ����� � �������� ������.",
				"�������� ����� � ����, �� ����� ������ ������� ��� ������. ���������, ����� ������ ������, ������ ����. � ���� ������ ����������� ������� ������.",
				"��������� ������ � ����� �� ������ ����."};
	// ������� "�����"
	String [] arrNearby = {"�� �������� � ������� ������� ������� � ������ ����. ����� ����� ������������� ������� ���, ����� ������ ��� �����.",
				"���� ������ ������ ������� ������ ���, �� ����� ������� ������",
				"����� ����� ������� �� ������� ���, ����� ������  ��������� ����� � ����."};
	// ������ �������� ������ (����� ����������� � TrainingDescription � ����������� �� ��������� �������)
	Object[] strings = 
			{arrFu, arrSit, arrRest, arrStand, arrCome, 
			arrPlace, arrGivePaw, arrYipPlay, arrYipFood, arrNearby};	
	
	// ������� ����������� ��� ���� View ������
	public static String [] arrTraining = 
		{"��", "������", "������", "������", "�� ���",
		"�����", "��� ����", "����� (�������)", "����� (�������)", "�����"};
	// ������ �������� ��� ������� "��"
	int [] imgFu = 
		{R.drawable.jp400, R.drawable.play, R.drawable.jp400, R.drawable.play, R.drawable.jp400};
	// ������ �������� ��� ������� "������"
	int [] imgSit =
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// ������ �������� ��� ������� "������"
	int [] imgRest =
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play,  R.drawable.ic_launcher};
	// ������ �������� ��� ������� "������"
	int [] imgStand = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// ������ �������� ��� ������� "�� ���"
	int [] imgCome = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// ������ �������� ��� ������� "�����"
	int [] imgPlace = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// ������ �������� ��� ������� "��� ����"
	int [] imgGivePaw = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// ������ �������� ��� ������� "�����" � ������� ���������
	int [] imgYipPlay = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher};
	// ������ �������� ��� ������� "�����" � ������� ����������
	int [] imgYipFood = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher};
	// ������ �������� ��� ������� "�����"
	int [] imgNearby = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	
	Object [] image = 
		{imgFu, imgSit, imgRest, imgStand, imgCome,
		imgPlace, imgGivePaw, imgYipPlay, imgYipFood, imgNearby};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		ActionBar bar = getActionBar();
		bar.setDisplayShowTitleEnabled(true); // ���������� ����� ����� � ������� home
		bar.setDisplayShowHomeEnabled(true); // ���������� ������ ����������
		bar.setDisplayHomeAsUpEnabled(true); // ��������� ��������� �������� �� �������� �����
		bar.setTitle(R.string.training); // �������� ����������
		
		// ��������� ��� ����������� ������
		ArrayList <Map<String, Object>> content = 
				new ArrayList <Map<String, Object>> (arrTraining.length);
		
		for (int i = 0; i < arrTraining.length; i++) {
			// ������� ���������
			Map <String, Object> map = new HashMap <String, Object> ();
			map.put(KEY_TRAINING, arrTraining[i]); // ������� �������� �������
			map.put(KEY_IMAGE, R.drawable.play); // ������� ����������� �������
			content.add(map); // ���������� ��������� � ���������
		}
		// ������ ������ �� ������� ����� ����������� �������� ��������� � View
		String [] from = {KEY_TRAINING, KEY_IMAGE};
		// ������ View ����� ������ ������
		int [] to = {R.id.tvList, R.id.imgList};
		// �������� �������� ��� ������������ ������ �� ����������� ���������
		SimpleAdapter adapter = new SimpleAdapter 
				(this, content,R.layout.textview_for_list, from, to);
		
		// ����������� ListView ������� � ���������� ������� ������� ������
		list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	// ���������� ������� ������� ������
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		Intent intentDescription = new Intent (this, TrainingDescription.class);
		intentDescription.putExtra(TRAINING_NAME, arrTraining[position]);
		// ������� ������ ��������������� ��������� ������� � ��������� ��� �� Object � String[]
		String [] description = (String []) strings [position];
		intentDescription.putExtra(TRAINING_DESCRIPTION, description);
		// ������� ������ ��������, ��������������� ��������� ������� � ��������� ��� �� Object � int[]
		int [] imageSteps = (int []) image [position];
		intentDescription.putExtra(TRAINING_IMAGE, imageSteps);
		startActivity(intentDescription);
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
