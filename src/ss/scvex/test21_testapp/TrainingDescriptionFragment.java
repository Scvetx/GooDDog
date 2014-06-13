package ss.scvex.test21_testapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TrainingDescriptionFragment extends Fragment {
	
	String str = ""; // описание команды
	int image = 0; // картинка к описанию
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);	
	}
	
	// создание view для фрагмента
	public View onCreateView 
	(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.training_description_fragment, container, false);
		
		TextView tvTrainingName = (TextView) view.findViewById(R.id.tvTrainingName);
		tvTrainingName.setText(str);
		
		ImageView imgTraining = (ImageView) view.findViewById(R.id.imgTraining);
		imgTraining.setImageResource(image);
		
		return view;
	}
	
	// заполняет фрагмент контентом
	public void setFragmentContent (String str, int image) {
		this.str = str;
		this.image = image;
	}
}
