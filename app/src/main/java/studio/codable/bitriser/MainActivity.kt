package studio.codable.bitriser

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import studio.codable.bitriser.base.BaseActivity
import timber.log.Timber

class MainActivity : BaseActivity() {

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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