package ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_sprint1_challenge.R
import kotlinx.android.synthetic.main.activity_main.*
import model.Movie


class  ListActivity : AppCompatActivity() {

    var movieList = mutableListOf<Movie>()
    var counter = 0

    companion object {
        const val REQUEST_CODE_EDIT_MOVIE = 13
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add_movie.setOnClickListener {
            val intent = Intent(this, EditPage::class.java)
            startActivityForResult(intent , REQUEST_CODE_EDIT_MOVIE)
        }

    }

    fun createTextView(movie: Movie, index: Int): TextView {
        var newMovieView = TextView(this)
        newMovieView.textSize = 18f
        newMovieView.id = index
        newMovieView.text = movie.title

        newMovieView.setOnClickListener {
            val textViewIntent = Intent(this, EditPage::class.java)
            textViewIntent.putExtra("movieKey", movieList[newMovieView.id])   //key value pair - key is a password //newMovieView.id will increase and match index
            movieList.removeAt(newMovieView.id)  // remove book from list
            startActivityForResult(textViewIntent, REQUEST_CODE_EDIT_MOVIE)
        }
        return newMovieView

    }

    fun populateMovieList(index: Int) {
        ll_movie_list.removeAllViews()
        for (movie in movieList) {
            ll_movie_list.addView(createTextView(movie, index))
        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if (requestCode == REQUEST_CODE_EDIT_MOVIE && resultCode == Activity.RESULT_OK) {
                val imageData = data?.getSerializableExtra(Movie.MOVIE_TAG) as Movie
                movieList.add(imageData)
                populateMovieList(movieList.size -1)
            }
        }

    }

    //seperate functions
    //onactivity result

    //onbackpressed




}

