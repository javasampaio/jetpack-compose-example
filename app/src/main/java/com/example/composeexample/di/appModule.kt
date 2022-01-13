package com.example.composeexample.di

import com.example.composeexample.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        ListViewModel()
    }
}