package com.example.androidversions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.VersionViewHolder> {

    private List<AndroidVersion> versionList;


    public AndroidAdapter(List<AndroidVersion> versionList) {
        this.versionList = versionList;
    }

    @NonNull
    @Override
    public VersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_version, parent, false);
        return new VersionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionViewHolder holder, int position) {
        AndroidVersion currentVersion = versionList.get(position);

        holder.txtCodeName.setText(currentVersion.codeName);
        holder.txtVersion.setText("Version: " + currentVersion.version);
        holder.imgLogo.setImageResource(currentVersion.imageResId);


        if (position % 2 == 0) {

            holder.itemView.setBackgroundColor(android.graphics.Color.parseColor("#F5F5F5"));
        } else {

            holder.itemView.setBackgroundColor(android.graphics.Color.parseColor("#FFFFFF"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "You selected: " + currentVersion.codeName + " (" + currentVersion.version + ")";
                android.widget.Toast.makeText(v.getContext(), message, android.widget.Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }


    public static class VersionViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtCodeName;
        TextView txtVersion;

        public VersionViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgLogo);
            txtCodeName = itemView.findViewById(R.id.txtCodeName);
            txtVersion = itemView.findViewById(R.id.txtVersion);
        }
    }
}
