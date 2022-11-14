package ro.lazarl.inject.composable

import android.app.Application
import androidx.compose.runtime.Composable
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        AnActivityInjector::class
    ]
)
interface ApplicationInjector {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationInjector
    }

    fun inject(application: AnApplication)
}

@Module
abstract class AnActivityInjector {
    @ContributesAndroidInjector(modules = [UiProvision::class])
    abstract fun injectAnActivity(): AnActivity
}

@Module
class UiProvision {
    @Provides
    fun provideAnUi(): @Composable () -> Unit = { AnUi() }
}
