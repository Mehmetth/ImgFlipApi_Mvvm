package com.honeycomb.imgflipapp.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.honeycomb.imgflipapp.R
import com.honeycomb.imgflipapp.domain.memes.Memes
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.show_meme_rv_item.view.*

class HomeAdapter (var memesList: List<Memes>,
                   val iItemClick: IItemClick,):
    RecyclerView.Adapter<HomeAdapter.DataViewHolder> () {
    class DataViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.show_meme_rv_item,parent,false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return memesList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        Picasso.get().load(memesList[position].url).into(holder.view.image)
        holder.view.name.text = memesList[position].name

        holder.itemView.setOnClickListener {
            iItemClick.itemClicked( memesList[position])
        }
    }
}