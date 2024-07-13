package com.example.sportfinder.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportfinder.R;
import com.example.sportfinder.data.localdatabase.Localizacao;

import java.util.List;

public class LocalizacaoAdapter extends RecyclerView.Adapter<LocalizacaoAdapter.LocalizacaoViewHolder> {


    private List<Localizacao> localizacaoList;

    public LocalizacaoAdapter(List<Localizacao> localizacaoList) {
        this.localizacaoList = localizacaoList;
    }

    /**
     * Criar um novo ViewHolder sempre que for necessário
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public LocalizacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.localizacao_activity,parent, false);
        return new LocalizacaoViewHolder(rootView);
    }


    /**
     * Permite associar a um ViewHolder dados de um item da lista
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull LocalizacaoViewHolder holder, int position) {
        Localizacao localizacao = this.localizacaoList.get(position);
        holder.spot_name.setText(localizacao.getSpot_name());
        Glide.with(holder.rootView.getContext()).load(localizacao.getAvatar()).into(holder.avatar);
        holder.localizacao_text_view.setText(localizacao.getLocalizacao_text_view());
        holder.web_site.setText(localizacao.getWeb_site());
        holder.telefone_text_view.setText(localizacao.getTelefone_text_view());
        holder.tipo.setText(localizacao.gettipo());
    }

    /**
     * Devolver o número de Items que a RecyclerView deve apresentar
     *
     * @return numero de items da recyclerView
     */
    @Override
    public int getItemCount() {
        return this.localizacaoList.size();
    }

    public class LocalizacaoViewHolder extends RecyclerView.ViewHolder {
        private View rootView;

        private TextView spot_name;

        private ImageView avatar;

        private TextView localizacao_text_view;

        private TextView web_site;

        private TextView telefone_text_view;

        private TextView tipo;
        public LocalizacaoViewHolder(@NonNull View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.spot_name = rootView.findViewById(R.id.spot_name);
            this.avatar = rootView.findViewById(R.id.avatar);
            this.localizacao_text_view = rootView.findViewById(R.id.localizacao_text_view);
            this.web_site = rootView.findViewById(R.id.web_site);
            this.telefone_text_view = rootView.findViewById(R.id.telefone_text_view);
            this.tipo = rootView.findViewById(R.id.tipo);

        }
    }

}