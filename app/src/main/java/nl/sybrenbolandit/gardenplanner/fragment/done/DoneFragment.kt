package nl.sybrenbolandit.gardenplanner.fragment.done

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import nl.sybrenbolandit.gardenplanner.R
import nl.sybrenbolandit.gardenplanner.databinding.FragmentDoneBinding

class DoneFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentDoneBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_done, container, false)

        return binding.root
    }
}
