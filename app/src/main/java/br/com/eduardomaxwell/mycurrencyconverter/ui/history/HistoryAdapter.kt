package br.com.eduardomaxwell.mycurrencyconverter.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.eduardomaxwell.mycurrencyconverter.core.extensions.formatCurrency
import br.com.eduardomaxwell.mycurrencyconverter.data.model.Coin
import br.com.eduardomaxwell.mycurrencyconverter.data.model.ExchangeResponseValue
import br.com.eduardomaxwell.mycurrencyconverter.databinding.ItemHistoryBinding

class HistoryAdapter : ListAdapter<ExchangeResponseValue, HistoryAdapter.ViewHolder>(
    DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ExchangeResponseValue) {
            binding.tvName.text = item.name

            val coin = Coin.getByName(item.codein)
            binding.tvValue.text = item.bid.formatCurrency(coin.locale)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ExchangeResponseValue>() {
            override fun areItemsTheSame(
                oldItem: ExchangeResponseValue,
                newItem: ExchangeResponseValue
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ExchangeResponseValue,
                newItem: ExchangeResponseValue
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}