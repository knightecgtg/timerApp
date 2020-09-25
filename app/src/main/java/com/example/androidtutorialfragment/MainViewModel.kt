package com.example.androidtutorialfragment

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {

    private lateinit var timer: CountDownTimer
    var finished=MutableLiveData<Boolean>()
    var isTimerRunning=MutableLiveData<Boolean>()
    var timervalue = MutableLiveData<Long>()
    private val _seconds = MutableLiveData<Int>()
    val sec: LiveData<Int>
        get() = _seconds

    fun startTimer(){
        timer = object : CountDownTimer(timervalue.value!!.toLong(), 1000){
            override fun onFinish() {
                          finished.value = true
            }
            override fun onTick(p0: Long) {
                var timeLeft = p0/1000
                _seconds.value = timeLeft.toInt()
                isTimerRunning.value = true
            }

        }.start()
    }

    fun stopTimer(){
        if(isTimerRunning.value == true){
                    timer!!.cancel()
        }

    }
}