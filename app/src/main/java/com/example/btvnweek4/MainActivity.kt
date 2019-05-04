package com.example.btvnweek4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.btvnweek4.Moviemodel.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    var list_movie: ArrayList<Movie.Results> = ArrayList()
    lateinit var movieAdapter: MovieAdapter
    val MovieModel: Movie()
    val MOVIE_TITLE_KEY = "MOVIE_TITLE_KEY"
    val MOVIE_POSTER_KEY = "MOVIE_POSTER_KEY"
    val MOVIE_DES_KEY = "MOVIE_DES_KEY"
    val MOVIE_VOTE_KEY ="MOVIE_VOTE_KEY"
    val MOVIE_BACKDROP_KEY = "MOVIE_BACKDROP_KEY"
    val MOVIE_VIDEO_KEY ="MOVIE_VIDEO_KEY"
    val MOVIE_DATE_KEY = "MOVIE_DATE_KEY "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = "List Movie"
        //  them movie
        addMovie()

        //recyclerView
        listview.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(list_movie, this)
        listview.adapter =movieAdapter
        movieAdapter.setListenner(itemsClickListener)

    }
    private val itemsClickListener = object : ItemsClickListener {

        override fun onItemCLicked(position: Int) {

            val intent = Intent(this@MainActivity,DetailsMovieActivity::class.java)
            intent.putExtra(MOVIE_TITLE_KEY,list_movie[position].title)
            intent.putExtra(MOVIE_POSTER_KEY,list_movie[position].poster_path)
            intent.putExtra(MOVIE_DES_KEY,list_movie[position].overview)
            intent.putExtra(MOVIE_VIDEO_KEY,list_movie[position].video)
            intent.putExtra(MOVIE_BACKDROP_KEY,list_movie[position].backdrop_path)
            intent.putExtra(MOVIE_VOTE_KEY,list_movie[position].vote_average)
            intent.putExtra(MOVIE_DATE_KEY,list_movie[position].release_date)
            startActivity(intent)

        }
    }

    private fun addMovie() {
        for(i in MovieModel.getMovieModel().results){
            list_movie.add(i)
        }
    }
}
