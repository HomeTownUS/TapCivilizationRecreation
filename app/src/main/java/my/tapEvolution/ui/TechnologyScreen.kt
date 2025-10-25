package my.tapEvolution.ui

import android.text.Layout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TechnologyScreen(){
    Box(modifier = Modifier.padding(8.dp).fillMaxSize()) {
        Text(text = "Coming Soon!",
            modifier = Modifier.align(Alignment.Center))
    }
}