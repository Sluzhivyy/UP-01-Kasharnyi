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

public class Post extends AppCompatActivity {

    private RecyclerView vehiclesRecyclerView;
    private VehiclesAdapter vehiclesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        vehiclesRecyclerView = findViewById(R.id.vehiclesRecyclerView);
        vehiclesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Заполните список транспортных средств (можно использовать данные из базы данных)
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1, "Лебединое озеро (классическая версия)", "Иван Иванов", "2023-03-05", 1));
        vehicles.add(new Vehicle(2, "Лебединое озеро (современная версия)", "Петр Петров", "2022-06-01", 1));
        vehicles.add(new Vehicle(3, "Щелкунчик (традиционная хореография)", "Мария Сидорова", "2021-12-25", 2));
        vehicles.add(new Vehicle(4, "Щелкунчик (новая хореография)", "Елена Кузнецова", "2019-12-31", 2));
        vehicles.add(new Vehicle(5, "Ревизор (постановка 20 века)", "Сергей Волков", "2020-01-10", 3));
        vehicles.add(new Vehicle(6, "Ревизор (постановка 20 века)", "Иван Иванов", "2023-04-01", 3));
        vehicles.add(new Vehicle(7, "Горе от ума (классическая версия)", "Петр Петров", "2022-05-01", 4));
        vehicles.add(new Vehicle(8, "Горе от ума (современная версия)", "Мария Сидорова", "2021-09-01", 4));
        vehicles.add(new Vehicle(9, "Чайка (трагическая версия)", "Елена Кузнецова", "2020-07-01", 5));
        vehicles.add(new Vehicle(10, "Чайка (лирическая версия)", "Сергей Волков", "2019-06-01", 5));
        vehicles.add(new Vehicle(11, "Три сестры (реалистичная версия)", "Иван Иванов", "2023-05-01", 6));
        vehicles.add(new Vehicle(12, "Три сестры (символическая версия)", "Петр Петров", "2022-07-01", 6));
        vehicles.add(new Vehicle(13, "Евгений Онегин (традиционная версия)", "Мария Сидорова", "2021-11-01", 7));
        vehicles.add(new Vehicle(14, "Евгений Онегин (осовремененная версия)", "Елена Кузнецова", "2020-08-01", 7));
        vehicles.add(new Vehicle(15, "Пиковая дама (психологическая версия)", "Сергей Волков", "2019-10-01", 8));
        vehicles.add(new Vehicle(16, "Пиковая дама (мистическая версия)", "Иван Иванов", "2023-06-01", 8));
        vehicles.add(new Vehicle(17, "Мастер и Маргарита (постановка 20 века)", "Петр Петров", "2021-06-01", 9));
        vehicles.add(new Vehicle(18, "Мастер и Маргарита (постановка 20 века)", "Мария Сидорова", "2023-07-01", 9));



        vehiclesAdapter = new VehiclesAdapter(vehicles);
        vehiclesRecyclerView.setAdapter(vehiclesAdapter);
    }

    // Класс модели для транспортного средства
    private class Vehicle {
        int id;
        String make;
        String model;
        String year;

        int PerfId;

        public Vehicle(int id, String make, String model, String  year,int PerfId) {
            this.id = id;
            this.make = make;
            this.model = model;
            this.year = year;
            this. PerfId = PerfId;
        }
    }

    // Адаптер для RecyclerView для транспортных средств
    private static class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder> { // Обратите внимание на "static"

        private List<Vehicle> vehicles;

        public VehiclesAdapter(List<Vehicle> vehicles) {
            this.vehicles = vehicles;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.spec, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Vehicle vehicle = vehicles.get(position);
            holder.idTextView.setText("ID: " + vehicle.id);
            holder.makeTextView.setText("Название: " + vehicle.make);
            holder.modelTextView.setText("Автор: " + vehicle.model);
            holder.yearTextView.setText("Дата: " + vehicle.year);
            holder.PerfTextView.setText("Жанр: " + vehicle.PerfId);
        }

        @Override
        public int getItemCount() {
            return vehicles.size();
        }

        // Внутренний класс ViewHolder для хранения ссылок на представления в элементе списка
        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView idTextView;
            TextView makeTextView;
            TextView modelTextView;
            TextView yearTextView;
            TextView PerfTextView;

            ViewHolder(View itemView) {
                super(itemView);
                idTextView = itemView.findViewById(R.id.vehicleIdTextView);
                makeTextView = itemView.findViewById(R.id.vehicleMakeTextView);
                modelTextView = itemView.findViewById(R.id.vehicleModelTextView);
                yearTextView = itemView.findViewById(R.id.vehicleYearTextView);
                PerfTextView = itemView.findViewById(R.id.whatTextView);
            }
        }
    }
}
