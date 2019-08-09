package com.example.android_sprint1_challenge

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_page2.*
import java.io.Serializable

class EditPage : AppCompatActivity() {
    companion object {
        const val MOVIE_REQUEST_CODE = 12
    }

        private var movieData = Movie()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_page2)

            val extra = intent.getSerializableExtra(Movie.MOVIE_TAG)
            if (extra != null) {
                movieData = extra as Movie
                btn_edit_movie.setText(movieData.title)
            }

            save_button.setOnClickListener {
                movieData.title = btn_edit_movie.text.toString()
                val intent = Intent()
                intent.putExtra(Movie.MOVIE_TAG, movieData)
                setResult(Activity.RESULT_OK , intent)
                finish()
            }

        }













    }

