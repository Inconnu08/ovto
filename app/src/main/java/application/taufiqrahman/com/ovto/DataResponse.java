package application.taufiqrahman.com.ovto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Taufiq on 5/8/2018.
 * Model Class for handling API response data of UserList
 * Data representation sample:
 * {
 * "page":1,
 * "per_page":3,
 * "total":12,
 * "total_pages":4,
 * "data":
 *      [
 *        {
 *          "id":1,
 *          "first_name":"George",
 *          "last_name":"Bluth",
 *          "avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"},
 *        {
 *          "id":2,
 *          "first_name":"Janet",
 *          "last_name":"Weaver",
 *          "avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"},
 *        {
 *          "id":3,
 *          "first_name":"Emma",
 *          "last_name":"Wong",
 *          "avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"}
 *        ]
 * }
 */

public class DataResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("per_page")
    private int per_page;

    @SerializedName("total")
    private int total;

    @SerializedName("total_pages")
    private int total_pages;

    @SerializedName("data")
    public List<Data> data;

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<Data> getData() {
        return data;
    }

}

class Data {

    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("avatar")
    private String avatar;

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}

