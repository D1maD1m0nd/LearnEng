package com.example.learneng.framework.ui.description_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.learneng.databinding.DescriptionFragmentBinding
import com.example.learneng.framework.ui.description_fragment.viewModel.DescriptionViewModel
import com.example.learneng.framework.ui.search_fragment.viewModel.SearchViewModel
import com.example.learneng.model.data.AppState
import com.example.learneng.model.data.DataModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DescriptionFragment : Fragment() {
    private var _binding : DescriptionFragmentBinding? = null
    private val binding : DescriptionFragmentBinding get() = _binding!!
    private val viewModel: DescriptionViewModel by viewModel()
    private var itemId : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemId = arguments?.getInt(key)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DescriptionFragmentBinding.inflate(inflater, container, false)
        viewModel.liveDataToObserve.observe(viewLifecycleOwner){
            setState(it)
        }
        itemId?.let {
            viewModel.getData(it)
        }

        return binding.root
    }

    private fun setState(appState : AppState) {
        when(appState) {
            is AppState.Error -> {}
            is AppState.Loading -> {}
            is AppState.Success -> {
                val entity = appState.entity
                entity?.let {
                    initView(it)
                }
            }
        }
    }

    private fun initView(entity : DataModel) = with(binding) {
        wordTextView.text = entity.text
        val mean = entity.meanings?.firstOrNull()
        val imageUri = "https:${mean?.imageUrl}"
        transcriptionTextView.text = mean?.transcription
        translationTextView.text = mean?.translation?.translation
        previewImageView.load(imageUri){

        }
    }

    companion object{
        fun newInstance(itemId : Int) : Fragment{
            val bundle = Bundle();
            bundle.putInt(key, itemId)
            val fragment = DescriptionFragment()
            fragment.arguments = bundle
            return fragment
        }

        private val key = "ItemId"
    }

}