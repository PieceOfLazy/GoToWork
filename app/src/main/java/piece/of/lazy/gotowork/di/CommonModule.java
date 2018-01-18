package piece.of.lazy.gotowork.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import piece.of.lazy.gotowork.auth.LazyAuth;
import piece.of.lazy.gotowork.common.SharedPreferences;
import piece.of.lazy.gotowork.common.SharedPreferencesDefault;
import piece.of.lazy.gotowork.firebase.FbAuth;

/**
 * @author piece.of.lazy
 */
@Module
public class CommonModule {
    @Provides
    @Singleton
    SharedPreferences provideCommonPreference(Application application) {
        return new SharedPreferencesDefault(application);
    }

    @Provides
    @Singleton
    LazyAuth provideLazyAuth() {
        return new FbAuth();
    }
}
