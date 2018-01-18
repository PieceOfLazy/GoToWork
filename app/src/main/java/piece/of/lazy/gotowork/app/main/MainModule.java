package piece.of.lazy.gotowork.app.main;

import android.support.annotation.Nullable;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
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
public abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainFragment injectFragment();

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter injectPresenter(MainPresenter presenter);

    @ActivityScoped
    @Binds
    abstract MainContract.ActivityListener injectListner(MainActivity listener);

    @Provides
    @ActivityScoped
    static Log providePresenterLog() {
        return new LogDefault(MainContract.class.getSimpleName());
    }

    @Provides
    @ActivityScoped
    @Nullable
    static LazyUser provideLazyUser(FbAuth auth) {
        return auth.currentUser();
    }
}
