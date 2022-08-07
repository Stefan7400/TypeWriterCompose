package propertychange

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

class PropertyChangeEventDelegator private constructor() {

    companion object {
        private lateinit var instance : PropertyChangeEventDelegator

        fun instance() : PropertyChangeEventDelegator{
            if (instance == null){
                instance = PropertyChangeEventDelegator()
            }
            return instance
        }
    }

    private val propertyChangeSupport = PropertyChangeSupport(this)


    fun addPropertyChangeListener(listener : PropertyChangeListener, vararg propertyNames : String){
        for (property : String in propertyNames){
            this.propertyChangeSupport.addPropertyChangeListener(property,listener)
        }
    }

    fun firePropertyChangeEvent(source : Any, propertyname : String){
        firePropertyChangeEvent(source,propertyname,null,null)
    }


    fun <T> firePropertyChangeEvent(source : Any, propertyname: String, oldValue : T, newValue : T){
        firePropertyChangeEvent(GenericP)
    }

    fun firePropertyChangeEvent(event : PropertyChangeEvent){
        this.propertyChangeSupport.firePropertyChange(event)
    }
}