package com.example.module_2_lesson_3_hw_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

//      spinner using ArrayAdapter.createFromResource
        val staticAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.age_array,android.R.layout.simple_spinner_item)
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAge.adapter = staticAdapter

//        spinner using dynamic array
//        val nameArray: Array<String> = arrayOf("kek", "power","is","my","mind")
//        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, nameArray)
//        spAge.adapter = adapter

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
            resultIntent.putExtra(Enums.AGE,spAge.selectedItem.toString())
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }



    }
}