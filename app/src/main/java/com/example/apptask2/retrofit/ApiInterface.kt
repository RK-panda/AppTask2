package com.example.apptask2.retrofit

import com.example.apptask2.models.PostProduct
import com.example.apptask2.models.ReturnedResults
import com.example.apptask2.models.ShowProducts
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @Headers("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOWQzYzdkZmJmZDE0OTM2ZGJlMmE1MGFhZjYwZTM3NzA2OGI0YmRjNzFhYTNiNzYzNDc3NjNjMDM4NjQ1ZGVkYjVjOTk1YmQ3ZjVhOWQyYmIiLCJpYXQiOjE2NDQ0MzE5ODcuNTM1NTk1LCJuYmYiOjE2NDQ0MzE5ODcuNTM1NiwiZXhwIjoxNjc1OTY3OTg3LjUyNTk4NCwic3ViIjoiMSIsInNjb3BlcyI6W119.Y8uq2XgZJf0rQaRWpMgV5slzw1CwmT2uGxa9VUVgvCX1yEeskcPn02fUKljijlnCattCE9MjF779cI0bOrZgED1LG4gGl26jt0bzedZXK268pHjaUAwhK9W4rwWPqIp8RNbq-1-N_nWnnUZJbUSfiYKWQ17xSJNW9ylOlTCVZADPqwZeeHGpyfQ5knPpF3HxxRjI9xIwGJsepI3_Vjyw-drF9vFM2bPqccKY8ERLxlWSBXYaMT1sw16zSRY9FXmDHkN8br4Qp7kyIx0Gh5OZvNt08imUBnMXzh4K8nEmm_20eFhEQLdGs1yHkWY0EDXlRbkO9bRbytF70dqboPuNsIXCWmcRaECtY6Bzq3UfXLUetmtYmX979ECkyY83NTZvrNZemkfkyGDsRkTSBZVk6QDhnCWpGbbCXKWb8mgNUw9BDQazzLImwebiXKqR8guWMgRqVjEDVbA76dgIrMDeZo9ZhzwpxdiuzUOh7WfTxER01OS578mB7qYdf0pQZ_y-5aNoK5jKnr3xTB10A-bSNFRMELJgI8TQVMaQAkV9uL6k6SYFlbllK7XOOhjxSS_02VbxtpW-AzpvNDFM-Oq6q6rqzblx2bVxRbljS-larkQQ1l8zsq5soR9rbwVZ_Xw6NfhSym6wb0y1SbRvqsrkYLY-5D_kutuP-n6ux41hV7M")
    @POST("/api/products")
    fun postNewProduct(@Body productPost: PostProduct): Call<PostProduct>

    @Headers("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOWQzYzdkZmJmZDE0OTM2ZGJlMmE1MGFhZjYwZTM3NzA2OGI0YmRjNzFhYTNiNzYzNDc3NjNjMDM4NjQ1ZGVkYjVjOTk1YmQ3ZjVhOWQyYmIiLCJpYXQiOjE2NDQ0MzE5ODcuNTM1NTk1LCJuYmYiOjE2NDQ0MzE5ODcuNTM1NiwiZXhwIjoxNjc1OTY3OTg3LjUyNTk4NCwic3ViIjoiMSIsInNjb3BlcyI6W119.Y8uq2XgZJf0rQaRWpMgV5slzw1CwmT2uGxa9VUVgvCX1yEeskcPn02fUKljijlnCattCE9MjF779cI0bOrZgED1LG4gGl26jt0bzedZXK268pHjaUAwhK9W4rwWPqIp8RNbq-1-N_nWnnUZJbUSfiYKWQ17xSJNW9ylOlTCVZADPqwZeeHGpyfQ5knPpF3HxxRjI9xIwGJsepI3_Vjyw-drF9vFM2bPqccKY8ERLxlWSBXYaMT1sw16zSRY9FXmDHkN8br4Qp7kyIx0Gh5OZvNt08imUBnMXzh4K8nEmm_20eFhEQLdGs1yHkWY0EDXlRbkO9bRbytF70dqboPuNsIXCWmcRaECtY6Bzq3UfXLUetmtYmX979ECkyY83NTZvrNZemkfkyGDsRkTSBZVk6QDhnCWpGbbCXKWb8mgNUw9BDQazzLImwebiXKqR8guWMgRqVjEDVbA76dgIrMDeZo9ZhzwpxdiuzUOh7WfTxER01OS578mB7qYdf0pQZ_y-5aNoK5jKnr3xTB10A-bSNFRMELJgI8TQVMaQAkV9uL6k6SYFlbllK7XOOhjxSS_02VbxtpW-AzpvNDFM-Oq6q6rqzblx2bVxRbljS-larkQQ1l8zsq5soR9rbwVZ_Xw6NfhSym6wb0y1SbRvqsrkYLY-5D_kutuP-n6ux41hV7M")
    @GET("/api/products")
    fun getProductsData(): Call<ReturnedResults<PostProduct>>

}