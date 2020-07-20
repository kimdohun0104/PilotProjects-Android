package dohun.kim.pilotdynamiclink

import android.content.Intent
import android.net.Uri
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

object DynamicLinkUtil {
    suspend fun getDynamicLink(intent: Intent) = suspendCancellableCoroutine<String> { cout ->
        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener {
                it.link?.getQueryParameter("login")?.let { loginParam ->
                    cout.resume(loginParam)
                }
            }
            .addOnFailureListener { cout.resumeWithException(it) }
    }

    suspend fun createDynamicLink(login: String) = suspendCancellableCoroutine<Uri> { cout ->
        FirebaseDynamicLinks.getInstance().createDynamicLink()
            .setLink(Uri.parse("https://pilotdynamiclink.page.link/repository?login=$login"))
            .setDomainUriPrefix("https://pilotdynamiclink.page.link")
            .setAndroidParameters(DynamicLink.AndroidParameters.Builder().build())
            .buildShortDynamicLink()
            .addOnSuccessListener { cout.resume(it.shortLink ?: Uri.EMPTY) }
            .addOnFailureListener { cout.resumeWithException(it) }
    }
}