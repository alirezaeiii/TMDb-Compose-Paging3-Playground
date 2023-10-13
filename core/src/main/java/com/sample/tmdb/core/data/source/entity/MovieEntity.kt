package com.sample.tmdb.core.data.source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sample.tmdb.core.domain.model.Movie

@Entity(tableName = "Movies")
class MovieEntity(
    @PrimaryKey val id: Int,
    val overview: String,
    val releaseDate: String?,
    val posterUrl: String?,
    val backdropUrl: String?,
    val name: String,
    val voteAverage: Double,
    val voteCount: Int
)

fun List<MovieEntity>.asDomainModel(): List<Movie> = map {
    Movie(
        id = it.id,
        overview = it.overview,
        releaseDate = it.releaseDate,
        posterUrl = it.posterUrl,
        backdropUrl = it.backdropUrl,
        name = it.name,
        voteAverage = it.voteAverage,
        voteCount = it.voteCount
    )
}