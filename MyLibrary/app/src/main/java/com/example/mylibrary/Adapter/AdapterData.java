package com.example.mylibrary.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylibrary.API.APIRequestData;
import com.example.mylibrary.API.RetroServer;
import com.example.mylibrary.Activity.MainActivity;
import com.example.mylibrary.Activity.UbahActivity;
import com.example.mylibrary.Model.DataModel;
import com.example.mylibrary.Model.ResponseModel;
import com.example.mylibrary.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<DataModel> listdata;
    private int idLibrary;
    private List<DataModel> listBuku;

    public AdapterData(Context ctx, List<DataModel> listdata) {
        this.ctx = ctx;
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listdata.get(position);
        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvJudul.setText(dm.getJudul());
        holder.tvPengarang.setText(dm.getPengarang());
        holder.tvPenerbit.setText(dm.getPenerbit());
        holder.tvTahun.setText(String.valueOf(dm.getTahun()));
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvId,tvJudul, tvPengarang, tvPenerbit, tvTahun;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvPengarang = itemView.findViewById(R.id.tv_pengarang);
            tvPenerbit = itemView.findViewById(R.id.tv_penerbit);
            tvTahun = itemView.findViewById(R.id.tv_tahun);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Pilih Operasi yang Akan Dilakukan");
                    dialogPesan.setCancelable(true);
                    idLibrary = Integer.parseInt(tvId.getText().toString());

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteData();
                            dialogInterface.dismiss();
                            ((MainActivity) ctx).retrieveData();
                        }

                        private void deleteData() {
                            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
                            Call<ResponseModel> hapusData = ardData.ardDeleteData(idLibrary);
                            hapusData.enqueue(new Callback<ResponseModel>() {
                                @Override
                                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                                    int kode = response.body().getKode();
                                    String pesan = response.body().getPesan();

                                    Toast.makeText(ctx, "Kode : "+kode+"| Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<ResponseModel> call, Throwable t) {
                                    Toast.makeText(ctx, "Gagal Menghubungkan Server |"+t.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });

                    dialogPesan.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getData();
                            dialogInterface.dismiss();
                        }
                    });

                    dialogPesan.show();
                    return false;
                }
            });
        }

        private void getData() {
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> ambilData = ardData.ardGetData(idLibrary);
            ambilData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();
                    listBuku = response.body().getData();

                    int varIdBuku = listBuku.get(0).getId();
                    String varJudulBuku = listBuku.get(0).getJudul();
                    String varPengarang = listBuku.get(0).getPengarang();
                    String varPenerbit = listBuku.get(0).getPenerbit();
                    int varTahun = listBuku.get(0).getTahun();

                    Intent kirim = new Intent(ctx, UbahActivity.class);
                    kirim.putExtra("xId",varIdBuku);
                    kirim.putExtra("xJudul",varJudulBuku);
                    kirim.putExtra("xPengarang",varPengarang);
                    kirim.putExtra("xPenerbit",varPenerbit);
                    kirim.putExtra("xTahun",varTahun);
                    ctx.startActivity(kirim);

                    Toast.makeText(ctx, "Kode : "+kode+"| Pesan : "+pesan+"| Data : "+varJudulBuku+" | "+varPengarang+" | "+varPenerbit+" | "+varTahun, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungkan Server |"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
