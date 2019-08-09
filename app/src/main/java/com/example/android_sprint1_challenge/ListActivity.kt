package com.example.android_sprint1_challenge

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class  ListActivity : AppCompatActivity() {

    var movieList = mutableListOf<Movie>()
    var couunter = 0

    companion object {
        const val ADD_MOVIE_CODE = 13
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add_movie.setOnClickListener {
            val intent = Intent(this, EditPage::class.java)
            startActivityForResult(intent ,ADD_MOVIE_CODE)
        }

        fun createTextView(movie: Movie, index: Int): TextView {
            val textView = TextView(this)
            textView.textSize = 18f
            textView.text = movie.title

            textView.setOnClickListener {
                val intent = Intent(this, EditPage::class.java)
                startActivityForResult(intent, ADD_MOVIE_CODE )
            }
            return textView

        }

        fun populateMovieList(index: Int) {
            ll_movie_list.removeAllViews()
            for (movie in movieList) {
                ll_movie_list.addView(createTextView(movie, index))
            }

            fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                if (requestCode == ADD_MOVIE_CODE && resultCode == Activity.RESULT_OK) {
                    val imageData = data?.getSerializableExtra(Movie.MOVIE_TAG) as Movie
                    movieList.add(imageData)
                    populateMovieList(movieList.size -1)
                }
            }

        }
    }




}

