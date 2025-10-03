package com.sample.tmdb.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkTMDbWrapper<T : TMDbItemResponse>(
    @Json(name = "results")
    val items: List<T>,
)

@JsonClass(generateAdapter = true)
data class NetworkCreditWrapper(
    @Json(name = "cast")
    val cast: List<CastResponse>,
    @Json(name = "crew")
    val crew: List<CrewResponse>,
)
