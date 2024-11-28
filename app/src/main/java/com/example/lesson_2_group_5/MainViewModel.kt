package com.example.lesson_2_group_5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Класс MainViewModel, наследник системного класса ViewModel
// Имеет доступ к жизненному циклу ViewModel
class MainViewModel : ViewModel() {
    // Свойство, которое имеет тип данных MutableLiveData
    private var editText = MutableLiveData<String>()

    fun getEditText(): MutableLiveData<String> = editText
}