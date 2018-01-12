package piece.of.lazy.gotowork.firebase

import com.google.firebase.auth.FirebaseUser
import piece.of.lazy.gotowork.auth.LazyUser

/**
 * @author piece.of.lazy
 */
class FbUser(private val user: FirebaseUser): LazyUser {

    override fun getEmail(): String? = user.email

    override fun getUid(): String = user.uid

}