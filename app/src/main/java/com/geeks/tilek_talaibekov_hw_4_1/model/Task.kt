package com.geeks.tilek_talaibekov_hw_4_1.model

import java.io.Serializable

data class Task(
    val title: String? = null,
    val desc: String? = null,
) : Serializable
