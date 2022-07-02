package com.example.module_2_lesson_3_hw_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val correctLogin = "vdcast"
        val correctPassword = "1234"

        btLogin.setOnClickListener {
            if (etLogin.text.toString() == correctLogin){
                if (etPassword.text.toString() == correctPassword){
                    tvAlert.visibility = View.GONE

                    clLoginPage.visibility = View.GONE
                    clProfilePage.visibility = View.VISIBLE

                }else{
                    tvAlert.visibility = View.VISIBLE
                    tvAlert.text = "Wrong password"
                }
            }else{
                tvAlert.visibility = View.VISIBLE
                tvAlert.text = "No user found, check login (username)"
            }



        }

    }



}
