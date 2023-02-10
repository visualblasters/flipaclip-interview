package com.flipaclip.interview.presentation.brushes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.flipaclip.interview.data.BrushRepository
import com.flipaclip.interview.databinding.FragmentBrushSettingsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BrushSettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BrushSettingsFragment : Fragment() {

    private lateinit var brushViewModel: BrushesViewModel
    private var brushId: String? = null
    private val brushRepository = BrushRepository.instance
    private val args: BrushSettingsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBrushSettingsBinding.inflate(inflater, container, false)
        brushViewModel = ViewModelProvider(requireActivity(), BrushesViewModelFactory(brushRepository))[BrushesViewModel::class.java]
        brushId = args.brushID

        binding.seekBar.max = 100
        brushId?.let { id ->
            brushViewModel.brushes.value.find { brush -> brush.id == id }?.let { brush ->
                binding.seekBar.progress = brush.strokeSize
                binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        brushViewModel.setStrokeSize(brush.id, progress)
                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {}

                    override fun onStopTrackingTouch(p0: SeekBar?) {}
                })
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val ARG_BRUSH_ID = "arg.brush.id"
        const val TAG = "SettingsFragment"

        fun newInstance(brushId: String): BrushSettingsFragment {
            val fragment = BrushSettingsFragment()
            val args = Bundle().apply {
                putString(ARG_BRUSH_ID, brushId)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
