package com.flipaclip.interview.data

import kotlinx.coroutines.flow.MutableStateFlow
import java.util.concurrent.Flow

class BrushRepository {
    private var brushes = listOf(
        Brush("brush.id.pen", "Pen", 20),
        Brush("brush.id.airbrush", "Airbrush", 40),
        Brush("brush.id.sketch", "Sketch", 12)
    )
        private set(value) {
            brushesFlow.value = value
            field = value
        }

    val brushesFlow = MutableStateFlow(brushes)
    val selectedBrushFlow = MutableStateFlow(brushes.first().id)

    companion object {
        val instance = BrushRepository()
    }

    fun selectBrush(id: String) {
        selectedBrushFlow.value = id
    }

    fun setStrokeSize(id: String, size: Int) {
        val newBrushList = brushes.map { it.copy() }
        newBrushList.find { it.id == id }?.strokeSize = size
        brushes = newBrushList
    }
}