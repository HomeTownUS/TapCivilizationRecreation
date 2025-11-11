package my.tapEvolution

import android.os.Bundle
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.tapEvolution.ui.BuildingScreen
import my.tapEvolution.ui.HomeScreen
import my.tapEvolution.ui.PopulationScreen
import my.tapEvolution.ui.TechnologyScreen
import my.tapEvolution.ui.theme.TapEvolutionTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val VM by viewModels<TapViewModel>()
        lifecycleScope.launch(Dispatchers.Default){
            try{
                VM.init(applicationContext.filesDir)
            } catch (e: Exception) {}
        }
        setContent {
            TapEvolutionTheme {
                val navController = rememberNavController()
                val items = listOf(Screen.Home, Screen.Population, Screen.Building, Screen.Tech)
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        val dFood by VM.food.collectAsState()
                        val dWood by VM.wood.collectAsState()
                        val dStone by VM.stone.collectAsState()
                        Column {
                        TopAppBar(title = {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(horizontalArrangement = Arrangement.SpaceAround) {
                                    Text("Food")
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(dFood.toString())
                                }
                                Row(horizontalArrangement = Arrangement.SpaceAround) {
                                    Text("Wood")
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(dWood.toString())
                                }
                                Row(horizontalArrangement = Arrangement.SpaceAround) {
                                    Text("Stone")
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(dStone.toString())
                                }
                            }
                        })
                            HorizontalDivider(
                                Modifier.fillMaxWidth(),
                                2.dp,
                                Color.Black
                            )
                        }
                    },
                    bottomBar = {
                    NavigationBar {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route

                        items.forEach { screen ->
                            NavigationBarItem(
                                icon = { /* Tab Icon */ },
                                label = { Text(screen.title) },
                                selected = currentRoute == screen.route,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        // Pop up to the start destination to avoid a growing back stack
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        // Avoid recreating the same tab when re-selecting
                                        launchSingleTop = true
                                        // Restore state when re-selecting a previously selected item
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }) { innerPadding ->
                    NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
                        composable(Screen.Home.route) { HomeScreen(vm = VM) }
                        composable(Screen.Population.route) { PopulationScreen(vm = VM) }
                        composable(Screen.Building.route) { BuildingScreen(vm = VM) }
                        composable(Screen.Tech.route) { TechnologyScreen() }
                    }
                }
            }
        }
    }
}

//Possible future addition after greater understanding
//@Composable
//fun BattleScreen(){}


