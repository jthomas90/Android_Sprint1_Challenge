package ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_sprint1_challenge.R
import kotlinx.android.synthetic.main.activity_page2.*
import model.Movie

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

            btn_delete_button.setOnClickListener {

            }

            btn_switch1.setOnClickListener {
                if (btn_switch1.isChecked) {
                    //btn_edit_movie.text.toString().Paint.STRIKE_THRU_TEXT_FLAG);
                }else{


                }
            }

        }



    //add delete button

    //











    }

