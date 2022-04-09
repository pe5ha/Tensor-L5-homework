package com.pe5ha.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // только если это создание фрагмента впервые, а не восстановление
        if(savedInstanceState==null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_activity, SenderFragment(), "SenderFragmentTag")
                .commit()
        }
    }

}