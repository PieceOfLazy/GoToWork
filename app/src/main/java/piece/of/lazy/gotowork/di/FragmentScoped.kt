package piece.of.lazy.gotowork.di

import javax.inject.Scope

/**
 * @author piece.of.lazy
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class FragmentScoped