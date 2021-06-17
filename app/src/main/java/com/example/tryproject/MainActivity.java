package com.example.tryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.tryproject.util.OkhttpHelper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request;
import okhttp3.ResponseBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRequest();
//        run();
    }

    void run( )  {
        String url="http://10.192.21.194/polls/trial";

        Retrofit.Builder builder=new Retrofit.Builder();
        Retrofit retrofit=builder.baseUrl(url).addConverterFactory(ScalarsConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);



//        Request request = new Request.Builder()
//                .url(url)
//                .build();

//        //String
//        Call<String> content=api.fetchContents();
//        content.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i("111111","onResponse"+response.body());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.i("111111","onFailure",t);
//
//
//            }
//        });


//        //responsebody
//        Call<ResponseBody> call = api.getBlog(2);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    System.out.println(response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });




//        try (Response response = client.newCall(request).execute()) {
//            Log.i("cc", response.body().string());
//        } catch (Exception e){
//            Log.i("cc", "exception "+e.getLocalizedMessage());
//
//        }

//        RequestBody body = RequestBody.create(JSON, "");
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {//失败回调
//                Log.i("cc","onFailure:"+e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {//成功回调
//                Log.i("cc","onResponse:"+response.body().string());
//            }
//        });



    }

    private void initRequest(){
        String url="http://10.0.2.2:8000/polls/trial/";
        OkhttpHelper.getRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {//失败回调
                Log.i("111111","onFailure:"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {//成功回调
                Log.i("111112","onResponse:"+response.body().string());
            }
        });



        FormBody.Builder builder=new FormBody.Builder();
        OkhttpHelper.postRequest(url, builder, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("111112","onResponse:"+response.body().string());
            }
        });
    }

}