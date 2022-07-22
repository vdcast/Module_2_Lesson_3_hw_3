package com.example.module_2_lesson_3_hw_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val correctLogin = "vdcast"
        val correctPassword = "1234"

        clProfilePage.visibility = View.GONE

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

        btEditProfile.setOnClickListener {
            val intent = Intent(this,EditProfileActivity::class.java)
            resultLauncher.launch(intent)
        }

    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data: Intent? = result.data
            if (data?.getStringExtra(Enums.NAME) == "") else tvName.text = data?.getStringExtra(Enums.NAME)
            if (data?.getStringExtra(Enums.LASTNAME) == "") else tvLastName.text = data?.getStringExtra(Enums.LASTNAME)
            if (data?.getStringExtra(Enums.USERNAME) == "@") else tvUserName.text = data?.getStringExtra(Enums.USERNAME)

        }
    }


    // old method
//    btEditProfile.setOnClickListener {
//        val intent = Intent(this,EditProfileActivity::class.java)
//        startActivityForResult(intent,1)
//
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1){
//            tvName.text = data?.getStringExtra(Enums.NAME)
//            tvLastName.text = data?.getStringExtra(Enums.LASTNAME)
//            tvUserName.text = data?.getStringExtra(Enums.USERNAME)
//        }
//    }

}
