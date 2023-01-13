package org.bealead.mobiletool.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import dagger.hilt.android.AndroidEntryPoint
import org.bealead.common.utils.BasePreferenceDataStore
import org.bealead.mobiletool.R
import org.bealead.mobiletool.databinding.FragmentSettingBinding
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment: Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarLayout.toolbarTitle.text = "设置"
        binding.toolbarLayout.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

@AndroidEntryPoint
class SettingPreferenceFragment: PreferenceFragmentCompat() {

    @Inject lateinit var preferenceDataStore: BasePreferenceDataStore

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        preferenceManager.preferenceDataStore = preferenceDataStore
        setPreferencesFromResource(R.xml.login_server_setting, rootKey)
        findPreference<Preference>(getString(R.string.key_select_base_url))!!.setOnPreferenceClickListener {
            findNavController().navigate(R.id.action_setting_to_baseUrl)
            true
        }
    }

}



