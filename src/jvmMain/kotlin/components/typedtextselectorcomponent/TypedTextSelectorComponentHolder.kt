package components.typedtextselectorcomponent

import androidx.compose.runtime.Composable
import utils.Component

class TypedTextSelectorComponentHolder : Component {


    val typedTextSelectorComponentViewModel = TypedTextSelectorComponentViewModel()


    @Composable
    override fun render() {
        println("Rendered")
        TypedTextSelectorComponent(typedTextSelectorComponentViewModel)
    }
}