package org.bealead.mobiletool.ui.setting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.bealead.mobiletool.R
import org.bealead.mobiletool.data.model.BaseUrl
import org.bealead.mobiletool.databinding.ItemBaseUrlBinding

class BaseUrlAdapter(context: Context): PagingDataAdapter<BaseUrl, BaseUrlAdapter.ViewHolder>(DIFF_CALLBACK)  {

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<BaseUrl>() {
            override fun areItemsTheSame(oldItem: BaseUrl, newItem: BaseUrl): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: BaseUrl, newItem: BaseUrl): Boolean {
                return oldItem.name == newItem.name
                        && oldItem.url == newItem.url
                        && oldItem.isSelect == newItem.isSelect
            }
        }
    }

    private val inflater = LayoutInflater.from(context)
    private var listener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBaseUrlBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onClick(baseUrl: BaseUrl)
        fun onEdit(baseUrl: BaseUrl)
        fun onDelete(baseUrl: BaseUrl)
    }

    inner class ViewHolder(private val binding: ItemBaseUrlBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
            binding.btnEdit.setOnClickListener(this)
            binding.btnDelete.setOnClickListener(this)
        }

        fun bind(position: Int) {
            val item = getItem(position)!!
            binding.title.text = item.name
            binding.value.text = item.url
            binding.border.isSelected = item.isSelect
        }

        override fun onClick(v: View?) {
            if (v == null) return
            listener?.let {
                val position = bindingAdapterPosition
                if (position < 0) return
                when(v.id) {
                    R.id.container -> it.onClick(getItem(position)!!)
                    R.id.btn_edit -> it.onEdit(getItem(position)!!)
                    R.id.btn_delete -> it.onDelete(getItem(position)!!)
                }
            }
        }
    }
}