package com.vdovichenko.app

object PhonesData {
    val phones = Array<PhoneModel>(10) {PhoneModel(
        "generic name $it", "generic price $it",
        "generic date $it", "generic score $it")
    }
}