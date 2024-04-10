package project.planaplan_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
class PlanaPlanBackendApplication

fun main(args: Array<String>) {
    runApplication<PlanaPlanBackendApplication>(*args)
}
