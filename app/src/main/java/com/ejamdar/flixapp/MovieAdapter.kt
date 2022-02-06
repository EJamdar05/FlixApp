package com.ejamdar.flixapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

private const val TAG = "MovieAdapter"
 const val MOVIE_EXTRA = "MOVIE_EXTRA"
class MovieAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    //expensive op
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }
    //cheaper to bind data to existing view holder increasing performance
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder $position")
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvOverview = itemView.findViewById<TextView>(R.id.tvOver)
        private val tvPoster = itemView.findViewById<ImageView>(R.id.tvPoster)

        init{
            itemView.setOnClickListener(this)
        }
        fun bind(movie: Movie){ //logic of click listener
            tvTitle.text = movie.title
            tvOverview.text = movie.overview
            //Glide.with(context).load(movie.baseURL).into(tvPoster)
            val radius = 30; // corner radius, higher value = more rounded
            val margin = 10; // crop margin, set to 0 for corners with no crop
            Glide.with(context)
                .load(movie.baseURL)
                .transform(RoundedCornersTransformation(radius, margin))
                .into(tvPoster)

        }

        override fun onClick(p0: View?) {
            //notify movie tapped on
            val selectedMovie = movies[adapterPosition]
            //intent sys to switch to new scene
            val intent = Intent(context, MovieDetails::class.java)
            intent.putExtra(MOVIE_EXTRA, selectedMovie) //passing entire object
            context.startActivity(intent)

        }
    }

}
