package com.renato.sofascoreacademy3.entities

class Company(
    private val name: String,
    private val address: String,
    private val city: String,
    private val country: String,
    private val founder: String,
    private val email: String,
    private val website: String,
    private val description: String,
    private val yearFounded: Int,
    private val industry: Industry,
    private val type:String
){

    override fun toString(): String {
        return "Company -- " +
                "\nname='$name'," +
                "\n address='$address'," +
                "\n city='$city'," +
                "\n country='$country'," +
                "\n founder='$founder'," +
                "\n email='$email'," +
                "\n website='$website'," +
                "\n description='$description'," +
                "\n foundation year='$yearFounded'" +
                "\n industry='$industry'" +
                "\n type='$type'"
    }
}
