package com.flipaclip.interview.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.flipaclip.interview.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun onShowBrushes(view: View) {
        // TODO display the brushes fragment
        Toast.makeText(this, "TODO: Display the brushes fragment", Toast.LENGTH_LONG).show()
    }
}