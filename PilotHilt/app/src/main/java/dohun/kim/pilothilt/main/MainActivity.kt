package dohun.kim.pilothilt.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import dohun.kim.pilothilt.R
import dohun.kim.pilothilt.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupUserRecyclerView()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setupUserRecyclerView() {
        binding.rvUser.adapter = UserListAdapter()
    }
}