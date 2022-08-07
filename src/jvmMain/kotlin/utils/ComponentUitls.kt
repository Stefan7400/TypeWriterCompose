package utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.AwtWindow
import extensions.getCompleteFilePath
import java.awt.FileDialog
import java.awt.Frame
import java.io.File
import java.io.FilenameFilter

@Composable
    fun OpenFileChooserDialog(
        parent: Frame? = null,
        onCloseRequest: (result: String?) -> Unit
    ) = AwtWindow(
        create = {
            object : FileDialog(parent, "Select a text file", LOAD) {

                override fun setVisible(value: Boolean) {
                    super.setVisible(value)
                    if (value) {
                        onCloseRequest(getCompleteFilePath())
                    }
                }

            }
        },
        dispose = FileDialog::dispose
    )


