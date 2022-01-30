package com.example.learneng.framework.ui.search_fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learneng.model.data.AppState
import com.example.learneng.databinding.FragmentSearchBinding
import com.example.learneng.framework.ui.adapter.DataModelItem
import com.example.learneng.framework.ui.base.MainContract
import com.example.learneng.framework.ui.search_fragment.presenter.SearchPresenter
import com.example.learneng.framework.ui.search_fragment.presenter.SearchPresenterImpl
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class SearchFragment : Fragment(), MainContract.View {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter : SearchPresenter
    private val dataModelItemAdapter = ItemAdapter<DataModelItem>()
    private val dataModelFastAdapter = FastAdapter.with(dataModelItemAdapter)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = SearchPresenterImpl()
        presenter.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() = with(binding) {
        binding.textInputLayout.setEndIconOnClickListener{
            val query = queryTextInputLayout.text.toString()
            presenter.search(query)
        }
        binding.translateRcView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.translateRcView.adapter =  dataModelFastAdapter
    }


    override fun onDetach() {
        super.onDetach()
        presenter.detachView(this)
    }


    override fun setState(state: AppState) {
        when(state) {
            is AppState.Error -> Toast.makeText(context, state.error.message, Toast.LENGTH_SHORT).show()
            is AppState.Loading -> {}
            is AppState.Success -> {
                FastAdapterDiffUtil[dataModelItemAdapter] = state.data.map(::DataModelItem)
            }
        }
    }
}
