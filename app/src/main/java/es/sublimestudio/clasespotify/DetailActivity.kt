package es.sublimestudio.clasespotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.sublimestudio.clasespotify.adapters.SongsAdapter

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = DataHolder.currentPlaylist.title

        val songsRecycler = findViewById<RecyclerView>(R.id.songsRecycler)
        val songsAdapter = SongsAdapter(DataHolder.currentPlaylist.songs)

        songsRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        songsRecycler.adapter = songsAdapter
    }
}