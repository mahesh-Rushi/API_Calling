package com.example.fragment_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  Apiinterface apiinterface;
  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiinterface = retrofitinstance.getRetrofit().create(Apiinterface.class);
//        recyclerView.findViewById(R.id.recycleview);

        apiinterface.getPosts().enqueue(new Callback<List<Postpojo>>() {
            @Override
            public void onResponse(Call<List<Postpojo>> call, Response<List<Postpojo>> response) {

                if (response.body().size()>0){
                    Toast.makeText(MainActivity.this,"List is not Empty "+response.body(),Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(MainActivity.this,"List is Empty",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Postpojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}