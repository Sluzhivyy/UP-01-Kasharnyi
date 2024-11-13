package com.example.Theatre;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.theatre.R;

import java.util.ArrayList;
import java.util.List;

public class Spec extends AppCompatActivity {

    private RecyclerView partsRecyclerView;
    private PartsAdapter partsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);

        partsRecyclerView = findViewById(R.id.partsRecyclerView);
        partsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Заполните список запчастей (можно использовать данные из базы данных)
        List<Part> parts = new ArrayList<>();
        parts.add(new Part(1, "Лебединое озеро", "Классический балет в 3-х действиях", "Балет",1));
        parts.add(new Part(2, "Щелкунчик", "Рождественская сказка-балет в 2-х действиях", "Балет",1));
        parts.add(new Part(3, "Ревизор", "Комедия в 5-ти действиях", "Драма",2));
        parts.add(new Part(4, "Горе от ума", "Комедия", "Драма",2));
        parts.add(new Part(5, "Чайка", "Пьеса в 4-х действиях", "Драма",3));
        parts.add(new Part(6, "Три сестры", "Драма в 4-х действиях", "Драма",3));
        parts.add(new Part(7, "Евгений Онегин", "Лирические сцены в 3-х действиях", "Опера",4));
        parts.add(new Part(8, "Пиковая дама", "Опера в 3-х действиях", "Опера",4));
        parts.add(new Part(9, "Мастер и Маргарита", "Мистический роман в 2-х частях", "Драма",5));

        partsAdapter = new PartsAdapter(parts);
        partsRecyclerView.setAdapter(partsAdapter);
    }

    // Класс модели для запчасти
    private class Part {
        int id;
        String name;
        String description;
        String what;
        int TheatreId;

        public Part(int id, String name, String description, String what, int TheatreId) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.what = what;
            this.TheatreId = TheatreId;
        }
    }

    // Адаптер для RecyclerView для запчастей
    private static class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.ViewHolder> {
        private List<Part> parts;

        public PartsAdapter(List<Part> parts) {
            this.parts = parts;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.post, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Part part = parts.get(position);
            holder.idTextView.setText("ID: " + part.id);
            holder.nameTextView.setText("Название: " + part.name);
            holder.descriptionTextView.setText("Описание: " + part.description);
            holder.whatTextView.setText("Жанр: " + part.what);
            holder.TheatreIdTextView.setText("ТеатрID: " + part.TheatreId);
        }

        @Override
        public int getItemCount() {
            return parts.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView idTextView;
            TextView nameTextView;
            TextView descriptionTextView;
            TextView whatTextView;
            TextView TheatreIdTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                idTextView = itemView.findViewById(R.id.idTextView);
                nameTextView = itemView.findViewById(R.id.nameTextView);
                descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
                whatTextView = itemView.findViewById(R.id.whatTextView);
                TheatreIdTextView = itemView.findViewById(R.id.TheatreIdTextView);
            }
        }
    }
}
