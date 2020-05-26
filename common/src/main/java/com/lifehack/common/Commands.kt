package com.lifehack.common

sealed class Commands {

    object ShowJsonError : Commands()
    object ShowError : Commands()

    object ShowProgress : Commands()
    object HideProgress : Commands()
}