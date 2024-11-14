package com.example.lesson_2_group_5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Класс MainActivity, наследник AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Метод onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        // Вызов родительского метода onCreate
        super.onCreate(savedInstanceState)
        // Игнорирование системных рамок телефона
        enableEdgeToEdge()
        // Определяет то, как будет выглядеть пользовательский интерфейс приложения
        // Содержит ссылку на файл разметки activity_main.xml
        setContentView(R.layout.activity_main)
        // Определяет рамки приложения
        // Нужно для того чтобы элементы пользовательского интерфейса не размещались за пределами экрана
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}