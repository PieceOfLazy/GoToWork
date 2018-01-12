package piece.of.lazy.gotowork.auth

/**
 * @author piece.of.lazy
 */
interface LazyUser {

    fun getEmail(): String?

    fun getUid(): String
}