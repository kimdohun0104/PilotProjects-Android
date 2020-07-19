package dohun.kim.pilotdynamiclink.repository

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import dohun.kim.pilotdynamiclink.R
import dohun.kim.pilotdynamiclink.data.GithubService
import dohun.kim.pilotdynamiclink.model.RepositoryModel
import kotlinx.android.synthetic.main.activity_repository.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

    class RepositoryActivity : AppCompatActivity() {

    private val login: String? by lazy { intent.getStringExtra("login") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)
        setupActionBar()

        setupRecyclerView()

        if (login.isNullOrBlank()) {
            FirebaseDynamicLinks.getInstance()
                .getDynamicLink(intent)
                .addOnSuccessListener {
                    it.link?.getQueryParameter("login")?.let { loginParam ->
                        title = loginParam
                        getRepositories(loginParam)
                    }
                }
        } else {
            title = login
            getRepositories(login ?: "")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_repository, menu)
        return true
    }

    private fun setupActionBar() {
        setSupportActionBar(tb_repository)
        tb_repository.setNavigationOnClickListener { finish() }
        tb_repository.setOnMenuItemClickListener {
            FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse("https://pilotdynamiclink.page.link/repository?login=$login"))
                .setDomainUriPrefix("https://pilotdynamiclink.page.link")
                .setAndroidParameters(DynamicLink.AndroidParameters.Builder().build())
                .buildShortDynamicLink()
                .addOnSuccessListener {
                    (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).setPrimaryClip(
                        ClipData.newUri(
                            contentResolver, "URI",
                            it.shortLink
                        )
                    )
                    Toast.makeText(this, "클립보드에 저장", Toast.LENGTH_SHORT).show()
                }
            true
        }
    }

    private fun setupRecyclerView() {
        rv_repository.adapter = RepositoryListAdapter()
    }

    private fun getRepositories(login: String) {
        GithubService.getService().getRepositories(login)
            .enqueue(object : Callback<List<RepositoryModel>> {
                override fun onFailure(call: Call<List<RepositoryModel>>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<List<RepositoryModel>>,
                    response: Response<List<RepositoryModel>>
                ) {
                    response.body()?.let {
                        (rv_repository.adapter as RepositoryListAdapter).submitList(it)
                    }
                }
            })
    }
}