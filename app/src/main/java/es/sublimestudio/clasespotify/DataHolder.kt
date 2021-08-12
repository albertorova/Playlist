package es.sublimestudio.clasespotify

import es.sublimestudio.clasespotify.models.Playlist
import es.sublimestudio.clasespotify.models.Song

object DataHolder {
    var playlists: ArrayList<Playlist> = arrayListOf()
    var songs: ArrayList<Song> = arrayListOf()

    lateinit var currentPlaylist: Playlist
}