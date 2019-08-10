package model

import java.io.Serializable

class Movie(switch: String = null, var title:String = "") : Serializable{

    companion object {
        const val MOVIE_TAG = "movie"

    }




}
//needs a boolean val mo vie watched or not