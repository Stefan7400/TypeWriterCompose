package components.maincomponent

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import androidx.compose.ui.graphics.Color
import propertychange.PropertyChangeNames
import utils.createTextLines
import utils.matchAtIndex
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener

open class MainComponentViewModel {
    var texts = arrayListOf<String>()
    var lineCounter = 0
    var keyStrokes = MutableStateFlow(0)
    val currentTextState = MutableStateFlow("")
    var textState = mutableStateOf("")
    var keyStrokesPerSecondText =  MutableStateFlow(0)
    var focusedIndicatorColor = mutableStateOf(Color.Blue)
    //var keyStrokeText : StateFlow<String> = keyStrokesPerSecondText


    init {
        this.texts =createTextLines("is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",77)
        this.currentTextState.value = texts[lineCounter]
    }

    fun onTextFieldInput(input : String) {

        if(input == currentTextState.value){
            //Text has been finished load next one
            this.textState.value = ""
            lineCounter++
            this.currentTextState.value = texts[lineCounter]
        }

        if(matchAtIndex(input,currentTextState.value)) {
           // keyStrokes++
          //  println(keyStrokes)
            this.textState.value = input
            if (this.focusedIndicatorColor.value == Color.Green){
                this.focusedIndicatorColor.value = Color.Blue
            }
            if(this.focusedIndicatorColor.value == Color.Red){
                this.focusedIndicatorColor.value = Color.Green
            }

        } else {
            //misstyped
            this.focusedIndicatorColor.value = Color.Red
        }

    }

     fun handleTextFileSelected(path : String?){
        println("HANDLE METHOD")
    }

}