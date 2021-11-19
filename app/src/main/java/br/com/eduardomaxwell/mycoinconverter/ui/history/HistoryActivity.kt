package br.com.eduardomaxwell.mycoinconverter.ui.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.eduardomaxwell.mycoinconverter.core.extensions.createDialog
import br.com.eduardomaxwell.mycoinconverter.core.extensions.createProgressDialog
import br.com.eduardomaxwell.mycoinconverter.databinding.ActivityHistoryBinding
import br.com.eduardomaxwell.mycoinconverter.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {


    private val adapter by lazy { HistoryAdapter() }
    private val dialog by lazy { createProgressDialog() }
    private val viewModel by viewModel<HistoryViewModel>()
    private val binding by lazy { ActivityHistoryBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvHistory.adapter = adapter
        binding.rvHistory.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        )

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        bindObserve()

        lifecycle.addObserver(viewModel)
    }

    private fun bindObserve() {
        viewModel.state.observe(this) {
            when (it) {
                HistoryViewModel.State.Loading -> dialog.show()
                is HistoryViewModel.State.Error -> {
                    dialog.dismiss()
                    createDialog {
                        setMessage(it.error.message)
                    }.show()
                }
                is HistoryViewModel.State.Success -> {
                    dialog.dismiss()
                    adapter.submitList(it.list)
                }
            }
        }
    }
}