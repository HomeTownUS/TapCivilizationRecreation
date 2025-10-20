package my.tapEvolution.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import my.tapEvolution.TapViewModel

@Composable
fun BuildingScreen(vm: TapViewModel){
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        item{
            Button(onClick = {vm.buyHut()}) {
                Text("Buy Hut")
            }
        }
    }
}