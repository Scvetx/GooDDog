package ss.scvex.test21_testapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainTest21Activity extends ActionBarActivity implements OnClickListener {
	
	Button btnTraining;
	Button btnAccessories;
	TextView tvMarionn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_test21);
		
		ActionBar bar = getActionBar();
		bar.setDisplayShowTitleEnabled(false); // �������� ����� ����� � ������� home
		bar.setDisplayShowHomeEnabled(false); // �������� ������ ����������
		bar.hide(); // �������� Action Bar

		btnTraining = (Button) findViewById(R.id.btnTraining);
		btnTraining.setOnClickListener(this);
		btnAccessories = (Button) findViewById(R.id.btnAccessories);
		btnAccessories.setOnClickListener(this);
		
		animation();
	}

	// �������� ��������� ����������
	public void animation() {
		Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
		btnTraining.startAnimation(alpha);
		btnAccessories.startAnimation(alpha);
		
		tvMarionn = (TextView) findViewById(R.id.tvMarionn);
		Animation transate = AnimationUtils.loadAnimation(this, R.anim.translate);
		tvMarionn.startAnimation(transate);
		return;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent;
		
		switch (v.getId()) {
		case (R.id.btnTraining):
			intent = new Intent (this, Training.class);
			startActivity(intent);
		break;
		case (R.id.btnAccessories):
			intent = new Intent (this, Accessories.class);
			startActivity(intent);
		break;
		default: break;
		}
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
