package com.example.android_sprint1_challenge

import java.io.Serializable

class Movie (string: String? = null, var title:String) :Serializable{

    companion object {
        const val MOVIE_TAG = "movie"

    }



}
//needs a boolean val