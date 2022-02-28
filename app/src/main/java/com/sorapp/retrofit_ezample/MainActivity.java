package com.sorapp.retrofit_ezample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sorapp.retrofit_ezample.model.user_interface;
import com.sorapp.retrofit_ezample.model.user_model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{

    String url="https://rezafarazi.github.io/Online_Json_Api/user_example.json";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void GetOnclick_On_Click_Me_Button(View v)
    {
        TextView id=(TextView) findViewById(R.id.id);
        TextView name=(TextView) findViewById(R.id.name);
        TextView family=(TextView) findViewById(R.id.family);
        TextView username=(TextView) findViewById(R.id.username);

        Toast.makeText(getApplicationContext(), "Get Start", Toast.LENGTH_SHORT).show();
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rezafarazi.github.io/Online_Json_Api/")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();

        user_interface retrofitAPI = retrofit.create(user_interface.class);
        user_model modal = new user_model(1,"Reza","Farazi","RezaFaraz123");
        Call<user_model> user=retrofitAPI.GetUser();
        user.enqueue(new Callback<user_model>() {
            @Override
            public void onResponse(Call<user_model> call, Response<user_model> response)
            {
                try
                {
                    id.setText(response.body().getId()+"");
                    name.setText(response.body().getName().toString());
                    family.setText(response.body().getFamily().toString());
                    username.setText(response.body().getUsername().toString());
                }
                catch (Exception e)
                {
                    id.setText(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<user_model> call, Throwable t)
            {
                id.setText("Error");
                name.setText("Error");
                family.setText("Error");
                username.setText("Error");
            }
        });



    }


}