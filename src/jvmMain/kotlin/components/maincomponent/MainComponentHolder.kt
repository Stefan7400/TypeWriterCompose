package components.maincomponent

import androidx.compose.runtime.Composable
import utils.Component

class MainComponentHolder : Component{

    private var mainViewModel = MainComponentViewModel()

    @Composable
    override fun render() {
        MainComponent(mainViewModel)
    }


}