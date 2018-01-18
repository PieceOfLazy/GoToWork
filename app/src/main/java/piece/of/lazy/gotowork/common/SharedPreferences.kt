package piece.of.lazy.gotowork.common

/**
 * @author piece.of.lazy
 */
interface SharedPreferences {
    companion object {
        val KEY_NAME = "piece.of.lazy.gotowork.pref"

        val KEY_AUTH_UUID = "KEY_AUTH_UUID"
    }

    fun getValue(key: String, defValue: Boolean): Boolean

    fun getValue(key: String, defValue: Int): Int

    fun getValue(key: String, defValue: Long): Long

    fun getValue(key: String, defValue: Float): Float

    fun getValue(key: String, defValue: String): String

    fun setValue(key: String, value: Boolean)

    fun setValue(key: String, value: Int)

    fun setValue(key: String, value: Long)

    fun setValue(key: String, value: Float)

    fun setValue(key: String, value: String)
}