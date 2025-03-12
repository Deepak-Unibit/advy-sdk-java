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
        Advy.init("es7ot967el3lqoao", "ud63gc2r0sgp06yty-c6", this, intent, this);

        // Development
//        Advy.init("zvv0unhlqypxfo37", "r8_0rae4g0ccg7kuvayr", this, intent);
//        System.out.println(intent.getData());


//        Advy.setId("123456");
        System.out.println("isInitialized" + Advy.isInitialized());
        Advy.getDeepLinkData(this);



        Button depositButton = findViewById(R.id.deposit_btn);
        Button withdrawButton = findViewById(R.id.withdraw_btn);

        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> properties = new HashMap<>();
                properties.put("amount", 100);
                properties.put("type", "deposit");
                System.out.println(properties);
                Advy.event("revenue", properties);

                Toast.makeText(MainActivity.this, "Deposit Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> properties = new HashMap<>();
                properties.put("amount", 100);
                properties.put("type", "withdraw");
                System.out.println(properties);
                Advy.event("revenue", properties);

                Toast.makeText(MainActivity.this, "Withdraw Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDeepLinkDataInitialized(JSONObject jsonObject) {
        System.out.println("onDeepLinkDataInitialized");
        System.out.println(jsonObject);
    }

    @Override
    public void onInitialized(boolean b) {

    }
}