package propertychange

import java.beans.PropertyChangeEvent

class GenericPropertyChangeEvent<T>(source: Any, propertyName: String, oldValue: T? = null, newValue: T? = null) :
    PropertyChangeEvent(source, propertyName, oldValue, newValue) {




}