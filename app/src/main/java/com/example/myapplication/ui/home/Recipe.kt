package com.example.myapplication.ui.home

import androidx.room.PrimaryKey

data class Recipe(
    var recipeTitle: String?= null,
    var recipeIngredients: String ?= null
)