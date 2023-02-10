package com.flipaclip.interview.presentation.brushes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flipaclip.interview.data.BrushRepository

class BrushesViewModelFactory(private val repository: BrushRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BrushesViewModel(repository) as T
    }
}