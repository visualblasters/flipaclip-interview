package com.flipaclip.interview.data

import kotlinx.coroutines.flow.MutableStateFlow

class BrushRepository {
    var brushesFlow = MutableStateFlow(
        listOf(
            Brush("brush.id.pen", "Pen", 20),
            Brush("brush.id.airbrush", "Airbrush", 40),
            Brush("brush.id.sketch", "Sketch", 12)
        )
    )
    var selectedBrush = brushesFlow.value.first().id

    companion object {
        val instance = BrushRepository()
    }

    fun setStrokeSize(id: String, size: Int) {
        val newBrushList = brushesFlow.value.map { it.copy() }
        newBrushList.find { it.id == id }?.strokeSize = size
        brushesFlow.value = newBrushList
    }
}
