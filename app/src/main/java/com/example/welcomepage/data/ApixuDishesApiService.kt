import com.example.welcomepage.data.DishesResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

//val API_KEY = "Bearer 5wnzYJVckhqUmczsJM7iz_7lMvDEBEyZglw1ttvBoahGkNiao7YH729Msxa0fDHFElYk1NYGK1i3kXFxj4ChHhP6bs63spWfUDm4SNQbfukM6nnlYxa_jPJUnloIdZ0lVA9x6rCw-ePY6rbTOjDMdxqwCnn-jCB1oHRoJjsmC9i_01T3fdd9el2Q6iJ-rVuzPyS1IsR7emO-H1irhk74QifyKRTHi7Jr-lMJNDF2C4CFiSuGil9xNI-2scDBoH7pN4wnEMltKMZS2ExzaRzA8mSw1TKMqdMMxJQ6f_Vao2P39O9ZyPA-pgdi5fVCm-HzBBCVdsDf2WpdoSxT54Lrba1ouv-enM0T1M5hm-CHWOWHOlsTTKmFLrdFB8bUhhBkr-naMzxKD7_-qvoHtPQskygf2Xq8owGgoqGjrh3aDTEWc0JbZLw6Vgyy3h86VbJpgyQlLnMEqTX6ia8LNkt74CX-1tVhIo3iSkirm44MenBpTr36m10RyJOMCOgX91Bj"
//http://allergyappbackend.azurewebsites.net/api/Dish

interface  ApixuDishesApiService {
    @GET( "api/Dish")
    fun getDishes (
//        @Header("Authorization") auth: String
    ): Deferred<DishesResponse>

    companion object {
        operator fun invoke(): ApixuDishesApiService {
            // ApixuDishesApiService.invoke();
            val requestInterceptor = Interceptor {chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
//                    .addQueryParameter("key", "superkey")
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .addHeader("Accept", "application/json;versions=1")
                    .addHeader("Authorization", "Bearer 5wnzYJVckhqUmczsJM7iz_7lMvDEBEyZglw1ttvBoahGkNiao7YH729Msxa0fDHFElYk1NYGK1i3kXFxj4ChHhP6bs63spWfUDm4SNQbfukM6nnlYxa_jPJUnloIdZ0lVA9x6rCw-ePY6rbTOjDMdxqwCnn-jCB1oHRoJjsmC9i_01T3fdd9el2Q6iJ-rVuzPyS1IsR7emO-H1irhk74QifyKRTHi7Jr-lMJNDF2C4CFiSuGil9xNI-2scDBoH7pN4wnEMltKMZS2ExzaRzA8mSw1TKMqdMMxJQ6f_Vao2P39O9ZyPA-pgdi5fVCm-HzBBCVdsDf2WpdoSxT54Lrba1ouv-enM0T1M5hm-CHWOWHOlsTTKmFLrdFB8bUhhBkr-naMzxKD7_-qvoHtPQskygf2Xq8owGgoqGjrh3aDTEWc0JbZLw6Vgyy3h86VbJpgyQlLnMEqTX6ia8LNkt74CX-1tVhIo3iSkirm44MenBpTr36m10RyJOMCOgX91Bj")
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://allergyappbackend.azurewebsites.net/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuDishesApiService::class.java)
        }
    }
}
