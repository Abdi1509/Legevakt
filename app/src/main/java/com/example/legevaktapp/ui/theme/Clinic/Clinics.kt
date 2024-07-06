package com.example.legevaktapp.ui.theme.Clinic


data class ClinicsData(
    val name:String,
    val address: String,
    val reception: String,
    val doctor: String
    )

class Clinics(){
    class Clinics {
        val clinicList = listOf(
            ClinicsData(
                name = "Ensjø Medisinske Senter",
                address = "Adresse: Ensjøveien 12 A, 0560 Oslo",
                reception = "Resepsjon (08:00 - 15:00): 47987612",
                doctor = "Dr. Alexander"
            ),
            ClinicsData(
                name = "Majorstuen Medicsenter",
                address = "Adresse: Majorstuenveien 23 A, 0560 Oslo",
                reception = "Resepsjon (08:00 - 15:00): 47987612",
                doctor = "Dr. Midttun"
            ),
            ClinicsData(
                name = "Third Clinic",
                address = "Adresse: Oslo Gate 12, 5678 By",
                reception = "Resepsjon (10:00 - 18:00): 87654321",
                doctor = "Dr. Third"
            )
        )
    }

}