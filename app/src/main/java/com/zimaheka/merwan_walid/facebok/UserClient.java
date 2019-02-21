package com.zimaheka.merwan_walid.facebok;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Walid Djebbouri on 07/02/2018.
 */

public interface UserClient{

    @POST("connexion.php")
    Call<User> createAccount(@Body User user);


}
