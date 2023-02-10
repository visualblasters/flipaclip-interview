package com.flipaclip.interview.presentation.brushes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.flipaclip.interview.R
import com.flipaclip.interview.data.BrushRepository
import com.flipaclip.interview.databinding.FragmentBrushesBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class BrushesFragment : Fragment() {

    companion object {
        fun newInstance() = BrushesFragment()
    }

    lateinit var brushViewModel: BrushesViewModel
    private lateinit var binding: FragmentBrushesBinding
    private lateinit var brushAdapter: BrushAdapter
    private val brushRepository = BrushRepository.instance

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        brushViewModel = ViewModelProvider(this, BrushesViewModelFactory(brushRepository))[BrushesViewModel::class.java]

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_brushes,
            container,
            false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initComponents()
    }

    private fun initComponents() {
        brushAdapter = BrushAdapter { brush ->
            val action = BrushesFragmentDirections.brushToSettings(brush.id)
            view?.findNavController()?.navigate(action)
        }

        binding.brushesListRV.adapter = brushAdapter
        binding.brushesListRV.layoutManager = LinearLayoutManager(context)

        brushViewModel.brushes.onEach { brushes ->
            brushAdapter.submitList(brushes)
        }.launchIn(brushViewModel.viewModelScope)
    }
}
