package com.example.uigame

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.image.Image
import javafx.stage.Stage


class HelloApplication : Application() {
    override fun start(theStage: Stage) {

        theStage.title = "Timeline Example"

        val root = Group()
        val theScene = Scene(root)
        theStage.scene = theScene

        val canvas = Canvas(512.0, 512.0)
        root.children.add(canvas)

        val gc = canvas.graphicsContext2D

        val earth = Image("earth.png")
        val sun = Image("sun.png")
        val space = Image("space.png")

        val startNanoTime = System.nanoTime()

        object : AnimationTimer() {
            override fun handle(currentNanoTime: Long) {
                val t = (currentNanoTime - startNanoTime) / 1000000000.0
                val x = 232 + 128 * Math.cos(t)
                val y = 232 + 128 * Math.sin(t)

                // background image clears canvas
                gc.drawImage(space, 0.0, 0.0)
                gc.drawImage(earth, x, y)
                gc.drawImage(sun, 196.0, 196.0)
            }
        }.start()

        theStage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}