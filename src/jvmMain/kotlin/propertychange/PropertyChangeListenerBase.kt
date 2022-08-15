package propertychange

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.util.Objects

abstract class PropertyChangeListenerBase protected constructor() : PropertyChangeListener {


    private lateinit var handlers : Map<String,IPropertyEventHandler>


    init {
        this.handlers = Objects.requireNonNull(createPropertyEventHandlers())
        PropertyChangeEventDelegator.instance()?.addPropertyChangeListener(this, *handlers.keys.toTypedArray())
    }

    override fun propertyChange(evt: PropertyChangeEvent?) {
        val propertyName = evt?.propertyName
        val handler = this.handlers.get(propertyName)

        handler?.let {
            if (evt != null) {
                this.handlers[propertyName]?.handle(evt)
            }
        }
    }


    protected abstract fun createPropertyEventHandlers() : Map<String,IPropertyEventHandler>


}