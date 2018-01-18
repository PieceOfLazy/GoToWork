package piece.of.lazy.gotowork.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import piece.of.lazy.gotowork.common.SharedPreferences;
import piece.of.lazy.gotowork.common.SharedPreferencesDefault;

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
}

//
//package piece.of.lazy.gotowork.di
//
//        import android.app.Application
//        import dagger.Module
//        import dagger.Provides
//        import piece.of.lazy.gotowork.common.CommonPreference
//        import piece.of.lazy.gotowork.common.CommonPreferenceDefault
//        import javax.inject.Singleton
//
///**
// * This is a Dagger module. We use this to bind our Application class as a Context in the AppComponent
// * By using Dagger Android we do not need to pass our Application instance to any module,
// * we simply need to expose our Application as Context.
// * One of the advantages of Dagger.Android is that your
// * Application & Activities are provided into your graph for you.
// * {@link
// * AppComponent_}.
// */
//@Module
//abstract class CommonModule {
//    @Provides
//    @Singleton
//    internal fun provideCommonPreference(application: Application): CommonPreference {
//        return CommonPreferenceDefault(application)
//    }
//}