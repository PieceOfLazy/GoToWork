package piece.of.lazy.gotowork.firebase

import android.app.Activity
import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import piece.of.lazy.gotowork.R
import piece.of.lazy.gotowork.auth.LazyAuth
import piece.of.lazy.gotowork.auth.LazyUser
import piece.of.lazy.gotowork.configure.ActivityRequestCode
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author piece.of.lazy
 */
@Singleton
class FbAuth @Inject constructor() : LazyAuth {
    private val auth = FirebaseAuth.getInstance()

    private var googleApiClient: GoogleSignInClient? = null

    override fun currentUser(): LazyUser? {
        auth.currentUser?.let {
            return FbUser(it)
        }
        return null
    }

    fun signInActivityResult(activity: Activity, requestCode: Int, resultCode: Int, data: Intent?, listener: OnFbAuthCompleteListener): Boolean {
        when(ActivityRequestCode.generate(requestCode)) {
            ActivityRequestCode.AUTH_GOOGLE_SIGN_IN -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)
                    authWithGoogle(account, activity, listener)
                } catch (e: ApiException) {
                    listener.onComplete(true, currentUser())
                }
                return true
            }
            else -> {
                return false
            }
        }
    }

    fun signInWithGoogle(activity: Activity) {
        Log.i("FbAuth", "1 signInWithGoogle ${auth.currentUser?.uid}")
        if(googleApiClient == null) {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(activity.getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()
            googleApiClient = GoogleSignIn.getClient(activity, gso)
        }

        Log.i("FbAuth", "2 signInWithGoogle ${auth.currentUser?.uid}")
        activity.startActivityForResult(googleApiClient?.signInIntent,
                ActivityRequestCode.AUTH_GOOGLE_SIGN_IN.ordinal)
    }

    private fun authWithGoogle(acct: GoogleSignInAccount, activity: Activity, listener: OnFbAuthCompleteListener) {
        listener.onStart()
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
                .addOnCompleteListener(activity, { task ->
                    if (task.isSuccessful) {
                        listener.onComplete(false, currentUser())
                    } else {
                        listener.onComplete(false, null)
                    }
                })
    }
}

interface OnFbAuthCompleteListener {
    fun onStart()
    fun onComplete(Immediately: Boolean, user: LazyUser?)
}