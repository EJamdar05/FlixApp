package com.ejamdar.flixapp

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import org.json.JSONArray

@Parcelize
data class Movie (
    val movieID: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
    val rating:Double,
): Parcelable{
    @IgnoredOnParcel
    val baseURL = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie>{
            val movies  = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview"),
                        movieJson.getDouble("vote_average")
                    )
                )
            }
            return movies
        }
    }
}