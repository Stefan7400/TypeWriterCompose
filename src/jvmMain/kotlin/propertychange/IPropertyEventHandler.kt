package propertychange

import java.beans.PropertyChangeEvent

@FunctionalInterface
fun interface IPropertyEventHandler {

    fun handle(event : PropertyChangeEvent)

}