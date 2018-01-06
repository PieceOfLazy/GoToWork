package piece.of.lazy.gotowork.common

import javax.inject.Inject

/**
 * @author piece.of.lazy
 */

class LogDefault @Inject constructor(tag: String?) : Log {

    private val log = piece.of.lazy.ui.util.Log(tag)

    override fun v(msg: String) {
        log.v(msg)
    }

    override fun d(msg: String) {
        log.d(msg)
    }

    override fun i(msg: String) {
        log.i(msg)
    }

    override fun w(msg: String) {
        log.w(msg)
    }

    override fun e(msg: String) {
        log.e(msg)
    }

}
