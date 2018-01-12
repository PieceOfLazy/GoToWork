package piece.of.lazy.gotowork.app;

import android.support.annotation.Nullable;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import piece.of.lazy.gotowork.auth.LazyAuth;
import piece.of.lazy.gotowork.auth.LazyUser;
import piece.of.lazy.gotowork.common.Log;
import piece.of.lazy.gotowork.common.LogDefault;
import piece.of.lazy.gotowork.di.ActivityScoped;
import piece.of.lazy.gotowork.di.FragmentScoped;
import piece.of.lazy.gotowork.firebase.FbAuth;

/**
 * @author piece.of.lazy
 */
@Module
public abstract class SplashModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SplashFragment injectFragment();

    @ActivityScoped
    @Binds
    abstract SplashContract.Presenter injectPresenter(SplashPresenter presenter);

    @ActivityScoped
    @Binds
    abstract SplashContract.ActivityListener injectListner(SplashActivity listener);

    @Provides
    @ActivityScoped
    static Log providePresenterLog() {
        return new LogDefault(SplashPresenter.class.getSimpleName());
    }

    @Provides
    @ActivityScoped
    @Nullable
    static LazyUser provideLazyUser(SplashActivity activity) {
        return activity.getCurrentUser();
    }
}
