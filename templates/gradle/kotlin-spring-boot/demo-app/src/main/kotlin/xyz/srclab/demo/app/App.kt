package xyz.srclab.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Starter

fun main(vararg args: String) {
    SpringApplication.run(Starter::class.java, *args)
}