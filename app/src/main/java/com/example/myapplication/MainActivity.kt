package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddIcCall
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.data.repository.MoviesViewModel
import com.example.myapplication.ui.components.BottomNavigationBar
import com.example.myapplication.ui.components.BottomTabBar
import com.example.myapplication.ui.tabs.MovieList
import com.example.myapplication.ui.tabs.MyMap
import com.mapbox.geojson.Point
import kotlinx.coroutines.launch


val moviesViewModel = MoviesViewModel()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var isDarkTheme by remember { mutableStateOf(true) }

            MyApplicationTheme (darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(navController = navController, onNameChange = {isDarkTheme = it})
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MapScreen() {
    Column( modifier = Modifier.fillMaxSize()) {
        MyMap().MapBoxMap(
            point = Point.fromLngLat(-0.6333, 35.6971),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Tab2(){
    Column( modifier = Modifier.fillMaxSize()) {
        Text("Tab1", color = Color.Blue, fontSize = 30.sp)
        Image(painter = painterResource(id = R.drawable.dog),
            contentDescription = "dog",
            contentScale = ContentScale.FillHeight,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TabList(){
    MovieList(movieList = moviesViewModel.movieListResponse)
    moviesViewModel.getMovieList()
}

@Preview(showSystemUi = true)
@Composable
fun Tab4(){
    Column( modifier = Modifier.fillMaxSize()) {
        Text("Tab4", color = Color.Blue, fontSize = 30.sp)
    }
}


@Composable
fun DrawerContent(onNameChange: (Boolean) -> Unit){
    var themeItem by rememberSaveable { mutableIntStateOf(0) }
    ModalDrawerSheet(
        modifier = Modifier
            .fillMaxHeight()
            .requiredWidth(300.dp)
    ) {
        Text(stringResource(R.string.drawer_title), modifier = Modifier.padding(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 0.dp, 30.dp, 0.dp),
            horizontalAlignment = Alignment.End
        ) {
            IconButton(
                onClick = {
                     when (themeItem) {
                        0 -> { themeItem= 1; onNameChange(false)}
                        1 -> { themeItem= 0; onNameChange(true)}
                        else -> { themeItem= 0; onNameChange(false)}
                    }
                },
            ) {
                Icon(
                    imageVector = when (themeItem) {
                                0 -> Icons.Default.DarkMode
                                1 -> Icons.Default.LightMode
                                else -> Icons.Default.DarkMode
                            },
                    "ThemeMode",
                    modifier = Modifier.size(50.dp),

                )
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
        Divider()
        NavigationDrawerItem(
            label = { Text(text = "منوی 1") },
            icon = { Icons.Default.Home },
            selected = false,
            onClick = {  }
        )
        NavigationDrawerItem(
            label = { Text(text = "منوی 2") },
            icon = { Icons.Default.Adb },
            selected = false,
            onClick = {  }
        )
        NavigationDrawerItem(
            label = { Text(text = "منوی 3") },
            icon = { Icons.Default.AddIcCall },
            selected = false,
            onClick = {  }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, onNameChange: (Boolean) -> Unit) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(onNameChange = onNameChange)
            },
            gesturesEnabled = drawerState.isOpen // if drawer is open then you can close it with gestures.

        ) {
            Scaffold(
                topBar = {

                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary,
                        ),
                        title = {
                            Text(stringResource(R.string.top_bar_title), style = TextStyle(textAlign = TextAlign.Left), fontSize = 20.sp)
                        },
                        actions = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Localized description"
                                )
                            }
                        }
                    )
                },
                snackbarHost = {
                    SnackbarHost(hostState = snackBarHostState)
                },
                floatingActionButton = {
                    FloatingActionButton(
                        content = { Icon(Icons.Filled.Add, contentDescription = "") },
                        onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar("SnackBar")
                            }
                        }
                    )
                },
                bottomBar = {
                    BottomAppBar { BottomNavigationBar(navController = navController) }
                }
            ) { contentPadding ->
                Box(modifier = Modifier.padding(contentPadding)) {
                    BottomTabBar().NavigationScreens(navController = navController)
                }
            }
        }
    }
}