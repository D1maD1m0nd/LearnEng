package com.example.learneng.framework.ui.adapter

import android.view.View
import android.widget.TextView
import com.example.learneng.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import java.util.*

open class LangItem : AbstractItem<LangItem.ViewHolder>() {
    var name: String? = null
    var description: String? = null

    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = Random().nextInt()

    /** defines the layout which will be used for this item in the list */
    override val layoutRes: Int
        get() = R.layout.lang_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<LangItem>(view) {
        var langTextView: TextView = view.findViewById(R.id.translate_text_view)

        override fun bindView(item: LangItem, payloads: List<Any>) {
            langTextView.text = item.name
        }

        override fun unbindView(item: LangItem) {
            langTextView.text = null
        }
    }
}