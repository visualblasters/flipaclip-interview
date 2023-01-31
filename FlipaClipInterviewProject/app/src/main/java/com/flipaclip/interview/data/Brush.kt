package com.flipaclip.interview.data

data class Brush(val id: String, val name: String, var strokeSize: Int) {
    companion object {
        const val BRUSH_ID_PEN = "brush.id.pen"
        const val BRUSH_ID_AIRBRUSH = "brush.id.airbrush"
        const val BRUSH_ID_SKETCH = "brush.id.sketch"
    }
}
