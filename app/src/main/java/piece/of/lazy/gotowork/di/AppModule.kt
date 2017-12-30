package piece.of.lazy.gotowork.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import piece.of.lazy.gotowork.base.BaseApplication
import javax.inject.Singleton

/**
 *
 * @author piece.of.lazy
 */
@Module
class AppModule(private val app: BaseApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication() : Application = app

}
