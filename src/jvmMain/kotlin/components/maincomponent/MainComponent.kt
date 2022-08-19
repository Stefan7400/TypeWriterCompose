package components.maincomponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import components.typedtextselectorcomponent.TypedTextSelectorComponent
import components.typedtextselectorcomponent.TypedTextSelectorComponentHolder
import java.awt.Component
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel


val typedTextSelectorComponentHolder = TypedTextSelectorComponentHolder()

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MainComponent(mainViewModel: MainComponentViewModel) {

    Box(modifier = Modifier.fillMaxSize().background(color = Color.DarkGray)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(Modifier.height(25.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
                    Text(modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 50.dp),
                        text = mainViewModel.currentTextState.value,
                        fontSize = TextUnit(20F, TextUnitType.Sp),
                        color = Color.White
                    )
                }
            }
            TextField(modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp).border(width = 2.dp, shape = RoundedCornerShape(20.dp), color = mainViewModel.focusedIndicatorColor.value),
                value = mainViewModel.textState.value,
                onValueChange = {mainViewModel.onTextFieldInput(it)},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White, focusedIndicatorColor = Color.Transparent),
                shape = RoundedCornerShape(20.dp),
                textStyle = TextStyle(fontSize = TextUnit(19F,TextUnitType.Sp))
            )

            //Text(text = mainViewModel.keyStrokeText.value)
            typedTextSelectorComponentHolder.render()

           GameKeyboard()

        }

    }
}

@Composable
fun GameKeyboard() {

    val firstRow = listOf("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P")
    val secondRow = listOf("A", "S", "D", "F", "G", "H", "J", "K", "L")
    val thirdRow = listOf("Z", "X", "C", "V", "B", "N", "M")

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        GameKeyboardRow(firstRow)
        GameKeyboardRow(secondRow)
        GameKeyboardRow(thirdRow)
    }
}

@Composable
fun GameKeyboardRow(keyList: List<String>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        keyList.forEach {
            GameKeyboardKey(it, Modifier.weight(1f, true))
        }
    }
}

@Composable
fun GameKeyboardKey(key: String, modifier: Modifier) {

    Box(contentAlignment = Alignment.Center,
        modifier = modifier
            .aspectRatio(1f)
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.small
            )
            .clickable {

            }) {
        Text(
            text = key,
            textAlign = TextAlign.Center
        )
    }
}