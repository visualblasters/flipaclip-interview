package com.flipaclip.interview.presentation.brushes

import androidx.lifecycle.ViewModel
import com.flipaclip.interview.data.BrushRepository

class BrushesViewModel(private val repository: BrushRepository) : ViewModel() {
    var brushes = repository.brushesFlow
    var selectedBrush = repository.selectedBrush
    fun setStrokeSize(id: String, size: Int) = repository.setStrokeSize(id, size)
}