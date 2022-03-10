package com.worldlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 3.03.2022                │
//└──────────────────────────┘
// 1 adet char isteyeceğiz_>Alfabe
//1 adet kelimeleri tutacağımız  liste

@Parcelize
data class WordModel(val wordAlphabet: Char, val wordList:ArrayList<String>) :Parcelable{

}