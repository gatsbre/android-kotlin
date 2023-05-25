package com.example.myapplication.data.model

import androidx.room.PrimaryKey

data class Recipe(
    var recipeTitle: String?= null,
    var recipeIngredients: String ?= null
)