package com.example.apiconnectdesign.ui.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiconnectdesign.api.model.Province;
import com.example.apiconnectdesign.databinding.ViewHolderProvinceBinding;
import com.squareup.picasso.Picasso;

//adapter used for create item(ViewHolder) of data that we get from model and then it well be give this item to layout-manager for create layout-view
// in adapter it must be has ViewHolder and Model
public class ProvincesAdapter extends ListAdapter<Province, ProvincesAdapter.ProvincesViewHolder> {

    public ProvincesAdapter() {
        super(
                new DiffUtil.ItemCallback<Province>() {
                    @Override
                    public boolean areItemsTheSame(@NonNull Province oldItem, @NonNull Province newItem) {
                        return oldItem == newItem;
                    }

                    @Override
                    public boolean areContentsTheSame(@NonNull Province oldItem, @NonNull Province newItem) {
                        return oldItem.getId() == newItem.getId();
                    }
                }
        );
    }

    @NonNull
    @Override
    public ProvincesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //implement view-holder
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolderProvinceBinding binding = ViewHolderProvinceBinding.inflate(layoutInflater,parent,false);
        return new ProvincesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvincesViewHolder holder, int position) {

        //bind data into view-holder that created above
        Province item = getItem(position);
        holder.bind(item);


    }

    //Create ViewHolder
    public static class ProvincesViewHolder extends RecyclerView.ViewHolder{

        //create obj binding
        private final ViewHolderProvinceBinding itemBinding;
        public ProvincesViewHolder(ViewHolderProvinceBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        //function bind data
        public void bind(Province province){
            Picasso.get().load(province.getImageUrl()).into(itemBinding.idImgProvince);
            itemBinding.idTxtProvinceName.setText(province.getName());
        }
    }
}
