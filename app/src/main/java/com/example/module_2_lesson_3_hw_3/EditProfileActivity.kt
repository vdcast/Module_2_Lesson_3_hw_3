package com.example.module_2_lesson_3_hw_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        btSave.setOnClickListener {
            val resultIntent = Intent(this, MainActivity::class.java)
            if (etEditName.text.toString() !== ""){
                val name = etEditName.text.toString()
                resultIntent.putExtra(Enums.NAME,name)
            }
            if (etEditLastName.text.toString() !== ""){
                val lastName = etEditLastName.text.toString()
                resultIntent.putExtra(Enums.LASTNAME,lastName)
            }
            if (etEditUserName.text.toString() !== ""){
                val userName = "@" + etEditUserName.text.toString()
                resultIntent.putExtra(Enums.USERNAME,userName)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }



    }
}