package com.flipaclip.interview.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.flipaclip.interview.R
import com.flipaclip.interview.presentation.brushes.BrushesFragment
import com.flipaclip.interview.presentation.brushes.BrushesViewModel

class HomeActivity : AppCompatActivity() {

    val brushViewModel by viewModels<BrushesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        onShowBrushes()
    }

    private fun onShowBrushes() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}
