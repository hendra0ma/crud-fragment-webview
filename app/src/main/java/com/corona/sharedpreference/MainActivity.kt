package com.corona.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences : SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        save.setOnClickListener(View.OnClickListener {
            val id:Int = Integer.parseInt(editId.text.toString())
            val name:String = editName.text.toString()
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putInt("id_key",id)
            editor.putString("name_key",name)
            editor.apply()
            editor.commit()
        })
        view.setOnClickListener {
            val sharedIdValue = sharedPreferences.getInt("id_key",0)
            val sharedNameValue = sharedPreferences.getString("name_key","defaultname")
            if(sharedIdValue.equals(0) && sharedNameValue.equals("defaultname")){
                textShowName.setText("default name: ${sharedNameValue}").toString()
                textShowId.setText("default id: ${sharedIdValue}").toString()
            }else{
                textShowName.setText(sharedNameValue).toString()
                textShowId.setText(sharedIdValue.toString())
            }

        }
        clear.setOnClickListener(View.OnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            textShowName.setText("").toString()
            textShowId.setText("").toString()
        })
    }
}
