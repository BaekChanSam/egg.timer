package com.android.base.views.container.home

import android.os.Bundle
import com.android.base.views.base.BaseFragment
import com.android.base.views.container.mainAct.MainViewModel
import com.example.custom_base_project.R
import com.example.custom_base_project.databinding.FragmentHomeBinding

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutRes = R.layout.fragment_home
    override val destinationId = R.id.homeFragment
    override val viewModelClass = HomeViewModel::class.java
    override val actViewModelClass = MainViewModel::class.java

    override fun initViews(savedInstanceState: Bundle?) {
        ui.viewDataBinding.viewModel = viewModel
    }

    override fun addObservers() {}

}