package app.android.com.gitrepostriesApp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner implements Parcelable {

    public static final Parcelable.Creator<Owner> CREATOR = new Parcelable.Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatar_url")
    @Expose
    private String UrlToImage;

    @SerializedName("login")
    @Expose
    private String username;

    protected Owner(Parcel in) {
        id = in.readInt();
        UrlToImage = in.readString();
        username = in.readString();
    }


    public String getUrlToImage() {
        return UrlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        UrlToImage = urlToImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(UrlToImage);
        dest.writeString(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
