package piece.of.lazy.gotowork.app.animation;

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
public abstract class AnimationModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract AnimationFragment injectFragment();

    @ActivityScoped
    @Binds
    abstract AnimationContract.Presenter injectPresenter(AnimationPresenter presenter);

    @ActivityScoped
    @Binds
    abstract AnimationContract.ActivityListener injectListner(AnimationActivity listener);

    @Provides
    @ActivityScoped
    static Log providePresenterLog() {
        return new LogDefault(AnimationContract.class.getSimpleName());
    }

    @Provides
    @ActivityScoped
    @Nullable
    static LazyUser provideLazyUser(FbAuth auth) {
        return auth.currentUser();
    }
}
