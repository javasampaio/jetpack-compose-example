package com.example.composeexample.navigation

import com.example.composeexample.model.Message
import com.example.composeexample.stringify

object NavigationRoute {
    private const val detailViewPath = "detailsView"
    const val HOME = "home"
    const val LIST_VIEW = "listView"
    const val DETAILS_VIEW = "$detailViewPath/{${NavigationArgsNames.MESSAGE}}"

    fun getDetailsRoute(message: Message) = "$detailViewPath/${message.stringify()}"
}