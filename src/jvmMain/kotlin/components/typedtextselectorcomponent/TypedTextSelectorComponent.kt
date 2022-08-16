package components.typedtextselectorcomponent

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerMoveFilter
import propertychange.PropertyChangeEventDelegator
import propertychange.PropertyChangeNames.TEXT_FILE_SELECTED
import utils.OpenFileChooserDialog

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TypedTextSelectorComponent(viewModel : TypedTextSelectorComponentViewModel){



    Box(modifier = Modifier.pointerMoveFilter(onEnter = {viewModel.showDropDown.value = true
        false
    },
        onExit = {viewModel.showDropDown.value = false
            false
        })) {
        Button(onClick = {}){
            Text("Select a text")
        }
        DropdownMenu(modifier = Modifier.pointerMoveFilter(onEnter = {viewModel.showDropDown.value = true
            false
        },
            onExit = {viewModel.showDropDown.value = false
                false
            }),expanded = viewModel.showDropDown.value, onDismissRequest = {}){
            DropdownMenuItem(onClick = {viewModel.showFileChooser.value = true}){

                Text("Select File")

                if(viewModel.showFileChooser.value){
                    OpenFileChooserDialog {
                        it?.let {
                            PropertyChangeEventDelegator.instance()
                                ?.firePropertyChangeEvent(this, TEXT_FILE_SELECTED, "old", it)
                        }

                        //viewModel.onTextFileSelected(it)
                    }
                }
            }
        }

    }

}