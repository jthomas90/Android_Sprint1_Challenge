package com.example.android_sprint1_challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ADD_MOVIE_CODE = 13
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add_movie.setOnClickListener {
            val intent = Intent(this, EditPage::class.java)
            startActivityForResult(intent, ADD_MOVIE_CODE)
        }
    }


}

