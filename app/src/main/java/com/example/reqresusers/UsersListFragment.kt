package com.example.reqresusers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.reqresusers.databinding.FragmentUsersListBinding
import com.example.reqresusers.ui.UsersGridAdapter
import com.example.reqresusers.ui.viewmodel.UsersViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UsersListFragment : Fragment() {


    private val viewModel: UsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentUsersListBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        binding.usersGrid.adapter = UsersGridAdapter()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}