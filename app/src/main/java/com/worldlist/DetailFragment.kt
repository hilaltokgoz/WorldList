package com.worldlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.worldlist.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding

    private lateinit var wordModel: WordModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val myArgs = DetailFragmentArgs.fromBundle(it)
            wordModel = myArgs.word


            //HomePage'e geri dönüş için
            binding?.backButton?.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToHomePageFragment())
            }
        }
        //Adapter Bağlama
        val detailAdapter = DetailAdapter(wordModel)


        //RecyclerView görünümü için
        binding?.detailRecyclerView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding?.detailRecyclerView?.adapter = detailAdapter
        binding?.detailRecyclerView?.setHasFixedSize(true)
    }
}