package com.worldlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.worldlist.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {

    lateinit var viewBinding: FragmentHomePageBinding

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
        viewBinding.wordRecyclerView.layoutManager =LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        viewBinding.wordRecyclerView.adapter=wordsAdapter
        viewBinding.wordRecyclerView.setHasFixedSize(true)
        wordsAdapter.alphabetTextClick {
            //findNavController().navigate(R.id.action_homePageFragment_to_detailFragment)
            findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToDetailFragment(it))
        }
        //HomaPage den Detail e geçiş
     //findNavController().navigate(R.id.action_homePageFragment_to_detailFragment)


    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}




