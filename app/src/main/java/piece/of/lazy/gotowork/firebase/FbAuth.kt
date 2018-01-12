package piece.of.lazy.gotowork.firebase

import com.google.firebase.auth.FirebaseAuth
import piece.of.lazy.gotowork.auth.LazyAuth
import piece.of.lazy.gotowork.auth.LazyUser
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author piece.of.lazy
 */
@Singleton
class FbAuth @Inject constructor() : LazyAuth {
    private val auth = FirebaseAuth.getInstance()

    override fun currentUser(): LazyUser? {

        auth.currentUser?.let {
            return FbUser(it)
        }
        return null
    }
}