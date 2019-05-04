package com.example.btvnweek4

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.btvnweek4.Moviemodel.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(var items: ArrayList<Movie.Results>,val context: Context) : RecyclerView.Adapter<MovieViewHolder>() {
lateinit var itemsClickListener: ItemsClickListener
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie,p0,false))
    }

       override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.name.text = items[position].title
        holder.movie_content.text =items[position].overview
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500/"+ items[position].poster_path)
            .into(holder.image)
        holder.item.setOnClickListener{
            itemsClickListener.onItemCLicked(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun setListenner(listener: ItemsClickListener){
        this.itemsClickListener = listener
    }


}
class MovieViewHolder( view: View): RecyclerView.ViewHolder(view){
    var image = view.poster
    var name = view.name
    var movie_content = view.movie_content
    var item = view.item

}