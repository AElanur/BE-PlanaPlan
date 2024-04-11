package project.planaplan_backend.dataModels

import javax.persistence.*




@Entity
@Table(name = "planner_auth")
data class PlannerAuth(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id       : String = "",
    var username : String = "",
    var password : String = ""
) {
    fun generateToken(secretKey: String): String {
        var expirationTime = 1000 * 60 * 60 * 24


        return "token"
    }
}