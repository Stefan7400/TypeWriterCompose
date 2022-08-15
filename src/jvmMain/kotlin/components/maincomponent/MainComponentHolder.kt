package components.maincomponent

import androidx.compose.runtime.Composable
import propertychange.IPropertyEventHandler
import propertychange.PropertyChangeListenerBase
import propertychange.PropertyChangeNames.TEXT_FILE_SELECTED
import utils.Component
import java.beans.PropertyChangeEvent

class MainComponentHolder : PropertyChangeListenerBase(),Component{

    private var mainViewModel = MainComponentViewModel()

    @Composable
    override fun render() {
        MainComponent(mainViewModel)
    }

    override fun createPropertyEventHandlers(): Map<String, IPropertyEventHandler> {
        val handlers = mutableMapOf<String, IPropertyEventHandler>()
        handlers.put(TEXT_FILE_SELECTED, {mainViewModel.handleTextFileSelected(it.newValue as String)} )

        return  handlers
    }


}