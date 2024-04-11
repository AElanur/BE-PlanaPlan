package project.planaplan_backend.dataModels

import javax.persistence.*




@Entity
@Table(name = "planner_auth")
data class PlannerAuth(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var username : String = "",
    var password : String = ""
)