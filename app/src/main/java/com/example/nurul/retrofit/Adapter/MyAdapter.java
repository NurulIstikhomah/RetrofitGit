package com.example.nurul.retrofit.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;

import com.example.nurul.retrofit.Model.Pembelian;
import com.example.nurul.retrofit.R;
import com.example.nurul.retrofit.LayarDetail;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Pembelian> mPembelianList;
    public MyAdapter(List<Pembelian> pembelianList) {
        mPembelianList = pembelianList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewIdPembelian.setText("Id Pembelian : " +
                mPembelianList.get(position)
                        .getId_pembelian());
        holder.mTextViewIdPembeli.setText("Id Pembeli : " + mPembelianList.get(position)
                .getId_pembeli());
        holder.mTextViewIdTiket.setText("Id Tiket : " +
                mPembelianList.get(position).getId_tiket
                        ());
        holder.mTextViewTanggal.setText("Tanggal Beli : " + mPembelianList.get(position)
                .getTanggal_beli());
        holder.mTextViewTotalHarga.setText("Total Harga : " +
                String.valueOf(mPembelianList.get
                        (position).getTotal_harga()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent =  new Intent(view.getContext(), LayarDetail.class);
                mIntent.putExtra("id_pembelian", mPembelianList.get(position).getId_pembelian());
                mIntent.putExtra("id_pembeli", mPembelianList.get(position).getId_pembeli());
                mIntent.putExtra("tanggal_beli", mPembelianList.get(position).getTanggal_beli());
                mIntent.putExtra("id_tiket", mPembelianList.get(position).getId_tiket());
                mIntent.putExtra("total_harga",String.valueOf(mPembelianList.get(position).getTotal_harga()));
                view.getContext().startActivity(mIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mPembelianList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdPembelian, mTextViewIdPembeli,
                mTextViewTanggal,mTextViewIdTiket,mTextViewTotalHarga;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdPembelian = (TextView) itemView.findViewById(R.id.tvIdPembelian);
            mTextViewIdPembeli = (TextView) itemView.findViewById(R.id.tvIdPembeli);
            mTextViewTanggal = (TextView) itemView.findViewById(R.id.tvTanggalBeli);
            mTextViewIdTiket = (TextView) itemView.findViewById(R.id.tvIdTiket);
            mTextViewTotalHarga = (TextView) itemView.findViewById(R.id.tvTotalHarga);
        }
    }
}