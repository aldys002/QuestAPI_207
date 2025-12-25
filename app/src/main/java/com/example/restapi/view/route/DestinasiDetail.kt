package com.example.restapi.view.route

import com.example.restapi.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail"
    override val titleRes = R.string.app_name

    const val routeWithArgs = "detail/{itemId}"
    const val itemIdArg = "itemId"
}