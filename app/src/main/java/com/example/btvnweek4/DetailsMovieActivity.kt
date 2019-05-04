package com.example.btvnweek4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        //toolbar
        setSupportActionBar(this.findViewById(R.id.toolbar))
        supportActionBar!!.title = "Details Movie"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getData()
    }

    private fun getData() {
        val data = intent.extras
        if (data != null) {

            val name = data.getString(MOVIE_TITLE_KEY)
            val backdrop = data.getString(MOVIE_BACKDROP_KEY)
            val release_Dates = data.getString(MOVIE_DATE_KEY)
            val video = data.getBoolean(MOVIE_VIDEO_KEY)
            val description = data.getString(MOVIE_DES_KEY)
            val vote = data.getDouble(MOVIE_VOTE_KEY)


            name_movie.text = name
            release_date.text = release_Dates
            overview.text = description
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/$backdrop")
                .centerCrop()
                .into(movie_view)
            if (video) {
                video_play.visibility = View.VISIBLE
            } else {
                video_play.visibility = View.INVISIBLE
            }
            vote_rating.rating = (vote / 2).toFloat()

        }
    }
}
