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

public class Theatre extends AppCompatActivity {

    private RecyclerView invoiceRecyclerView;
    private InvoiceAdapter invoiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre);

        invoiceRecyclerView = findViewById(R.id.invoiceRecyclerView);
        invoiceRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Заполните список счетов-фактур (можно использовать данные из базы данных)
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, "Большой театр", "Театральная площадь, 1", "+7 (495) 692-83-43"));
        invoices.add(new Invoice(2, "Малый театр", "Театральная площадь, 1/6", "+7 (495) 628-98-53"));
        invoices.add(new Invoice(3, "МХАТ имени А.П. Чехова", "Камергерский переулок, 3","+7 (495) 692-94-50"));
        invoices.add(new Invoice(4, "Театр имени Е.Б. Вахтангова", "Арбат, 26", "+7 (495) 699-62-50"));
        invoices.add(new Invoice(5, "Театр \"Современник\"", "Чистые пруды, 19а", "+7 (495) 621-96-37"));


        invoiceAdapter = new InvoiceAdapter(invoices);
        invoiceRecyclerView.setAdapter(invoiceAdapter);
    }

    // Класс модели для счета-фактуры
    private class Invoice {
        int id;
        String name;
        String adress;
        String phone;

        public Invoice(int id, String name, String adress, String phone) {
            this.id = id;
            this.name = name;
            this.adress = adress;

            this.phone = phone;
        }
    }

    // Адаптер для RecyclerView для счетов-фактур
    private static class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.ViewHolder> {

        private List<Invoice> invoices;

        public InvoiceAdapter(List<Invoice> invoices) {
            this.invoices = invoices;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.theatre, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Invoice invoice = invoices.get(position);
            holder.idTextView.setText("ID: " + invoice.id);
            holder.nameTextView.setText("Название: " + invoice.name);
            holder.adressTextView.setText("Адрес: " + invoice.adress);
            holder.phoneTextView.setText("Телефон: " + invoice.phone);
        }

        @Override
        public int getItemCount() {
            return invoices.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView idTextView;
            TextView nameTextView;
            TextView adressTextView;
            TextView phoneTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                idTextView = itemView.findViewById(R.id.idTextView);
                nameTextView = itemView.findViewById(R.id.nameTextView);
                adressTextView = itemView.findViewById(R.id.adressTextView);
                phoneTextView = itemView.findViewById(R.id.phoneTextView);
            }
        }
    }
}
