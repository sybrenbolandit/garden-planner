package nl.sybrenbolandit.gardenplanner.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import nl.sybrenbolandit.gardenplanner.R
import nl.sybrenbolandit.gardenplanner.databinding.FragmentDetailBinding
import java.util.*

class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_detail, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = DetailViewModelFactory(application)
        val detailViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)

        val arguments = DetailFragmentArgs.fromBundle(arguments!!)
        detailViewModel.fetchAction(UUID.fromString(arguments.code))

        binding.completeActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToDoneFragment())
        }

        binding.detailViewModel = detailViewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }
}
