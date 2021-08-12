package es.sublimestudio.clasespotify.adapters

import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import es.sublimestudio.clasespotify.R
import es.sublimestudio.clasespotify.models.Playlist

class PlayListAdapter(private val allPlaylist: ArrayList<Playlist>, val clickAction: (Playlist) -> Unit) :
    RecyclerView.Adapter<PlayListAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false)
        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val playList = allPlaylist[position]

        holder.bindItems(playList)

        holder.itemView.setOnClickListener {
            clickAction(playList)
        }

    }

    override fun getItemCount(): Int {
        return allPlaylist.size
    }

    inner class MainViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val img = v.findViewById(R.id.mainImage) as ImageView
        private val subs = v.findViewById(R.id.subs) as TextView
        private val title = v.findViewById<TextView>(R.id.title)

        fun bindItems(data: Playlist) {
            title.text = data.title
            subs.text = "${data.followers} seguidores"
            Picasso.get().load(data.image).into(img)
        }
    }
}