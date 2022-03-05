package com.worldlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.worldlist.databinding.WorldCardDesignBinding

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 3.03.2022                │
//└──────────────────────────┘

class WordAdapter(private var wordList: ArrayList<WordModel>):RecyclerView.Adapter<WordAdapter.WordCardDesign>() {

    private var onAlphabetTextClick:(WordModel)-> Unit={}
    fun alphabetTextClick(onAlphabetTextClick:(WordModel)-> Unit){
        this.onAlphabetTextClick = onAlphabetTextClick
    }
    class  WordCardDesign(val wordCardDesignBinding: WorldCardDesignBinding):RecyclerView.ViewHolder(wordCardDesignBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordCardDesign {
        val  layoutInflater= LayoutInflater.from(parent.context)
        val wordCardDesignBinding=WorldCardDesignBinding.inflate(layoutInflater,parent,false)
        return WordCardDesign(wordCardDesignBinding)
    }

    override fun onBindViewHolder(holder: WordCardDesign, position: Int) {

        val word=wordList[position]
        holder.wordCardDesignBinding.alphabetTextView.text= word.wordAlphabet.toString()

        //Higher Order Function use
        holder.wordCardDesignBinding.root.setOnClickListener{


        }
        holder.wordCardDesignBinding.alphabetTextView.setOnClickListener {
            //item a tıklanınca ne olacak?
            onAlphabetTextClick(word)
        }
    }


    override fun getItemCount(): Int=wordList.size

}