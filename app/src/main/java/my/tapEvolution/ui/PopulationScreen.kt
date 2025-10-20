package my.tapEvolution.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import my.tapEvolution.TapViewModel

@Composable
fun PopulationScreen(vm: TapViewModel){
    val un by vm.unemployed.collectAsState()
    val pop by vm.workers.collectAsState()
    Column(modifier = Modifier.padding(8.dp)) {

        LazyColumn {
            item{
                Text("Unemployed: "+un.toString())
            }
            item {
                Button(onClick = {vm.addPop()}) {
                    Text("Add Population")
                }
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = { vm.hireFarmer() }) {
                        Text("Assign Farmer")
                    }
                    Spacer(Modifier.padding(8.dp))
                    Text("Farmers: "+ pop[0].toString())
                }
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = { vm.hireWoodcutter() }) {
                        Text("Assign Woodcutter")
                    }
                    Spacer(Modifier.padding(8.dp))
                    Text("Woodcutters: "+ pop[1].toString())
                }
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = { vm.hireQuarryman() }) {
                        Text("Assign Quarryman")
                    }
                    Spacer(Modifier.padding(8.dp))
                    Text("Quarrymen: "+ pop[2].toString())
                }
            }
        }
    }
}