package components.typedtextselectorcomponent

import androidx.compose.foundation.layout.Box
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TypedTextSelectorComponent(viewModel : TypedTextSelectorComponentViewModel){

    Box() {
        DropdownMenu(expanded = false, onDismissRequest = {}){
            DropdownMenuItem(onClick = {}){
                Text("YOOO")
            }
        }

    }

}