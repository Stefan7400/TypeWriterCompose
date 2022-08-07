package components.typedtextselectorcomponent

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import utils.OpenFileChooserDialog

@Composable
fun TypedTextSelectorComponent(viewModel : TypedTextSelectorComponentViewModel){



    Box() {
        Button(onClick = {viewModel.showDropDown.value = true}){
            Text("Select a text")
        }
        DropdownMenu(expanded = viewModel.showDropDown.value, onDismissRequest = {}){
            DropdownMenuItem(onClick = {viewModel.showFileChooser.value = true}){

                Text("Select File")

                if(viewModel.showFileChooser.value){
                    OpenFileChooserDialog(onCloseRequest = {
                        viewModel.onTextFileSelected(it)
                        }
                    )
                }
            }
        }

    }

}

fun CreateFileChooserMenuItem(){

}