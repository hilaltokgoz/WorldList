package com.worldlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.worldlist.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {

    lateinit var viewBinding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomePageBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wordList = arrayListOf(
            "Attach",
            "Believe",
            "Attractive",
            "Bring",
            "Blow",
            "Correctly",
            "Choose",
            "Complete",
            "Diagnose",
            "Damage",
            "Discuss",
            "Earn",
            "Expect",
            "Establish"
        )
        val wordListA = wordList.filter {
            it.length > 1 && it.substring(0,1)=="A"
        }
        val wordListB = wordList.filter {
            it.length > 1  && it.substring(0,1)=="B"
        }
        val wordListC = wordList.filter {
            it.length > 1  && it.substring(0,1)=="C"
        }
        val wordListD = wordList.filter {
            it.length > 1  && it.substring(0,1)=="D"
        }
        val wordListE = wordList.filter {
            it.length > 1  && it.substring(0,1)=="E"
        }
        val characterList = arrayListOf(
            WordModel('A', wordListA as ArrayList<String>),
            WordModel('B', wordListB as ArrayList<String>),
            WordModel('C', wordListC as ArrayList<String>),
            WordModel('D', wordListD as ArrayList<String>),
            WordModel('E', wordListE as ArrayList<String>),
        )

        //Adapter Bağlama
        val wordsAdapter = WordAdapter(characterList)
        //RecyclerView ögelerinin yerleşiminin yapabilmek için Layout Manager oluşturulur.
        viewBinding.wordRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewBinding.wordRecyclerView.adapter = wordsAdapter
        viewBinding.wordRecyclerView.setHasFixedSize(true)
        wordsAdapter.alphabetTextClick {
            //HomaPage den Detail e geçiş
            findNavController().navigate(
                HomePageFragmentDirections.actionHomePageFragmentToDetailFragment(
                    it
                )
            )
        }

        fun onDestroyView() {
            super.onDestroyView()
        }
    }

}




