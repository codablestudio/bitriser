package studio.codable.bitriser.view.custom

import androidx.compose.foundation.Text
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import studio.codable.bitriser.util.errorHandling.DisplayableError

@Composable
fun showError(error: DisplayableError) {
    var isErrorDialogShowing by mutableStateOf(true)

    isErrorDialogShowing = true

    @Composable
    fun ErrorDialog(error: DisplayableError) {
        if (isErrorDialogShowing) {
            AlertDialog(
                onDismissRequest = { isErrorDialogShowing = false },
                text = { Text(text = error.extractStringToDisplay().toString()) },
                title = { Text(text = "Error") },
                confirmButton = {})
        }
    }

    ErrorDialog(error = error)
}
