package components.maincomponent

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import utils.matchAtIndex

class MainComponentViewModel {
    var keyStrokes = MutableStateFlow(0)
    val currentTextState = MutableStateFlow("Beispiel Satz mit ein paar mehr Wörtern und Charactern!")
    var textState = mutableStateOf("")
    var keyStrokesPerSecondText =  MutableStateFlow(0)
    //var keyStrokeText : StateFlow<String> = keyStrokesPerSecondText

    var thread = Thread {
        while (true) {
            //keyStrokeText.value = "KPS: ${keyStrokes.value}"
            Thread.sleep(1000L)
            keyStrokes.value = 0
        }
    }.start()




    fun onTextFieldInput(input : String) {

        if(input == currentTextState.value){
            //Text has been finished load next one
            this.textState.value = ""
            this.currentTextState.value = "IRgend ein anderenr Text zum eingeben"
        }

        if(matchAtIndex(input,currentTextState.value)) {
           // keyStrokes++
          //  println(keyStrokes)
            this.textState.value = input
        }

    }

}