package components.typedtextselectorcomponent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import utils.Component

class TypedTextSelectorComponentViewModel {


    val showDropDown = mutableStateOf(false)
    val showFileChooser = mutableStateOf(false)

    fun onTextFileSelected(path : String?){
        println(path)
        showFileChooser.value = false
        showDropDown.value = false
    }


}