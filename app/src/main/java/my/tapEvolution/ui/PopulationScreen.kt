package my.tapEvolution.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import my.tapEvolution.R
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
                Box(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.align(Alignment.CenterStart)) {
                        Image(painter = painterResource(id = R.drawable.geminigeneratedfarmer),
                            contentDescription = "Farmer Image",
                            modifier = Modifier.padding(horizontal = 8.dp).size(60.dp,60.dp)
                        )
                        Text("Farmers: "+ pop[0].toString())
                    }
                    Button(modifier = Modifier.align(Alignment.CenterEnd), onClick = { vm.hireFarmer() }) {
                        Text("Assign Farmer")
                    }
                }
            }
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.align(Alignment.CenterStart)) {
                        Image(painter = painterResource(id = R.drawable.geminigeneratedlumberjack),
                            contentDescription = "Lumberjack Image",
                            modifier = Modifier.padding(horizontal = 8.dp).size(60.dp,60.dp)
                        )
                        Text("Woodcutters: "+ pop[1].toString())
                    }
                    Button(modifier = Modifier.align(Alignment.CenterEnd), onClick = { vm.hireWoodcutter() }) {
                        Text("Assign Woodcutter")
                    }
                }
            }
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.align(Alignment.CenterStart)) {
                        Image(painter = painterResource(id = R.drawable.geminigeneratedlumberjack),
                            contentDescription = "Lumberjack Image",
                            modifier = Modifier.padding(horizontal = 8.dp).size(60.dp,60.dp)
                        )
                        Text("Quarrymen: "+ pop[2].toString())
                    }
                    Button(modifier = Modifier.align(Alignment.CenterEnd), onClick = { vm.hireQuarryman() }) {
                        Text("Assign Quarryman")
                    }
                }
            }
        }
    }
}