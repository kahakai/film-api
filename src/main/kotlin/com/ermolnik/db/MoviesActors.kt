package com.ermolnik.db

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object MoviesActors : Table("movies_actors") {
    val movieID = reference("movie_id", Movies.id, onDelete = ReferenceOption.CASCADE)
    val actorID = reference("actor_id", Actors.id, onDelete = ReferenceOption.CASCADE)

    init {
        index(columns = arrayOf(movieID))
        uniqueIndex(actorID, movieID)
    }
}