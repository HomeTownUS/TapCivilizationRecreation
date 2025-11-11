package my.tapEvolution.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import my.tapEvolution.R
import my.tapEvolution.TapViewModel

@Composable
fun HomeScreen(vm: TapViewModel) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        val boxHeight = LocalConfiguration.current.screenHeightDp.dp
        Image(painter = painterResource(id = R.drawable.geminigeneratedvillage1),
            contentDescription = "Background background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth().height(boxHeight-440.dp))
        //TODO: Replace Placeholder for all buttons

        // Top-Left Corner (two stacked buttons) future update
        /*Column(
            modifier = Modifier.align(Alignment.TopStart)
                .padding(8.dp)
        ) {
            Button(onClick = { /* Handle click */ }) {
                Text("Civilization")
            }
            Spacer(modifier = Modifier.height(8.dp)) // Space between buttons
            Button(onClick = { /* Handle click */ }) {
                Text("Activity")
            }
        }*/

        // Top-Right Corner (two stacked buttons)
       /* Column(
            modifier = Modifier.align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Button(onClick = { /* Handle click */ }) {
                Text("Shop")
            }
            Spacer(modifier = Modifier.height(8.dp)) // Space between buttons
            Button(onClick = { /* Handle click */ }) {
                Text("Recover")
            }
        }*/
        Box(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).background(Color.Green).height(250.dp)){
            Image(painter = painterResource(id = R.drawable.geminigeneratedforeground),
                contentDescription = "Foreground background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize())
            //Wood
            Image(painter = painterResource(id = R.drawable.geminigeneratedtrees),
                contentDescription = "Wood Button",
                modifier = Modifier.clickable{vm.tapWood()}.padding(8.dp).align(Alignment.CenterStart).size(120.dp,120.dp)
            )
            /*Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp).align(Alignment.BottomStart)
            ) {
                Text("Sidebar")
            }*/
            Image(
                painter = painterResource(id = R.drawable.geminigeneratedfoodbush),
                contentDescription = "Food button",
                modifier = Modifier.clickable{vm.tapFood()}.padding(8.dp).align(Alignment.TopCenter).size(120.dp,120.dp)
            )

            Image(painter = painterResource(id = R.drawable.geminigeneratedstonesource),
                contentDescription = "Stone Button",
                modifier = Modifier.clickable{vm.tapStone()}.padding(8.dp).align(Alignment.CenterEnd).size(120.dp,120.dp)
            )
            // Bottom-Right Corner (single button)
            /*Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp).align(Alignment.BottomEnd)
            ) {
                Text("Spaceship")
            }*/

        }
    }
}