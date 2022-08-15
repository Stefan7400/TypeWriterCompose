package components.typedtextselectorcomponent

import androidx.compose.runtime.Composable
import propertychange.IPropertyEventHandler
import propertychange.PropertyChangeListenerBase
import propertychange.PropertyChangeNames.TEXT_FILE_SELECTED
import utils.Component

class TypedTextSelectorComponentHolder : Component {


     val typedTextSelectorComponentViewModel = TypedTextSelectorComponentViewModel()


    @Composable
    override fun render() {
        TypedTextSelectorComponent(typedTextSelectorComponentViewModel)
    }


}