package com.honeycomb.imgflipapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.honeycomb.imgflipapp.R
import com.honeycomb.imgflipapp.databinding.FragmentDetailBinding
import com.honeycomb.imgflipapp.databinding.FragmentHomeBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.show_meme_rv_item.view.*


@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail){

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    val args : DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)

        Picasso.get().load(args.memeDetail!!.url).into(binding.detailImage)
    }
}