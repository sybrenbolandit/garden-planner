package nl.sybrenbolandit.gardenplanner.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import nl.sybrenbolandit.gardenplanner.R
import nl.sybrenbolandit.gardenplanner.databinding.FragmentActionDetailsBinding


class ActionDetailFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentActionDetailsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_action_details, container, false)

        val arguments = ActionDetailFragmentArgs.fromBundle(arguments!!)

        val viewModelFactory = ActionDetailViewModelFactory(arguments.actionCode)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ActionDetailViewModel::class.java)
        binding.viewModel = viewModel

        binding.setLifecycleOwner(this)

        viewModel.navigateHome.observe(this, Observer {
            if (it == true) {
                this.findNavController().navigate(ActionDetailFragmentDirections.actionActionDetailFragmentToHomeFragment())
                viewModel.doneNavigating()
            }
        })

        return binding.root
    }
}
