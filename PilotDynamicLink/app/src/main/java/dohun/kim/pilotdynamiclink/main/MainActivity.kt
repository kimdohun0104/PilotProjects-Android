package dohun.kim.pilotdynamiclink.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dohun.kim.pilotdynamiclink.R
import dohun.kim.pilotdynamiclink.data.GithubService
import dohun.kim.pilotdynamiclink.model.UserModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        GithubService.getService().getUsers().enqueue(object : Callback<List<UserModel>> {
            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<UserModel>>,
                response: Response<List<UserModel>>
            ) {
                response.body()?.let {
                    (rv_user.adapter as MainListAdapter).submitList(it)
                }
            }
        })
    }

    private fun setupRecyclerView() {
        rv_user.adapter = MainListAdapter()
    }
}