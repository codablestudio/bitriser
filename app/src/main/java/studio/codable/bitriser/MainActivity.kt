package studio.codable.bitriser

import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.Observer
import androidx.ui.tooling.preview.Preview
import org.koin.android.viewmodel.ext.android.viewModel
import studio.codable.bitriser.base.BaseActivity
import timber.log.Timber

class MainActivity : BaseActivity() {

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text("test")
        }

        vm.test()

        vm.errors.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                Timber.d(it.toString())
                Toast.makeText(this, it.extractStringToDisplay(), Toast.LENGTH_SHORT).show()
            }
        })

        vm.apps.observe(this, Observer {
            Toast.makeText(this, "Apps retrieved", Toast.LENGTH_SHORT).show()
        })
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Text("text")
}