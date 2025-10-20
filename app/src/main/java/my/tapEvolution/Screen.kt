package my.tapEvolution

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Population : Screen("population", "Population")
    object Building : Screen("building", "Building")
    object Tech : Screen("Technology","Technology")
}