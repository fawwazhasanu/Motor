package com.fawwaz.motor.data.model

data class ActionState<T>(
    val data: T? = null,
    val message: String? = null,
    val isSucces: Boolean = true,
    var isConsumed: Boolean = false

)
