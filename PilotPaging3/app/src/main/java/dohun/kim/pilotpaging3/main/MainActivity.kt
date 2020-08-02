package dohun.kim.pilotpaging3.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dohun.kim.pilotpaging3.R
import dohun.kim.pilotpaging3.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private val gifAdapter: GifListAdapter by lazy { GifListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupRecyclerView()
        setupRefreshLayout()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }


    private fun setupRecyclerView() {
        binding.rvGif.adapter = gifAdapter.withLoadStateFooter(GifLoadStateAdapter())

        lifecycleScope.launch {
            gifAdapter.loadStateFlow.collectLatest { loadState ->
                binding.srlGif.isRefreshing = loadState.refresh is LoadState.Loading
            }
        }

        lifecycleScope.launch {
            viewModel.gifs.collectLatest { pagingData ->
                gifAdapter.submitData(pagingData)
            }
        }
    }

    private fun setupRefreshLayout() {
        binding.srlGif.setOnRefreshListener {
            gifAdapter.refresh()
        }
    }
}