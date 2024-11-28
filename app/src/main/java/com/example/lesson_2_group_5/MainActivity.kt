package com.example.lesson_2_group_5

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lesson_2_group_5.databinding.ActivityMainBinding

// Класс MainActivity, наследник AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Свойство, хранящее значение того было ли показано всплывающее сообщение
    private var showToast: Boolean = false

    // Метод, который будет вызываться при нажатии на кнопку через xml
    fun clickButton(view: View) {
        Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_LONG).show()
    }

    // Свойство, для использования библиотеки viewBinding
    private lateinit var activityMainBinding: ActivityMainBinding

    // Метод onCreate - запускается самым при старте активности, или после вызова onPause/onStop
    // Создает объекты пользовательского интерфейса перед показом пользователю
    override fun onCreate(savedInstanceState: Bundle?) {
        // Вызов родительского метода onCreate
        super.onCreate(savedInstanceState)

        // Инициализация свойства activityMainBinding
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        // Проврка существования Bundle хранилища
        if (savedInstanceState != null)
            showToast = savedInstanceState.getBoolean("SHOW_TOAST")

        // Игнорирование системных рамок телефона
        enableEdgeToEdge()

        // Определяет то, как будет выглядеть пользовательский интерфейс приложения
        // Содержит ссылку на файл разметки activity_main.xml
        // setContentView(R.layout.activity_main)

        // Аналог вызова setContentView для viewBinding
        setContentView(activityMainBinding.root)

        // Определяет рамки приложения
        // Нужно для того чтобы элементы пользовательского интерфейса не размещались за пределами экрана
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Логирование сообщений в лог
        /*
        Типы сообщений в логах:
        Verbose - полный протокол системных действий.
        Debug - отладочная информация: параметры,порождаемые в процессе работы приложения.
        Info - информационные сообщения.
        Warn - предупреждения.
        Error - ошибки, возникающие в процессе работы приложения.
        В протоколе выделяются красно-коричневым цветом, чтобы их было сразу заметно.
         */
        Log.i("Метод жизненного цикла", "onCreate")

        if (!showToast) {
            // Всплывающее сообщение
            Toast.makeText(this, "Привет пользователь!", Toast.LENGTH_LONG).show()
            showToast = true
        }

        // Создание объектов элементов пользовательского интерфейса
        val textView7: TextView = findViewById(R.id.textView7)
        val textView: TextView = findViewById(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)

        // Взаимодействие с объектами интерфейса

        // Изменение значение текста в текстовом поле
        textView7.text = "New text in onCreate() method!"
        textView.setText("My new text in onCreate() method!")

        // Обработка нажатий на кнопку
        // Слушатель нажатий однократный
        button.setOnClickListener {
            button.text = "Click!"
        }

        // Слушатель нажатий, который срабатывает при удержании
        button.setOnLongClickListener {
            button.text = "Long click!"
            return@setOnLongClickListener true
        }

        // Слушатель нажатий на тексте
        textView7.setOnClickListener {
            textView7.text = "Click!"
        }

        // Смена изображения в картинке
        imageView.setImageResource(R.drawable.ic_launcher_background)

        // Взаимодействие с элементами интерфейса при помощи viewBinding
        // Смена текста в поле для ввода текста
        activityMainBinding.editTextText.setText("New text in EditText")

        // Работа со Switch
        activityMainBinding.switch1.setOnClickListener {
            if (activityMainBinding.switch1.isChecked) {
                activityMainBinding.switch1.isChecked = true
                activityMainBinding.switch1.text = "ВКЛ"
            } else {
                activityMainBinding.switch1.isChecked = false
                activityMainBinding.switch1.text = "ВЫКЛ"
            }
        }

        // Работа с floatingActionButton
        activityMainBinding.floatingActionButton.setOnClickListener {
            activityMainBinding.textView7.text =
                activityMainBinding.editTextNumberPassword.text.toString()
        }

        // Работа со Spinner
        // Создание адаптера, содержащего список
        val spinnerAdapter = ArrayAdapter(
            this,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
            listOf("PHP", "Kotlin", "Java", "Python")
        )
        // Передача созданного адаптера в выпадающий список
        activityMainBinding.spinner.adapter = spinnerAdapter
    }

    // Метод onStart - запускается после onCreate
    // Подготавливает пользовательский интерфейс к показу пользователю
    override fun onStart() {
        super.onStart()
        Log.v("Метод жизненного цикла", "onStart")
    }

    // Метод onResume - запускается после onStart/onPause
    // Демонстрирует пользователю интерфейс активности
    // После его вызова пользоваьтель может взаимодействовать с интерфейсом
    override fun onResume() {
        super.onResume()
        Log.e("Метод жизненного цикла", "onResume")
    }

    // Метод onPause - запускается после onResume
    // Готовит активность к переходу в "спящий режим", возобновлению работы или перезагрузке
    override fun onPause() {
        super.onPause()
        Log.w("Метод жизненного цикла", "onPause")
    }

    // Метод onStop - запускается после onPause
    // Переводит активность в "спящий режим" и готовить к  возобновлению работы или уничтожению
    override fun onStop() {
        super.onStop()
        Log.d("Метод жизненного цикла", "onStop")
    }

    // Метод onRestart - запускается после onStop
    // Перезагружает пользовательский интерфейс, но не создает его заново
    override fun onRestart() {
        super.onRestart()
        Log.d("Метод жизненного цикла", "onRestart")
    }

    // Метод onDestroy - запускается после onStop
    // Вызывается перед уничтожением активности после завершения ее работы
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Метод жизненного цикла", "onDestroy")
    }

    // Метод onSaveInstanceState - вызывается для записи значений в Bundle хранилище
    // перед перезапуском активности
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Запись значения showToast в Bundle хранилище
        outState.putBoolean("SHOW_TOAST", showToast)
    }
}