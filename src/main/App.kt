package com.neelkamath.sirBurpsALot

import org.w3c.dom.HTMLAudioElement
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document

private fun setBlobHeight() {
    val blob = document.querySelector("#blob") as HTMLImageElement
    val size = document.querySelector("#size") as HTMLInputElement
    blob.style.height = "${size.valueAsNumber * 5}em"
}

fun main(args: Array<String>) {
    setBlobHeight()
    document.querySelector("#size")!!.addEventListener("input", { setBlobHeight() })
    document.addEventListener("keydown", {
        val event = it as KeyboardEvent
        if (event.keyCode in 65..90) {
            with(document.createElement("AUDIO") as HTMLAudioElement) {
                setAttribute("src", "burps/${event.key}.mp3")
                val size = document.querySelector("#size") as HTMLInputElement
                playbackRate = size.min.toDouble() + (size.max.toDouble() - size.valueAsNumber)
                play()
            }
        }
    })
}
