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
	// статические переменные соответствующие номеру элемента массива каждой команды
	
	public static final String TRAINING_NAME = "name";
	public static final String TRAINING_DESCRIPTION = "description";
	public static final String TRAINING_IMAGE = "image";
	
	//  key для ArrayList
	private static final String KEY_TRAINING = "training";
	private static final String KEY_IMAGE = "image";
	
	TextView tvTop;
	ListView list;
	
	// команда "фу"
	String [] arrFu = {"Исходное положение: собака сидит перед Вами. Левой рукой коротко удерживаем поводок. В правой руке держим лакомство.",
				"На полностью открытой ладони подносим лакомство к носу собаки так, чтобы ей захотелось съесть  его.",
				"Как только собака потянулась к лакомству, зажимаем его в кулак и кулаком слегка отталкиваем морду собаки. Одновременно произносим «фу!». Так повторяем несколько раз до тех пор, пока собака не потеряет интерес к лакомству. Левой рукой не забываем держать коротко поводок, чтобы собака в этот момент не убежала от Вас.",
				"Как только собака на несколько секунд потеряла интерес к лакомству, прячем лакомство за спину и хвалим собаку.",
				"Затем достаем руку с лакомством из-за спины. На открытой ладони по команде «на!» даем собаке его съесть."};
	// команда "сидеть"
	String [] arrSit = {"Исходное положение: собака стоит перед Вами. У Вас в правой руке лакомство.",
				"Возьмитесь рукой за ошейник. Правой рукой перед носом собаки демонстрируем лакомство, не позволяя его съесть.",
				"Медленно поднимая руку с лакомством вверх, другой рукой медленно тянем собаку за ошейник по направлению к себе и вверх. При этом собака не должна потерять интереса к лакомству. Для этого не отводим кусочек далеко от морды. При этих манипуляциях собака сядет.",
				"Произносим команду «сидеть!»  и одновременно даем собаке лакомство. Хвалим питомца."};
	// команда "лежать"
	String [] arrRest = {"Исходное положение: собака сидит слева от Вас. В правой руке Вы держите лакомство.",
				"Левую руку кладем на спину собаки, не давая собаке вставать. Правой рукой перед носом собаки демонстрируем  лакомство, не позволяя его съесть.",
				"Удерживая собаку рукой в сидячем положении, правой рукой медленно опускаем лакомство вниз. Собака при этом должна потянуться за кусочком, тем самым наклонив голову к земле.",
				"Не останавливаясь, уводим лакомство от собаки не отрывая от земли. Собака при этом тянется за лакомством и переходит в лежачее положение.  Левую руку держите на спине собаки, чтобы она не вставала.",
				"Даем собаке лакомство, одновременно произносим «лежать!». Хвалим собаку."};
	// команда "стоять"
	String [] arrStand = {"Исходное положение: собака сидит перед хозяином.",
				"Одной рукой удерживаем ее за ошейник. Другой рукой демонстрируем собаке лакомство перед мордой.",
				"Медленно отводим лакомство от собаки так, чтобы собака потянулась за ним и, при этом, встала.",
				"Поглаживаем собаку по животику и хвалим ее за выполненную команду."};
	// команда "ко мне"
	String [] arrCome = {"Исходное положение: находимся на расстоянии нескольких шагов от собаки, в руке держим лакомство. В начале обучения можно работать с помощником, который будет удерживать собаку на расстоянии нескольких шагов.",
				"Демонстрируем собаке лакомство и одновременно произносим «Ко мне!». Если отработка команды ведется с помощником, то в этот момент он отпускает ее.",
				"Собака подбегает за лакомством, отдаем его собаке и одновременно хвалим ее за выполненную команду.",  
				"Затем переносите отработку команды на прогулку и подзывайте собаку, когда она: на что-то отвлеклась,  находится от Вас на большом расстоянии или во время общения питомца с другими собаками и людьми. Отработав команду в данных ситуациях, Вы сможете подзывать собаку в любой момент, когда это потребуется."};
	// команда "место"
	String [] arrPlace = {"Работаем с помощником. Место обозначаем ковриком.",
				"Хозяин стоит с собакой и удерживает ее рядом с собой на поводке. Помощник стоит рядом с ковриком и держит в руках лакомство. Затем он демонстративно, на глазах у собаки, кладет лакомство на коврик.",
				"Хозяин дает собаке команду «место» и отпускает собаку.",
				"Собака подбегает к лакомству, лежащему на коврике, и съедает его. В этот момент помощник придает собаке лежачее положение. Хозяин хвалит собаку за выполненную команду."};
	//команда "дай лапу"
	String [] arrGivePaw = {"Исходное положение: собака сидит перед Вами.",
				"Произносим команду «дай лапу». При этом одной рукой легонько постукиваем по нижнему суставу передней лапы собаки по направлению к себе.",
				"Продолжайте произносить команду «дай лапу» до тех пор, пока собака не согнет лапу.",
				"В этот момент возьмите ее за лапу и похвалите."};
	//команда "голос" с игровой мотивацией
	String [] arrYipPlay = {"Поиграйте с собакой в мячик (или другую игрушку по предпочтению вашего питомца).", 
		"В момент, когда собака активно играет, задержите мячик на некоторое время в руках. Держите его перед собакой, но так, чтобы она не достала игрушку.", 
		"От нетерпения собака начнет лаять. В этот момент произнесите команду «голос»  и сразу же похвалите собаку, дав лакомство."};
	//команда "голос" с пищевой мотивацией
	String [] arrYipFood = {"Когда придет время кормления собаки, насыпьте корм в миску и позовите собаку.",
				"Возьмите миску в руки, не давая вашему питомцу его съесть. Дождитесь, когда собака залает, требуя корм. В этот момент произнесите команду «голос».",
				"Похвалите собаку и дайте ей съесть корм."};
	// команда "рядом"
	String [] arrNearby = {"На прогулке с собакой держите поводок в правой руке. Левой рукой придерживайте поводок так, чтобы собака шла слева.",
				"Если собака начала убегать вперед Вас, то дайте команду «рядом»",
				"Левой рукой дерните за поводок так, чтобы собака  оказалась рядом с Вами."};
	// массив описаний команд (будет передаватся в TrainingDescription в зависимости от выбранной команды)
	Object[] strings = 
			{arrFu, arrSit, arrRest, arrStand, arrCome, 
			arrPlace, arrGivePaw, arrYipPlay, arrYipFood, arrNearby};	
	
	// массивы содержимого для двух View списка
	public static String [] arrTraining = 
		{"Фу", "Сидеть", "Лежать", "Стоять", "Ко мне",
		"Место", "Дай лапу", "Голос (игровая)", "Голос (пищевая)", "Рядом"};
	// Массив картинок для команды "фу"
	int [] imgFu = 
		{R.drawable.jp400, R.drawable.play, R.drawable.jp400, R.drawable.play, R.drawable.jp400};
	// Массив картинок для команды "сидеть"
	int [] imgSit =
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// Массив картинок для команды "лежать"
	int [] imgRest =
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play,  R.drawable.ic_launcher};
	// массив картинок для команды "стоять"
	int [] imgStand = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// Массив картинок для команды "ко мне"
	int [] imgCome = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// Массив картинок для команды "место"
	int [] imgPlace = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// Массив картинок для команды "дфй лапу"
	int [] imgGivePaw = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	// Массив картинок для команды "голос" с игровой мотиваией
	int [] imgYipPlay = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher};
	// Массив картинок для команды "голос" с пищевой мотивацией
	int [] imgYipFood = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher};
	// Массив картинок для команды "рядом"
	int [] imgNearby = 
		{R.drawable.ic_launcher, R.drawable.play, R.drawable.ic_launcher, R.drawable.play};
	
	Object [] image = 
		{imgFu, imgSit, imgRest, imgStand, imgCome,
		imgPlace, imgGivePaw, imgYipPlay, imgYipFood, imgNearby};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		ActionBar bar = getActionBar();
		bar.setDisplayShowTitleEnabled(true); // показывает текст рядом с кнопкой home
		bar.setDisplayShowHomeEnabled(true); // показывает иконку приложения
		bar.setDisplayHomeAsUpEnabled(true); // добавляет стрелочку возврата на активити вверх
		bar.setTitle(R.string.training); // название активности
		
		// коллекция для содержимого списка
		ArrayList <Map<String, Object>> content = 
				new ArrayList <Map<String, Object>> (arrTraining.length);
		
		for (int i = 0; i < arrTraining.length; i++) {
			// элемент коллекции
			Map <String, Object> map = new HashMap <String, Object> ();
			map.put(KEY_TRAINING, arrTraining[i]); // элемент названия команды
			map.put(KEY_IMAGE, R.drawable.play); // элемент изображение команды
			content.add(map); // добавление элементов в коллекцию
		}
		// массив ключей по которым будут добавляться элементы коллекции в View
		String [] from = {KEY_TRAINING, KEY_IMAGE};
		// массив View одной строки списка
		int [] to = {R.id.tvList, R.id.imgList};
		// создание адаптера для формирования списка из содержимого коллекции
		SimpleAdapter adapter = new SimpleAdapter 
				(this, content,R.layout.textview_for_list, from, to);
		
		// присваиваем ListView адаптер и обработчик нажатий пунктов списка
		list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	// обработчик нажатий пунктов списка
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		Intent intentDescription = new Intent (this, TrainingDescription.class);
		intentDescription.putExtra(TRAINING_NAME, arrTraining[position]);
		// находим массив соответствующий выбранной команде и переводим его из Object в String[]
		String [] description = (String []) strings [position];
		intentDescription.putExtra(TRAINING_DESCRIPTION, description);
		// находим массив картинок, соответствующий выбранной команде и переводим его из Object в int[]
		int [] imageSteps = (int []) image [position];
		intentDescription.putExtra(TRAINING_IMAGE, imageSteps);
		startActivity(intentDescription);
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
