package ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_sprint1_challenge.R
import kotlinx.android.synthetic.main.activity_page2.*
import model.Movie

class EditPage : AppCompatActivity() {

        private var movieData = Movie()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_page2)

            var bundle: Bundle? = intent.extras
            if (bundle != null) {
                loadMovie(bundle!!.getSerializable("TVMOVIE") as Movie)
            }

            save_button.setOnClickListener {
                val intentSave = Intent()
                intentSave.putExtra("MOVIE", createMovie())
                setResult(Activity.RESULT_OK , intentSave)
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


    fun loadMovie(movie: Movie) {
        et_edit_movie.setText(movie.title)
    }

    fun createMovie(): Movie {
        var newBook = Movie(et_edit_movie.text.toString())
        return newBook
    }



    //add delete button

    //











    }

