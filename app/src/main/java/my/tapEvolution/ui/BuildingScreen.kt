package my.tapEvolution.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import my.tapEvolution.R
import my.tapEvolution.TapViewModel

@Composable
fun BuildingScreen(vm: TapViewModel){
    val terr by vm.territory.collectAsState()
    val land by vm.freeland.collectAsState()
    val build by vm.buildings.collectAsState()
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        item{
            Box(modifier = Modifier.fillMaxWidth().height(80.dp)){
                Row(modifier = Modifier.align(Alignment.TopCenter).fillMaxWidth(0.8f).background(Color.White)) {
                    Text(text ="Territory: ")
                    Text(text = " " + terr.toString(),
                        modifier = Modifier.background(Color(red = 106, blue = 201, green = 255)).weight(3f),
                        textAlign = TextAlign.Center)
                }
                Row(modifier = Modifier.align(Alignment.Center).fillMaxWidth(0.8f).background(Color.LightGray)) {
                    Text(text = " Free land: " + land.toString())
                }
            }
        }
        item{
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.align(Alignment.CenterStart)) {
                    Image(
                        painter = painterResource(id = R.drawable.geminigeneratedhut),
                        contentDescription = "Hut Image",
                        modifier = Modifier.padding(horizontal = 8.dp)
                            .size(60.dp, 60.dp)
                    )
                    Text(build[0].toString(), textAlign = TextAlign.Center, modifier = Modifier.width(76.dp).background(Color(0,175,255)))
                }
                Column(modifier = Modifier.align(Alignment.Center).width(200.dp)) {
                    Text(text = "PopulationLimit: +1")
                    Text(text = "Free land:5")
                    Text(text = "Wood:5")
                }
                Button(onClick = { vm.buyHut() }, modifier = Modifier.align(Alignment.CenterEnd)) {
                    Text("Buy Hut")
                }
            }
        }
        item { Spacer(
            modifier = Modifier.height(8.dp)
        ) }
        item{
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.align(Alignment.CenterStart)) {
                    Image(
                        painter = painterResource(id = R.drawable.geminigeneratedgrainery),
                        contentDescription = "Granary Image",
                        modifier = Modifier.padding(horizontal = 8.dp)
                            .size(60.dp, 60.dp)
                    )
                    Text(build[5].toString(), textAlign = TextAlign.Center, modifier = Modifier.width(76.dp).background(Color(0,175,255)))
                }
                Column(modifier = Modifier.align(Alignment.Center).width(200.dp)) {
                    Text(text = "FoodLimit: +200")
                    Text(text = "Free land:30")
                    Text(text = "Wood:40")
                }
                Button(onClick = { vm.buyGranary() }, modifier = Modifier.align(Alignment.CenterEnd)) {
                    Text("Buy Granary")
                }
            }
        }
        item { Spacer(
            modifier = Modifier.height(8.dp)
        ) }
        item{
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.align(Alignment.CenterStart)) {
                    Image(
                        painter = painterResource(id = R.drawable.geminigeneratedwarehouse),
                        contentDescription = "Granary Image",
                        modifier = Modifier.padding(horizontal = 8.dp)
                            .size(60.dp, 60.dp)
                    )
                    Text(build[5].toString(), textAlign = TextAlign.Center, modifier = Modifier.width(76.dp).background(Color(0,175,255)))
                }
                Column(modifier = Modifier.align(Alignment.Center).width(200.dp)) {
                    Text(text = "WoodLimit: +200   StoneLimit: +200")
                    Text(text = "Free land:60")
                    Text(text = "Wood:25   Stone:40")
                }
                Button(onClick = { vm.buyWarehouse() }, modifier = Modifier.align(Alignment.CenterEnd)) {
                    Text("Buy Warehouse")
                }
            }
        }
    }
}