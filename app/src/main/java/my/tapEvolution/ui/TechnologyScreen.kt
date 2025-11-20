package my.tapEvolution.ui

import android.text.Layout
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import my.tapEvolution.TapViewModel
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.io.path.Path

@Composable
fun TechnologyScreen(vm: TapViewModel){
    val tree by vm.researchTree.collectAsState()
    val timeLeft by vm.elapsedSec.collectAsState()
    Box(modifier = Modifier.padding(8.dp).fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth().height(2000.dp)) {
            val width = size.width
            val height = size.height
            val path1 = Path().apply {
                moveTo(width/2, height/10)
                cubicTo(width/2,height/4,width/5,height/10,width/5,height/4)
            }
            val path2 = Path().apply {
                moveTo(width/2,height/10)
                cubicTo(width/2,height/4,4*width/5, height/10, 4*width/5, height/4)
            }
            drawPath( path = path1, color = Color.Black, style = Stroke( width = 5f, cap = StrokeCap.Round))
            drawPath( path = path2, color = Color.Black, style = Stroke( width = 5f, cap = StrokeCap.Round))
        }
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            item {
                Box(modifier = Modifier.fillMaxWidth().height(100.dp)){
                    Card(modifier = Modifier.align(Alignment.Center).width(100.dp).height(100.dp), onClick = {
                        vm.startResearch(tree[0].name)
                    }) {
                        Box(modifier = Modifier.fillMaxSize().background(Color(tree[0].bg))){
                            Text(text = tree[0].name, modifier = Modifier.align(Alignment.Center))
                            if(tree[0].startTimeMillis != null){
                                Text(text = (tree[0].durationMillis/1000 - timeLeft).toString() + " sec", modifier = Modifier.align(Alignment.BottomCenter))
                            }
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
            item {
                Row(modifier = Modifier.fillMaxWidth().height(100.dp), horizontalArrangement = Arrangement.Center) {
                    Card(modifier = Modifier.width(100.dp).height(100.dp)) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = "Coming Soon!",
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(100.dp))
                    Card(modifier = Modifier.width(100.dp).height(100.dp)) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = "Coming Soon!",
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }

    }
}