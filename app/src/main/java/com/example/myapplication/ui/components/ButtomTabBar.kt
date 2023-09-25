package com.example.myapplication.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Animation
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.MapScreen
import com.example.myapplication.Tab4
import com.example.myapplication.TabList
import com.example.myapplication.ui.theme.typography

class BottomTabBar {
    @Composable
    fun NavigationScreens(navController: NavHostController) {
        NavHost(navController, startDestination = NavItem.ANIMATION.route) {
            composable(NavItem.Home.route) { MapScreen() }
            composable(NavItem.ANIMATION.route) { AnimationPage() }
            composable(NavItem.List.route) { TabList() }
            composable(NavItem.Setting.route) { Tab4() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEachIndexed { _, item ->
            NavigationBarItem(
                alwaysShowLabel = true,
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title, style = typography.labelSmall ) },
                colors = NavigationBarItemDefaults
                    .colors(
                        unselectedIconColor = MaterialTheme.colorScheme.tertiary,
                        selectedIconColor = Color.Blue,
                        indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                            LocalAbsoluteTonalElevation.current)
                    ),
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

// Navigation Path
enum class NavPath {
    HOME, ANIMATION, LIST, Setting
}

// Navigation Title
object NavTitle {
    const val HOME = "نقشه"
    const val ANIMATION = "انیمیشن"
    const val LIST = "لیست"
    const val Setting = "تنظیمات"
}

val items = listOf(
    NavItem.Home,
    NavItem.ANIMATION,
    NavItem.List,
    NavItem.Setting,
)

// Sealed Navigation Items
sealed class NavItem (val route: String, val title: String, val icon: ImageVector) {
    object Home :
        NavItem(NavPath.HOME.toString(), NavTitle.HOME, Icons.Default.Home)

    object ANIMATION :
        NavItem( NavPath.ANIMATION.toString(), NavTitle.ANIMATION, Icons.Default.Animation)

    object List :
        NavItem(NavPath.LIST.toString(), NavTitle.LIST, Icons.Default.List)

    object Setting :
        NavItem(NavPath.Setting.toString(), NavTitle.Setting, Icons.Default.Settings)
}