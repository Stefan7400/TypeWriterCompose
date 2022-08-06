package components.maincomponent

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import components.typedtextselectorcomponent.TypedTextSelectorComponent
import components.typedtextselectorcomponent.TypedTextSelectorComponentHolder


val typedTextSelectorComponentHolder = TypedTextSelectorComponentHolder()

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MainComponent(mainViewModel: MainComponentViewModel) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
                    Text(modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 50.dp),
                        text = mainViewModel.currentTextState.value,
                        fontSize = TextUnit(20F, TextUnitType.Sp)
                    )
                }
            }
            TextField(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),value = mainViewModel.textState.value, onValueChange = {mainViewModel.onTextFieldInput(it)})
            //Text(text = mainViewModel.keyStrokeText.value)
            typedTextSelectorComponentHolder.render()
        }

    }
}