

package com.worldlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.worldlist.databinding.DetailCardDesignBinding


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 8.03.2022                │
//└──────────────────────────┘

class DetailAdapter(private var wordModel: WordModel) : RecyclerView.Adapter<DetailAdapter.DetailCardDesign>(){

    class DetailCardDesign(val detailCardDesignBinding: DetailCardDesignBinding):RecyclerView.ViewHolder(detailCardDesignBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailCardDesign {
        val  layoutInflater= LayoutInflater.from(parent.context)
        val detailCardDesignBinding=DetailCardDesignBinding.inflate(layoutInflater,parent,false)
        return DetailCardDesign(detailCardDesignBinding)
    }

    override fun onBindViewHolder(holder: DetailCardDesign, position: Int) {

        //val detail=detailList[position]
        //Görüntüleme
        holder.detailCardDesignBinding.detailTextView.text= wordModel.wordList[position]
    }
    override fun getItemCount(): Int=wordModel.wordList.size
}