package nl.sybrenbolandit.gardenplanner.fragment.home

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
import nl.sybrenbolandit.gardenplanner.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = HomeViewModelFactory(application)
        val homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        binding.homeViewModel = homeViewModel

        val adapter = ActionAdapter(ActionListener { code ->
            homeViewModel.onActionClicked(code)
        })
        binding.actionList.adapter = adapter
        homeViewModel.actionList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        homeViewModel.navigateToDetails.observe(this, Observer { code ->
            code?.let {

                this.findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(code))
                homeViewModel.onNavigated()
            }
        })

        return binding.root
    }
}
