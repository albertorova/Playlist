package es.sublimestudio.clasespotify.models

data class Playlist(
    var title: String,
    var image: String,
    var followers: Int,
    var songs: ArrayList<Song> = arrayListOf()
)
