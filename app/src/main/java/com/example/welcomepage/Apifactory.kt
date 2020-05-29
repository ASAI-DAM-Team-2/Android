import com.example.welcomepage.Api
import com.example.welcomepage.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Apifactory {

    //Creating Auth Interceptor to add api_key query in front of all the requests.
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter(
                "api_key",
                "5wnzYJVckhqUmczsJM7iz_7lMvDEBEyZglw1ttvBoahGkNiao7YH729Msxa0fDHFElYk1NYGK1i3kXFxj4ChHhP6bs63spWfUDm4SNQbfukM6nnlYxa_jPJUnloIdZ0lVA9x6rCw-ePY6rbTOjDMdxqwCnn-jCB1oHRoJjsmC9i_01T3fdd9el2Q6iJ-rVuzPyS1IsR7emO-H1irhk74QifyKRTHi7Jr-lMJNDF2C4CFiSuGil9xNI-2scDBoH7pN4wnEMltKMZS2ExzaRzA8mSw1TKMqdMMxJQ6f_Vao2P39O9ZyPA-pgdi5fVCm-HzBBCVdsDf2WpdoSxT54Lrba1ouv-enM0T1M5hm-CHWOWHOlsTTKmFLrdFB8bUhhBkr-naMzxKD7_-qvoHtPQskygf2Xq8owGgoqGjrh3aDTEWc0JbZLw6Vgyy3h86VbJpgyQlLnMEqTX6ia8LNkt74CX-1tVhIo3iSkirm44MenBpTr36m10RyJOMCOgX91Bj\n"
            )
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    //OkhttpClient for building http request url
    private val tmdbClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()


    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(tmdbClient)
        .baseUrl("https://allergyappbackend.azurewebsites.net/API")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


    val restaurant: Api = retrofit().create(Api::class.java)

}
