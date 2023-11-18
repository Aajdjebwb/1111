package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etTitle, etAuthor, etPageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etAuthor = findViewById(R.id.etAuthor);
        etPageCount = findViewById(R.id.etPageCount);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Отримати дані з віджетів
                String title = etTitle.getText().toString();
                String author = etAuthor.getText().toString();
                String pageCountText = etPageCount.getText().toString();

                // Перевірка на відповідність введеного тексту до типу даних
                int pageCount;
                try {
                    pageCount = Integer.parseInt(pageCountText);
                } catch (NumberFormatException e) {
                    // Виведення варнінга у випадку помилки перетворення на int
                    Toast.makeText(MainActivity.this, "Неправильний формат кількості сторінок", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Створити об'єкт Book
                Book book = new Book();
                book.setTitle(title);
                book.setAuthor(author);
                book.setPageCount(pageCount);

                // Створити намір для запуску другої Activity
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

                // Передати об'єкт "Book" через Intent
                intent.putExtra("book", book);

                // Запустити другу Activity
                startActivity(intent);
            }
        });
    }
}
