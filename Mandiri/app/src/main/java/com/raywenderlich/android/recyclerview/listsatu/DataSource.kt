package com.raywenderlich.android.recyclerview.listsatu

import android.content.Context
import com.raywenderlich.android.recyclerview.R

class DataSource(val context: Context) {
    fun getAnimalList(): Array<String>{
        return context.resources.getStringArray(R.array.animal_array)
    }
}