package org.bealead.mobiletool.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.bealead.mobiletool.R
import org.bealead.mobiletool.databinding.FragmentBaseUrlBinding

@AndroidEntryPoint
class BaseUrlFragment: Fragment() {
    private var _binding: FragmentBaseUrlBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingViewModel by viewModels()

    private lateinit var mAdapter: BaseUrlAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBaseUrlBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = BaseUrlAdapter(requireContext())

        binding.toolbarLayout.toolbarTitle.text = getString(R.string.base_url_setting)
        binding.toolbarLayout.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        binding.urlListView.run {
            setHasFixedSize(true)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.urlList.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                mAdapter.submitData(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}