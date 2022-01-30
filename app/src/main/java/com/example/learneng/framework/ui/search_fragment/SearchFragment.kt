package com.example.learneng.framework.ui.search_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learneng.databinding.FragmentSearchBinding
import com.example.learneng.framework.ui.search_fragment.adapter.DataModelItem
import com.example.learneng.framework.ui.search_fragment.viewModel.SearchViewModel
import com.example.learneng.model.data.AppState
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val dataModelItemAdapter = ItemAdapter<DataModelItem>()
    private val dataModelFastAdapter = FastAdapter.with(dataModelItemAdapter)

    private val viewModel: SearchViewModel by viewModel()
    private val observer = Observer<AppState> { setState(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveDataToObserve.observe(viewLifecycleOwner, observer)
        initView()
    }

    private fun initView() = with(binding) {
        binding.textInputLayout.setEndIconOnClickListener {
            val query = queryTextInputLayout.text.toString()
            viewModel.getData(query, true)
        }
        binding.translateRcView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.translateRcView.adapter = dataModelFastAdapter
    }


    private fun setState(state: AppState) {
        when (state) {
            is AppState.Error -> Toast.makeText(context, state.error.message, Toast.LENGTH_SHORT)
                .show()
            is AppState.Loading -> {}
            is AppState.Success -> {
                state.data?.let {
                    FastAdapterDiffUtil[dataModelItemAdapter] = it.map(::DataModelItem)
                }
            }
        }
    }
}
