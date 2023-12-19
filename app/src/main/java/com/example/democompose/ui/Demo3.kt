package com.example.democompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHome() {
    //  val navController = NavHostController(LocalContext.current)
    val navController = rememberNavController()

    Scaffold(
        //topAppBar
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Compose App",
                        style = TextStyle(fontSize = 20.sp, color = Color.White)
                    )
                }, colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Blue)
            )
            /*MediumTopAppBar(
                title = {
                    Text(
                        text = "Compose App",
                        style = TextStyle(fontSize = 20.sp, color = Color.White)
                    )
                }, colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Blue)
            )*/
        },
        //bottomBar...
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Home",
                        modifier = Modifier.clickable {
                            navController.navigate("screen1")
                        }
                    )
                    Text(
                        text = "Chat",
                        modifier = Modifier.clickable {
                            navController.navigate("screen2?parameter=Abc")
                        }
                    )
                    Text(
                        text = "Profile",
                        modifier = Modifier.clickable {
                            navController.navigate("screen3")
                        }
                    )
                    Text(
                        text = "User Interaction",
                        modifier = Modifier.clickable {
                            navController.navigate("userInteraction?parameter=Abc")
                        }
                    )
                    /*Text(
                        text = "Bottom Sheet",
                        modifier = Modifier.clickable {
                            navController.navigate("bottombar")
                        }
                    )*/
                }
            }
        }
    ) { paddingValues ->
        /*UserInteraction(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )*/
        AppNavigation(
            navController = navController,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") {
            Screen1(modifier = modifier)
        }
        composable("screen2?parameter={parameter}",
            arguments = listOf(
                navArgument("parameter") {
                    NavType.StringType
                }
            )
        ) { backStackEntery ->
            Screen2(
                modifier = modifier,
                parameter = backStackEntery.arguments?.getString("parameter")
            )
        }
        composable("screen3") {
            Screen3(modifier = modifier)
        }
        composable("userInteraction") {
            UserInteraction(modifier = modifier, navController = navController)
        }
        /*composable("bottombar") {
            //UserInteraction(modifier = modifier, navController = navController)
            BottomSheets(
                sheetState = rememberModalBottomSheetState(
                    initialValue = ModalBottomSheetValue.Hidden
                )
            )
        }*/
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Screen1(modifier: Modifier) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val coroutineScope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            androidx.compose.material.Text(
                text = "BottomSheet",
                fontSize = 15.sp
            )
            androidx.compose.material.Text(
                text = "BottomSheet",
                fontSize = 15.sp
            )
            androidx.compose.material.Text(
                text = "BottomSheet",
                fontSize = 15.sp
            )
            androidx.compose.material.Text(
                text = "BottomSheet",
                fontSize = 15.sp
            )
            androidx.compose.material.Text(
                text = "BottomSheet",
                fontSize = 15.sp
            )

        },
    ) {
        Column(modifier = modifier.background(Color.Green)) {
            Text("Screen 1", color = Color.Red)
            Button(onClick = {
                coroutineScope.launch {
                    sheetState.show()
                }
            }) {
                androidx.compose.material.Text(text = "Show Bottom Seet")
            }
        }
    }
}

@Composable
fun Screen2(modifier: Modifier, parameter: String?) {
    Column(modifier = modifier.background(Color.Blue)) {
        Text("Screen 2 $parameter")
    }
}
/*@Composable
fun Screen2(modifier: Modifier,parameter:String?){
    Column(modifier = modifier.background(Color.Blue)) {
        Text("Screen 2 $parameter")
    }
}*/

@Composable
fun Screen3(modifier: Modifier) {
    Column(modifier = modifier.background(Color.Blue)) {
        Text("Screen 3")
    }
}



