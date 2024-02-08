package mollah.yamin.xmail

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnticipateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mollah.yamin.xmail.ui.theme.XMailTheme

const val ICON_FADE_OUT_DURATION = 600L
const val SPLASH_SCREEN_SLIDE_DURATION = 600L
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView()
        if (savedInstanceState == null) splash.startAnimation(lifecycleScope)
    }
}

fun SplashScreen.startAnimation(lifecycleScope: LifecycleCoroutineScope) {
    setOnExitAnimationListener { splashScreenViewProvider ->
        val slideLeft = ObjectAnimator.ofFloat(
            splashScreenViewProvider.view,
            View.TRANSLATION_X,
            0f,
            -splashScreenViewProvider.view.width.toFloat()
        ).apply {
            interpolator = AnticipateInterpolator()
            duration = SPLASH_SCREEN_SLIDE_DURATION
            doOnEnd {
                splashScreenViewProvider.remove()
            }
        }

        ObjectAnimator.ofFloat(
            splashScreenViewProvider.iconView,
            View.TRANSLATION_Y,
            0f,
            -80f, 0f
        ).apply {
            duration = ICON_FADE_OUT_DURATION
            doOnEnd {
                lifecycleScope.launch {
                    delay(200)
                    slideLeft.start()
                }
            }
        }.start()
    }
}

fun ComponentActivity.setContentView() {
    setContent {
        XMailTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XMailTheme {
        Greeting("Android")
    }
}