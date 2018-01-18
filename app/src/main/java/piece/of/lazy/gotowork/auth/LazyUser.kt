package piece.of.lazy.gotowork.auth

import android.net.Uri

/**
 * @author piece.of.lazy
 */
interface LazyUser {

    val uuid: String

    val email: String?

    val emailVerified: Boolean

    val phoneNumber: String?

    val displayName: String?

    val photoURL: Uri?

}