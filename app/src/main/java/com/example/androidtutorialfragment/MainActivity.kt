package com.example.androidtutorialfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.sec.observe(this, Observer{
            timerText.text = it.toString()
        })
        startTimer.setOnClickListener {
            if(editTextNumber.text.isEmpty()|| editTextNumber.text.length < 4){
                Toast.makeText(this, "Value invalid",Toast.LENGTH_LONG ).show()
            }else{
                vm.timervalue.value = editTextNumber.text.toString().toLong()
                vm.startTimer()
            }

        }
        stopTimer.setOnClickListener {
            timerText.text = "0"
            vm.stopTimer()
        }

        vm.finished.observe(this, Observer {
            if(it){
                Toast.makeText(this, "Finished",Toast.LENGTH_LONG ).show()
            }
        })
    }
}