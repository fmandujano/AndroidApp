package com.sae.miapp

import android.widget.ImageView
import androidx.core.net.toUri
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

import com.bumptech.glide.Glide

//funciones para consultar la API web de Appify

//URL a la que se conecta el servicio
private const val BASE_URL = "http://juegodetalento.com/appify/"

/*
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
*/
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface AppifyService {
    @GET("user.php")
    //para probar conexion con la api
    fun getMensajePrueba():
            Call<String>

    @FormUrlEncoded
    @POST("user.php")
    fun login(@Field("u") username:String, @Field("p") pass:String):
            Call<UserProperty>
}

object Api {
    val retrofitService: AppifyService by lazy {
        retrofit.create(AppifyService::class.java)
    }
}

//Propiedades del usuario contenidas en el JSON de respuesta a login
//user, error, last_name, xp
data class UserProperty(
    val user:String,
    val xp:Double,
    val last_name:String,
    val error:String
)


fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("http").build()
        Glide.with(imgView.context).load(imgUri).into(imgView)
    }
}

fun bindImageHTTPS(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context).load(imgUri).into(imgView)
    }
}
