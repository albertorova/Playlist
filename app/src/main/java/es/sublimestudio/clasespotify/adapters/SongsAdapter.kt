package es.sublimestudio.clasespotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import es.sublimestudio.clasespotify.R
import es.sublimestudio.clasespotify.models.Song

class SongsAdapter(private val allSongs: ArrayList<Song>) : RecyclerView.Adapter<SongsAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val song = allSongs[position]

        holder.bindItems(song)
    }

    override fun getItemCount(): Int {
        return allSongs.size
    }

    inner class MainViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val img = v.findViewById(R.id.songImg) as ImageView
        private val subs = v.findViewById(R.id.songArtist) as TextView
        private val title = v.findViewById<TextView>(R.id.songName)

        fun bindItems(data: Song) {
            title.text = data.title
            subs.text = data.singer
            Picasso.get().load(data.image).into(img)
        }
    }
}