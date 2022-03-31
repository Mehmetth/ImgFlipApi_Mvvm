package com.honeycomb.imgflipapp.presentation.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.honeycomb.imgflipapp.R
import com.honeycomb.imgflipapp.databinding.FragmentHomeBinding
import com.honeycomb.imgflipapp.domain.memes.Memes
import com.honeycomb.imgflipapp.presentation.DetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home),IItemClick{

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter : HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        observeMovies()
        observeState()

        homeViewModel.fetchAllMemes()

        binding.swipeRefreshLayout.setOnRefreshListener {
            observeMovies()
            binding.swipeRefreshLayout.isRefreshing=false
        }
    }
    private fun observeMovies(){
        homeViewModel.mMemes
            .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { memes ->
                if(memes != null){

                    val memesList = mutableListOf<Memes>()
                    memes.memes.forEach { item ->
                        memesList.add(Memes(item.id,item.name,item.url,item.width,item.height,item.box_count))
                    }

                    homeAdapter = HomeAdapter(memesList,this)

                    binding.recyclerView.apply {
                        adapter = homeAdapter
                        layoutManager = LinearLayoutManager(requireActivity())
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observeState(){
        homeViewModel.mState
            .flowWithLifecycle (viewLifecycleOwner.lifecycle,  Lifecycle.State.STARTED)
            .onEach { state ->
                handleState(state)
            }
            .launchIn (viewLifecycleOwner.lifecycleScope)
    }
    private fun handleState(state: MemesState){
        when(state){
            is MemesState.IsError -> handleLoading(state.isError)
            is MemesState.Init -> Unit
        }
    }
    private fun handleLoading(isError: Boolean){
        if(isError){
            binding.dataError.visibility = View.VISIBLE
            binding.dataLoading.visibility = View.VISIBLE
        }else{
            binding.dataError.visibility = View.INVISIBLE
            binding.dataLoading.visibility = View.INVISIBLE
        }
    }

    override fun itemClicked(memes: Memes) {
        val v = (requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(
                VibrationEffect.createOneShot(50,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            v.vibrate(50)
        }

        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(memes)
        requireView().findNavController().navigate(action)
    }
}