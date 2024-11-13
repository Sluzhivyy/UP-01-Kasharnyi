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

public class Actor extends AppCompatActivity {

    private RecyclerView workRecyclerView;
    private WorkAdapter workAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        workRecyclerView = findViewById(R.id.workRecyclerView);
        workRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Data for theatre personnel (replace with your actual data)
        List<Work> works = new ArrayList<>();
        works.add(new Work(1, "Иван", "Иванов"," ivan_ivanov", "Заслуженный артист РФ"));
        works.add(new Work(2, "Петр", "Петров", "petr_petrov", "Народный артист РФ"));
        works.add(new Work(3, "Мария", "Сидорова", "maria_sidorova", "Восходящая звезда театра"));
        works.add(new Work(4, "Елена", "Кузнецова","elena_kuznetsova", "Талантливая молодая актриса"));
        works.add(new Work(5, "Сергей", "Волков","sergey_volkov", "Опытный актер с большим репертуаром"));

        workAdapter = new WorkAdapter(works);
        workRecyclerView.setAdapter(workAdapter);
    }

    // Model for theatre personnel
    private class Work {
        int id;
        String name;
        String SecondN;
        String Photo;
        String Bio;

        public Work(int id, String name, String SecondN, String Photo, String Bio) { // Измените параметр Photo на int
            this.id = id;
            this.name = name;
            this.SecondN = SecondN;
            this.Photo = Photo;
            this.Bio = Bio;
        }
    }

    // RecyclerView Adapter
    private static class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

        private List<Work> works;

        public WorkAdapter(List<Work> works) {
            this.works = works;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.actor, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Work work = works.get(position);
            holder.idTextView.setText("ID: " + work.id);
            holder.nameTextView.setText(work.name + " " + work.SecondN);
            holder.bioTextView.setText(work.Bio);
            holder.photoTextView.setText(work.Photo); // Установите изображение из ресурса
        }

        @Override
        public int getItemCount() {
            return works.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView idTextView;
            TextView nameTextView;
            TextView bioTextView;
            TextView photoTextView; // Добавьте ImageView

            public ViewHolder(View itemView) {
                super(itemView);
                idTextView = itemView.findViewById(R.id.idTextView);
                nameTextView = itemView.findViewById(R.id.nameTextView);
                bioTextView = itemView.findViewById(R.id.bioTextView);
                photoTextView = itemView.findViewById(R.id.photoTextView);
            }
        }
    }
}
