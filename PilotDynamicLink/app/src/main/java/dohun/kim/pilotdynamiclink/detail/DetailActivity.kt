package dohun.kim.pilotdynamiclink.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import dohun.kim.pilotdynamiclink.R

class DetailActivity : AppCompatActivity() {

    private val login: String by lazy { intent.getStringExtra("login") ?: "" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener {
                Log.d("DEBUGLOG", it.link.toString())
            }
            .addOnFailureListener {
                Log.d("DEBUGLOG", it.message.toString())
            }
    }
}