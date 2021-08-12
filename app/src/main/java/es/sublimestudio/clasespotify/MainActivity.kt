package es.sublimestudio.clasespotify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.sublimestudio.clasespotify.adapters.PlayListAdapter
import es.sublimestudio.clasespotify.models.Playlist
import es.sublimestudio.clasespotify.models.Song

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Playlist populares"

        initPlaylists()
        initSongs()

        val mAdapter = PlayListAdapter(DataHolder.playlists) { myPlayList ->
            DataHolder.currentPlaylist = myPlayList
            startActivity(Intent(this, DetailActivity::class.java))
        }

        val recycler = findViewById<RecyclerView>(R.id.mainRecyclerView)
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.adapter = mAdapter

    }


    fun initPlaylists() {
        val p1 = Playlist(
            "Éxitos España",
            "https://i.scdn.co/image/ab67706f00000003dda80385c36745d8c07781ce",
            2135132
        )
        val p2 = Playlist(
            "Pop con Ñ",
            "https://i.scdn.co/image/ab67706f0000000346057d87eeac15729ec2a402",
            725360
        )
        val p3 = Playlist(
            "Pop Clásico",
            "https://i.scdn.co/image/ab67706f00000003290e718ef591b0701d355f46",
            234422
        )
        val p4 = Playlist(
            "Today's Top Hits",
            "https://i.pinimg.com/originals/3d/33/30/3d33307bc1f35dfb7f5d61b4b6a54e2d.jpg",
            26195307
        )
        val p5 = Playlist(
            "Pop Internacional",
            "https://i.pinimg.com/736x/5b/97/45/5b97457c60e1d4ae05e76eee86945985.jpg",
            652349
        )
        val p6 = Playlist(
            "Flamenco Pop",
            "https://i.scdn.co/image/ab67706c0000bebb2ded7839d36d7d9b8877f0d2",
            486217
        )

        DataHolder.playlists.addAll(arrayListOf(p1, p2, p3, p4, p5, p6))
    }

    fun initSongs() {
        val s1 = Song(
            "La Historia",
            "https://i.scdn.co/image/ab67616d0000b27358bdba216d277f9a2e201bf5",
            "El Taiger, DJ Conds",
            arrayListOf("Éxitos España")
        )
        val s2 = Song(
            "Pareja Del Año",
            "https://img.europapress.es/fotoweb/fotonoticia_20210425122536_420.jpg",
            "Sebastian Yatra, Myke Towers",
            arrayListOf("Éxitos España", "Pop con Ñ")
        )
        val s3 = Song(
            "Tiroteo - Remix",
            "https://tastethefloor.es/wp-content/uploads/2021/04/tiroteo-portada-REMIXpk.png",
            "Marc Seguí, Rauw Alejandro, Pol Granch",
            arrayListOf("Éxitos España", "Pop con Ñ")
        )
        val s4 = Song(
            "Anda Suelta",
            "https://i1.sndcdn.com/artworks-SJWZqipvIhzK-0-t500x500.jpg",
            "Chema Rivas, Juan Magán",
            arrayListOf("Éxitos España", "Pop con Ñ")
        )
        val s5 = Song(
            "Flamenco y Bachata",
            "https://i1.sndcdn.com/artworks-JcuyGNMB4MdZ-0-t500x500.jpg",
            "Daviles de Novelda",
            arrayListOf("Éxitos España")
        )
        val s6 = Song(
            "Vida de Rico",
            "https://images-eu.ssl-images-amazon.com/images/I/61UMLkh0W-L._AC_UL600_SR600,600_.jpg",
            "Camilo",
            arrayListOf("Pop con Ñ")
        )
        val s7 = Song(
            "Fuego",
            "https://cdn.smehost.net/estopacom-mendivilprod/wp-content/uploads/2019/05/portada_single.jpg",
            "Estopa",
            arrayListOf("Pop Clásico")
        )
        val s8 = Song(
            "Butter",
            "https://studiosol-a.akamaihd.net/uploadfile/letras/albuns/8/4/f/9/1082081621605417.jpg",
            "BTS",
            arrayListOf("Today's Top Hits")
        )
        val s9 = Song(
            "Shape of You",
            "https://1.bp.blogspot.com/-7SS1QRb7Qvw/WKjl_46PXcI/AAAAAAAASRM/HUALukyLrEgm9GFzwvIFLF2SfsJfKlLAgCLcB/s1600/DivideCover.jpg",
            "Ed Sheeran",
            arrayListOf("Pop Internacional")
        )
        val s10 = Song(
            "Tu Calorro",
            "https://rocksesion.files.wordpress.com/2015/10/118-estopa.jpg",
            "Estopa",
            arrayListOf("Flamenco Pop")
        )
        DataHolder.songs.addAll(arrayListOf(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10))
        DataHolder.playlists.forEach { playlist ->
            DataHolder.songs.forEach { song ->
                song.playlist.forEach { songPlaylist ->
                    if (songPlaylist == playlist.title) {
                        playlist.songs.add(song)
                    }
                }
            }
        }
    }
}