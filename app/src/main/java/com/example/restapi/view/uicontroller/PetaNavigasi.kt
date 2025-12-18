package com.example.restapi.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.restapi.view.route.DestinasiEntry
import com.example.restapi.view.route.DestinasiHome

@Composable
fun DataSiswaApp(navController: NavController = rememberNavController(),
                 modifier: Modifier){
                HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavController,
    modifier: Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route,
    modifier = Modifier){
        composable(DestinasiHome.route){
            HomeScreen(navigateToItemEntry= {navController.navigate
                (DestinasiEntry.route)},
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetail.route}/${it}")
                })
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = {navController.navigate(DestinasiHome.route)})
        }
    }
}