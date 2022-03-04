package com.worldlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.worldlist.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {
    private var _binding: FragmentHomePageBinding? = null
    private val binding: FragmentHomePageBinding get() = _binding!!

    private var viewBinding: FragmentHomePageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomePageBinding.inflate(layoutInflater)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       //  val wordList = arrayOf<WordModel>(('A'..'Z')) //Listemiz->Alfabe
        val charList = ('A'..'Z').toList()
        val wordList= arrayListOf(
            WordModel('A'),
            WordModel('B'),
            WordModel('C'),
            WordModel('D'),
            WordModel('E')
        )

        //Adapter Bağlama
        charList[1]
        val wordsAdapter= WordAdapter(wordList)
        binding.wordRecyclerView.layoutManager =LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        binding.wordRecyclerView.adapter=wordsAdapter
        binding.wordRecyclerView.setHasFixedSize(true)



    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}




