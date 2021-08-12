package es.sublimestudio.clasespotify.models

data class Song(
    var title: String,
    var image: String,
    var singer: String,
    var playlist: ArrayList<String>
)