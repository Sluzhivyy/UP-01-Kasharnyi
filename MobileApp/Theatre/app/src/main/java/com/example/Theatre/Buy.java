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

public class Buy extends AppCompatActivity {

    private RecyclerView serviceTypeRecyclerView;
    private ServiceTypeAdapter serviceTypeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_type);

        serviceTypeRecyclerView = findViewById(R.id.serviceTypeRecyclerView);
        serviceTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<ServiceType> serviceTypes = new ArrayList<>();
        serviceTypes.add(new ServiceType(1, 1, 1000.00));
        serviceTypes.add(new ServiceType(2, 1, 1200.00));
        serviceTypes.add(new ServiceType(3, 1, 1500.00));
        serviceTypes.add(new ServiceType(4, 2, 800.00));
        serviceTypes.add(new ServiceType(5, 2, 1000.00));
        serviceTypes.add(new ServiceType(6, 2, 1200.00));
        serviceTypes.add(new ServiceType(7, 3, 700.00));
        serviceTypes.add(new ServiceType(8, 3, 900.00));
        serviceTypes.add(new ServiceType(9, 3, 1100.00));
        serviceTypes.add(new ServiceType(10, 4, 800.00));
        serviceTypes.add(new ServiceType(11, 4, 1000.00));
        serviceTypes.add(new ServiceType(12, 4, 1200.00));
        serviceTypes.add(new ServiceType(13, 5, 1200.00));
        serviceTypes.add(new ServiceType(14, 5, 1500.00));
        serviceTypes.add(new ServiceType(15, 5, 1800.00));
        serviceTypes.add(new ServiceType(16, 6, 1000.00));
        serviceTypes.add(new ServiceType(17, 6, 1200.00));
        serviceTypes.add(new ServiceType(18, 6, 1500.00));
        serviceTypes.add(new ServiceType(19, 7, 900.00));
        serviceTypes.add(new ServiceType(20, 7, 1100.00));
        serviceTypes.add(new ServiceType(21, 7, 1300.00));
        serviceTypes.add(new ServiceType(22, 8, 1000.00));
        serviceTypes.add(new ServiceType(23, 8, 1200.00));
        serviceTypes.add(new ServiceType(24, 8, 1500.00));
        serviceTypes.add(new ServiceType(25, 9, 1500.00));
        serviceTypes.add(new ServiceType(26, 9, 1800.00));
        serviceTypes.add(new ServiceType(27, 9, 2000.00));
        serviceTypes.add(new ServiceType(28, 10, 1200.00));
        serviceTypes.add(new ServiceType(29, 10, 1500.00));
        serviceTypes.add(new ServiceType(30, 10, 1800.00));

        serviceTypeAdapter = new ServiceTypeAdapter(serviceTypes);
        serviceTypeRecyclerView.setAdapter(serviceTypeAdapter);
    }

    // Класс модели для типа услуги
    private class ServiceType {
        int id;
        int постановкиId;
        double price;

        public ServiceType(int id, int постановкиId, double price) {
            this.id = id;
            this.постановкиId = постановкиId;
            this.price = price;
        }
    }

    // Адаптер для RecyclerView для типов услуг
    private static class ServiceTypeAdapter extends RecyclerView.Adapter<ServiceTypeAdapter.ViewHolder> {

        private List<ServiceType> serviceTypes;

        public ServiceTypeAdapter(List<ServiceType> serviceTypes) {
            this.serviceTypes = serviceTypes;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.buy, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ServiceType serviceType = serviceTypes.get(position);
            holder.idTextView.setText("ID: " + serviceType.id);
            holder.nameTextView.setText("Постановка ID: " + serviceType.постановкиId);
            holder.priceTextView.setText("Цена: " + serviceType.price);
        }

        @Override
        public int getItemCount() {
            return serviceTypes.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView idTextView;
            TextView nameTextView;
            TextView priceTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                idTextView = itemView.findViewById(R.id.idTextView);
                nameTextView = itemView.findViewById(R.id.nameTextView);
                priceTextView = itemView.findViewById(R.id.priceTextView);
            }
        }
    }
}
