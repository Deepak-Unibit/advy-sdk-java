package com.example.advy_sdk_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.advy_sdk_java.databinding.ActivityMainBinding;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import me.advy.sdk.Advy;

public class MainActivity extends AppCompatActivity implements Advy.Callback {

private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("intent.getData()");
        setContentView(R.layout.activity_main);

        // Create an Intent object
        Intent intent = getIntent();

        // Production
//        Advy.init("x6eb6oo1ykqvd4vc", "teufhx6nodzd13l2sikr", this, intent);

        // Development
        Advy.init("zvv0unhlqypxfo37", "r8_0rae4g0ccg7kuvayr", this, intent);
//        System.out.println(intent.getData());


//        Advy.setId("123456");
        System.out.println("isInitialized" + Advy.isInitialized());
        Advy.getDeepLinkData(this);



        Button myButton = findViewById(R.id.my_button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("kldkldj");
                Map<String, Object> properties = new HashMap<>();
                properties.put("amount", 100);
                Advy.event("deposit", properties);
                Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDeepLinkDataInitialized(JSONObject jsonObject) {
        System.out.println("onDeepLinkDataInitialized");
        System.out.println(jsonObject);
    }
}