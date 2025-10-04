package com.sample.tmdb.data.source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sample.tmdb.domain.model.TVShow

@Entity(tableName = "TVShows")
class TVShowEntity(
    @PrimaryKey val id: Int,
    val overview: String,
    val releaseDate: String?,
    val posterUrl: String?,
    val backdropUrl: String?,
    val name: String,
    val voteAverage: Double,
    val voteCount: Int,
)

fun List<TVShowEntity>.asDomainModel() = map(TVShowEntity::asDomainModel)

fun TVShow.asDatabaseModel(): TVShowEntity = TVShowEntity(
    id = id,
    overview = overview,
    releaseDate = releaseDate,
    posterUrl = posterUrl,
    backdropUrl = backdropUrl,
    name = name,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

private fun TVShowEntity.asDomainModel(): TVShow = TVShow(
    id = id,
    overview = overview,
    releaseDate = releaseDate,
    posterUrl = posterUrl,
    backdropUrl = backdropUrl,
    name = name,
    voteAverage = voteAverage,
    voteCount = voteCount,
)
