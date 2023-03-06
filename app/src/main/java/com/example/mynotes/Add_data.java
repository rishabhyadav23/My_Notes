package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mynotes.databinding.ActivityAddDataBinding;

public class Add_data extends AppCompatActivity {
    ActivityAddDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type = getIntent().getStringExtra("type");
        if(type.equals("update")){
            setTitle("update");
            binding.mytitle.setText(getIntent().getStringExtra("title"));
            binding.myContent.setText(getIntent().getStringExtra("content"));
            int id = getIntent().getIntExtra("id",0);
            binding.button.setText("Update");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title",binding.mytitle.getText().toString());
                    intent.putExtra("content",binding.myContent.getText().toString());
                    intent.putExtra("id",id);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        }else{
            setTitle("addNote");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title",binding.mytitle.getText().toString());
                    intent.putExtra("content",binding.myContent.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Add_data.this,MainActivity.class));
    }
}