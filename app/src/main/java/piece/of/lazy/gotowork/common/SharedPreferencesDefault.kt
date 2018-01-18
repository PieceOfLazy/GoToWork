package piece.of.lazy.gotowork.common

import android.content.Context
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class SharedPreferencesDefault @Inject constructor(private val context: Context): SharedPreferences {

    private fun getSharedPreference(): android.content.SharedPreferences {
        return context.getSharedPreferences(SharedPreferences.KEY_NAME, Context.MODE_PRIVATE)
    }

    private fun getEditor(): android.content.SharedPreferences.Editor {
        return getSharedPreference().edit()
    }

    override fun getValue(key: String, defValue: Boolean): Boolean = getSharedPreference().getBoolean(key, defValue)

    override fun getValue(key: String, defValue: Int): Int = getSharedPreference().getInt(key, defValue)

    override fun getValue(key: String, defValue: Long): Long = getSharedPreference().getLong(key, defValue)

    override fun getValue(key: String, defValue: Float): Float = getSharedPreference().getFloat(key, defValue)

    override fun getValue(key: String, defValue: String): String = getSharedPreference().getString(key, defValue)

    override fun setValue(key: String, value: Boolean) {
        val editor = getEditor()
        editor.putBoolean(key, value)
        editor.commit()
    }

    override fun setValue(key: String, value: Int) {
        val editor = getEditor()
        editor.putInt(key, value)
        editor.commit()
    }

    override fun setValue(key: String, value: Long) {
        val editor = getEditor()
        editor.putLong(key, value)
        editor.commit()
    }

    override fun setValue(key: String, value: Float) {
        val editor = getEditor()
        editor.putFloat(key, value)
        editor.commit()
    }

    override fun setValue(key: String, value: String) {
        val editor = getEditor()
        editor.putString(key, value)
        editor.commit()
    }
}