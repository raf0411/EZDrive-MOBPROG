package id.ac.binus.myapplication.viewHolders;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.binus.myapplication.R;
import id.ac.binus.myapplication.models.Car;
import id.ac.binus.myapplication.views.CarDetailsView;

public class CarViewHolder extends RecyclerView.ViewHolder {
    public ImageView carImg;
    public TextView carBrand;
    public TextView carPricePerDay;
    public TextView availability;
    public ImageButton editCarBtn;
    public ImageButton deleteCarBtn;

    public CarViewHolder(@NonNull View itemView, String username) {
        super(itemView);

        this.carImg = itemView.findViewById(R.id.carImgData);
        this.carBrand = itemView.findViewById(R.id.carNameData);
        this.carPricePerDay = itemView.findViewById(R.id.carPriceData);
        this.availability = itemView.findViewById(R.id.carAvailabilityData);

        this.editCarBtn = itemView.findViewById(R.id.editCarBtn);
        this.deleteCarBtn = itemView.findViewById(R.id.deleteCarBtn);

        if (!username.equalsIgnoreCase("admin")) {
            editCarBtn.setVisibility(View.GONE);
            deleteCarBtn.setVisibility(View.GONE);
        }
    }

    public void bind(Car car) {
        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(itemView.getContext(), CarDetailsView.class);

            intent.putExtra("carId", car.getCarId());
            intent.putExtra("carImg", car.getCarImg());
            intent.putExtra("carBrand", car.getBrand());
            intent.putExtra("carModel", car.getModel());
            intent.putExtra("carHost", car.getHostName());
            intent.putExtra("carLocation", car.getLocation());
            intent.putExtra("carPricePerDay", car.getPricePerDay());
            intent.putExtra("carDescription", car.getDescription());
            intent.putExtra("carSeats", car.getSeats());
            intent.putExtra("carTransmission", car.getTransmission());
            intent.putExtra("carRules", car.getRules());

            itemView.getContext().startActivity(intent);
        });
    }
}
