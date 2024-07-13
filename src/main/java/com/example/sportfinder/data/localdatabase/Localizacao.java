package com.example.sportfinder.data.localdatabase;

public class Localizacao {

    private String spot_name;

    private String avatar;


    private String localizacao_text_view;

    private String web_site;

    private String telefone_text_view;

    private String tipo;


    public Localizacao(String spot_name, String avatar, String localizacao_text_view, String web_site, String telefone_text_view, String tipo) {
        this.spot_name = spot_name;
        this.avatar = avatar;
        this.localizacao_text_view = localizacao_text_view;
        this.web_site = web_site;
        this.telefone_text_view = telefone_text_view;
        this.tipo = tipo;
    }

    public String getSpot_name() {
        return spot_name;
    }

    public void setSpot_name(String spot_name) {
        this.spot_name = spot_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }



    public String getLocalizacao_text_view() {
        return localizacao_text_view;
    }

    public void setLocalizacao_text_view(String localizacao_text_view) {
        this.localizacao_text_view = localizacao_text_view;
    }

    public String getWeb_site() {
        return web_site;
    }

    public void setWeb_site(String web_site) {
        this.web_site = web_site;
    }

    public String getTelefone_text_view() {
        return telefone_text_view;
    }

    public void setTelefone_text_view(String telefone_text_view) {
        this.telefone_text_view = telefone_text_view;
    }

    public String gettipo() {
        return tipo;
    }

}