package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    private TextView tvTitle, tvAuthor, tvPageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvTitle = findViewById(R.id.tvTitle);
        tvAuthor = findViewById(R.id.tvAuthor);
        tvPageCount = findViewById(R.id.tvPageCount);

        // Отримати дані з Intent
        Intent intent = getIntent();
        if (intent != null) {
            Book book = intent.getParcelableExtra("book");
            if (book != null) {
                // Відобразити дані
                tvTitle.setText("Title: " + book.getTitle());
                tvAuthor.setText("Author: " + book.getAuthor());
                tvPageCount.setText("Page Count: " + book.getPageCount());
            }
        }
    }
}
