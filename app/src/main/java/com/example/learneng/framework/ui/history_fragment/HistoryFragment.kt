package com.example.learneng.framework.ui.history_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learneng.R
import com.example.learneng.databinding.FragmentHistoryBinding
import com.example.learneng.framework.ui.description_fragment.DescriptionFragment
import com.example.learneng.framework.ui.history_fragment.adapter.DataModelHistoryItem
import com.example.learneng.framework.ui.history_fragment.viewModel.HistoryViewModel
import com.example.learneng.model.data.AppState
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil
import org.koin.androidx.viewmodel.ext.android.viewModel


class HistoryFragment : Fragment() {
    private val dataModelItemAdapter = ItemAdapter<DataModelHistoryItem>()
    private val dataModelFastAdapter = FastAdapter.with(dataModelItemAdapter)

    private val viewModel: HistoryViewModel by viewModel()

    private var _binding : FragmentHistoryBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        viewModel.liveDataToObserve.observe(viewLifecycleOwner){
            setState(it)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.translateRcView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.translateRcView.adapter = dataModelFastAdapter
        viewModel.getHistory()
    }
    private fun setState(state: AppState) {
        when(state) {
            is AppState.Error -> {}
            is AppState.Loading -> {}
            is AppState.Success -> {
                state.data?.let {
                    FastAdapterDiffUtil[dataModelItemAdapter] = it.map(::DataModelHistoryItem)
                    dataModelFastAdapter.onClickListener = { _, _, item, _ ->
                        requireActivity()
                            .supportFragmentManager
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, DescriptionFragment.newInstance(item.dataModel.id))
                            .commit()
                        false
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance() = HistoryFragment()
    }
}