package com.example.restapi.view.route

import com.example.restapi.R

object DestinasiEdit : DestinasiNavigasi {
    override val route = "edit"
    override val titleRes = R.string.app_name

    const val routeWithArgs = "edit/{itemId}"
    const val itemIdArg = "itemId"
}