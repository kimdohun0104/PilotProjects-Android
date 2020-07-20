package dohun.kim.pilotdynamiclink.ui.repository

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dohun.kim.pilotdynamiclink.R
import dohun.kim.pilotdynamiclink.databinding.ActivityRepositoryBinding
import kotlinx.android.synthetic.main.activity_repository.*

class RepositoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepositoryBinding

    private val viewModel: RepositoryViewModel by lazy {
        ViewModelProvider(this)[RepositoryViewModel::class.java]
    }

    private val login: String? by lazy { intent.getStringExtra("login") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repository)

        setupActionBar()
        setupRecyclerView()

        viewModel.shortUri.observe(this, Observer {
            (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).setPrimaryClip(
                ClipData.newUri(contentResolver, "URI", it)
            )
            Toast.makeText(this, "클립보드에 저장", Toast.LENGTH_SHORT).show()
        })

        viewModel.getLogin(login, intent)
        viewModel.login.observe(this, Observer {
            title = it
            viewModel.getRepositories()
        })

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_repository, menu)
        return true
    }

    private fun setupActionBar() {
        setSupportActionBar(tb_repository)
        tb_repository.setNavigationOnClickListener { finish() }
        tb_repository.setOnMenuItemClickListener {
            viewModel.createDynamicLink()
            true
        }
    }

    private fun setupRecyclerView() {
        rv_repository.adapter = RepositoryListAdapter()
    }
}