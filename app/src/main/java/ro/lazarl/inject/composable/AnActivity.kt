package ro.lazarl.inject.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dagger.android.AndroidInjection
import javax.inject.Inject

class AnActivity : ComponentActivity() {
    @Inject
    internal lateinit var content: @Composable () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            // AnUi() // This works without injection
            content()
        }
    }
}

@Composable
fun AnUi() {
    Text(text = "Hello world!")
}