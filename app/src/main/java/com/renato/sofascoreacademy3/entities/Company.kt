package com.renato.sofascoreacademy3.entities

class Company(
    val name: String,
    val address: String,
    val city: String,
    val country: String,
    val phone: String,
    val email: String,
    val website: String,
    val industry: String,
    val description: String,
    val foundedYear: String,
    val continent: String,
    val type:String
){

    override fun toString(): String {
        return "Company -- \nname='$name'," +
                "\n address='$address'," +
                "\n city='$city'," +
                "\n country='$country'," +
                "\n phone='$phone'," +
                "\n email='$email'," +
                "\n website='$website'," +
                "\n industry='$industry'," +
                "\n description='$description'," +
                "\n foundedYear='$foundedYear'" +
                "\n continent='$continent'" +
                "\n type='$type'"
    }
}
