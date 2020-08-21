package studio.codable.bitriser.base

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import studio.codable.bitriser.R
import studio.codable.bitriser.util.Event
import studio.codable.bitriser.util.errorHandling.DisplayableError
import timber.log.Timber

abstract class BaseFragment(private val hasToolbar: Boolean) : Fragment() {
    protected var isShownFirstTime = true
        private set

    override fun onPause() {
        super.onPause()
        isShownFirstTime = false
    }

    fun showError(@StringRes messageRes: Int, vararg formatArgs: Any? = arrayOf()) {
        showError(getString(messageRes, formatArgs))
    }

    open fun showError(message: String) {
        Timber.tag(this::class.java.simpleName).e(message)
        showMessage(message)
    }

    open fun showError(error: DisplayableError) {
        Timber.tag(this::class.java.simpleName).e(error.causedBy, error.message)
        showMessage(error.extractStringToDisplay())
    }

    fun showMessage(@StringRes messageRes: Int, vararg formatArgs: Any? = arrayOf()) {
        showMessage(getString(messageRes, formatArgs))
    }

    open fun showMessage(message: String?) {
        Timber.tag(this::class.java.simpleName).d(message)
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    open fun defaultHandleError(event: Event<DisplayableError>) {
        event.getContentIfNotHandled()?.let { error ->
            error.extractStringToDisplay()?.let {
                showError(error)
            } ?: showError(R.string.unknown_error)
        }
    }

    protected open fun showSoftwareKeyboard(showKeyboard: Boolean) {
        val inputManager: InputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            requireActivity().currentFocus?.windowToken,
            if (showKeyboard) InputMethodManager.SHOW_FORCED else InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}