package my.tapEvolution.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import my.tapEvolution.TapViewModel

@Composable
fun HomeScreen(vm: TapViewModel) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
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
        Box(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).background(Color.Green).height(200.dp)){
            //Wood
            Button(
                onClick = {vm.tapWood()},
                modifier = Modifier.padding(8.dp).align(Alignment.CenterStart)
            ) {
                Text("Wood")
            }
            /*Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp).align(Alignment.BottomStart)
            ) {
                Text("Sidebar")
            }*/

            Button(
                onClick = {vm.tapFood()},
                modifier = Modifier.padding(8.dp).align(Alignment.TopCenter)
            ) {
                Text("Food")
            }

            Button(
                onClick = {vm.tapStone()},
                modifier = Modifier.padding(8.dp).align(Alignment.CenterEnd)
            ) {
                Text("Stone")
            }
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