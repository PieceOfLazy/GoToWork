package piece.of.lazy.gotowork.app

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import piece.of.lazy.gotowork.di.ActivityScoped
import piece.of.lazy.gotowork.di.FragmentScoped

/**
 * @author piece.of.lazy
 */
@Module
abstract class SplashModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun splashFragment(): SplashFragment

    @ActivityScoped
    @Binds
    internal abstract fun splashPresenter(presenter: SplashPresenter): SplashContract.Presenter
}
