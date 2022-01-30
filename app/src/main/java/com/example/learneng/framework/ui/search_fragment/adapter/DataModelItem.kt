package com.example.learneng.framework.ui.search_fragment.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.learneng.model.data.DataModel
import com.example.learneng.R
import com.example.learneng.databinding.LangItemBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

open class DataModelItem(private val dataModel: DataModel) :  AbstractBindingItem<LangItemBinding>() {


    override var identifier: Long
        get() = dataModel.hashCode().toLong()
        set(value) {}

    override val type: Int
        get() = R.id.translate_rc_view

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?
    ): LangItemBinding {
        return LangItemBinding.inflate(inflater, parent, false)
    }

    override fun bindView(binding: LangItemBinding, payloads: List<Any>) {
        binding.translateTextView.text = dataModel.text
        binding.ruTextView.text = dataModel.meanings?.firstOrNull()?.translation?.translation
        val transcription = "[${dataModel.meanings?.firstOrNull()?.transcription}]"
        binding.transcriptionTextView.text = transcription
    }

    override fun unbindView(binding: LangItemBinding) {
        binding.translateTextView.text = null
        binding.ruTextView.text = null
        binding.transcriptionTextView.text = null
    }



}