package com.aaronfleshner.usadivinghelix.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.aaronfleshner.usadivinghelix.R;
import com.aaronfleshner.usadivinghelix.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by aaronfleshner on 7/18/14.
 */
public class DtoDiver implements Parcelable {

    private String imgUrl;
    private String imgSecondaryUrl;
    private String FirstName;
    private String LastName;
    private String Height;
    private String BirthDate;
    private String BirthPlace;
    private String HomeTown;
    private String CurrentResidence;
    private String Education;
    private String Degree;
    private String Club;
    private String Trains;
    private String Coach;
    private String Biography;
    private ArrayList<String> NationalTeam;
    private String Results;

    public DtoDiver() {

    }

    public DtoDiver(String imgUrl, String imgSecondaryUrl, String firstName, String lastName, String height, String birthDate, String birthPlace, String homeTown, String currentResidence, String education, String degree, String club, String trains, String coach, ArrayList<String> nationalTeam,String biography,String results) {
        this.imgUrl = imgUrl;
        this.imgSecondaryUrl = imgSecondaryUrl;
        FirstName = firstName;
        LastName = lastName;
        Height = height;
        BirthDate = birthDate;
        BirthPlace = birthPlace;
        HomeTown = homeTown;
        CurrentResidence = currentResidence;
        Education = education;
        Degree = degree;
        Club = club;
        Trains = trains;
        Coach = coach;
        NationalTeam = nationalTeam;
        Biography = biography;
        Results = results;
    }

    public DtoDiver(String imgUrl,
                    String firstName,
                    String lastName,
                    String height,
                    String birthDate,
                    String birthPlace,
                    String homeTown,
                    String currentResidence,
                    String education,
                    String degree,
                    String club,
                    String trains,
                    String coach,
                    ArrayList<String> nationalTeam,
                    String biography,
                    String results) {
        this.imgUrl = imgUrl;
        this.imgSecondaryUrl = imgUrl;
        FirstName = firstName;
        LastName = lastName;
        Height = height;
        BirthDate = birthDate;
        BirthPlace = birthPlace;
        HomeTown = homeTown;
        CurrentResidence = currentResidence;
        Education = education;
        Degree = degree;
        Club = club;
        Trains = trains;
        Coach = coach;
        NationalTeam = nationalTeam;
        Biography = biography;
        Results = results;
    }

    public DtoDiver(Context cxt) {
        imgUrl = cxt.getString(R.string.aaron_profile_img_url);
        imgSecondaryUrl = cxt.getString(R.string.aaron_secondary_img_url);
        FirstName = cxt.getString(R.string.aaron_fleshner_first);
        LastName = cxt.getString(R.string.aaron_fleshner_last);
        Height = cxt.getString(R.string.aaron_fleshner_height);
        BirthDate = cxt.getString(R.string.aaron_fleshner_bday);
        BirthPlace = cxt.getString(R.string.aaron_fleshner_birth_place);
        HomeTown = cxt.getString(R.string.aaron_fleshner_home_town);
        CurrentResidence = cxt.getString(R.string.aaron_fleshner_current_residence);
        Education = cxt.getString(R.string.aaron_fleshner_education);
        Degree = cxt.getString(R.string.aaron_fleshner_degree);
        Club = cxt.getString(R.string.aaron_fleshner_club);
        Trains = cxt.getString(R.string.aaron_fleshner_trains);
        Coach = cxt.getString(R.string.aaron_fleshner_coach);
        NationalTeam = Utils.StringArrayToArrayListOfStrings(cxt.getResources().getStringArray(R.array.aaron_fleshner_national_team));
        Biography = cxt.getString(R.string.aaron_fleshner_bio);
    }


    public static String toJson(DtoDiver diver) {
        String temp = "{}";
        try {
            temp = new Gson().toJson(diver, DtoDiver.class);
        } catch (Exception e) {

        }
        return temp;
    }

    public static String toJsonArray(ArrayList<DtoDiver> diver) {
        String temp = "[{}]";
        try {
            Type listOfDtoDiverObject = new TypeToken<ArrayList<DtoDiver>>() {
            }.getType();
            temp = new Gson().toJson(diver, listOfDtoDiverObject);
        } catch (Exception e) {

        }
        return temp;
    }

    public static DtoDiver fromJson(String diver) {
        DtoDiver temp = new DtoDiver();
        try {
            temp = new Gson().fromJson(diver, DtoDiver.class);
        } catch (Exception e) {

        }
        return temp;
    }

    public static ArrayList<DtoDiver> fromJsonArray(String diver) {
        ArrayList<DtoDiver> temp = new ArrayList<DtoDiver>();
        try {
            Type listOfDtoDiverObject = new TypeToken<ArrayList<DtoDiver>>() {
            }.getType();
            temp = new Gson().fromJson(diver, listOfDtoDiverObject);
        } catch (Exception e) {

        }
        return temp;
    }

    public String getFullName(){
        return FirstName + " " + LastName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgSecondaryUrl() {
        return imgSecondaryUrl;
    }

    public void setImgSecondaryUrl(String imgSecondaryUrl) {
        this.imgSecondaryUrl = imgSecondaryUrl;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getBirthPlace() {
        return BirthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        BirthPlace = birthPlace;
    }

    public String getHomeTown() {
        return HomeTown;
    }

    public void setHomeTown(String homeTown) {
        HomeTown = homeTown;
    }

    public String getCurrentResidence() {
        return CurrentResidence;
    }

    public void setCurrentResidence(String currentResidence) {
        CurrentResidence = currentResidence;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String club) {
        Club = club;
    }

    public String getTrains() {
        return Trains;
    }

    public void setTrains(String trains) {
        Trains = trains;
    }

    public String getCoach() {
        return Coach;
    }

    public void setCoach(String coach) {
        Coach = coach;
    }

    public ArrayList<String> getNationalTeam() {
        return NationalTeam;
    }

    public void setNationalTeam(ArrayList<String> nationalTeam) {
        NationalTeam = nationalTeam;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    public String getResults() {
        return Results;
    }

    public void setResults(String results) {
        Results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imgUrl);
        dest.writeString(this.imgSecondaryUrl);
        dest.writeString(this.FirstName);
        dest.writeString(this.LastName);
        dest.writeString(this.Height);
        dest.writeString(this.BirthDate);
        dest.writeString(this.BirthPlace);
        dest.writeString(this.HomeTown);
        dest.writeString(this.CurrentResidence);
        dest.writeString(this.Education);
        dest.writeString(this.Degree);
        dest.writeString(this.Club);
        dest.writeString(this.Trains);
        dest.writeString(this.Coach);
        dest.writeString(this.Biography);
        dest.writeString(this.Results);
        dest.writeSerializable(this.NationalTeam);
    }

    private DtoDiver(Parcel in) {
        this.imgUrl = in.readString();
        this.imgSecondaryUrl = in.readString();
        this.FirstName = in.readString();
        this.LastName = in.readString();
        this.Height = in.readString();
        this.BirthDate = in.readString();
        this.BirthPlace = in.readString();
        this.HomeTown = in.readString();
        this.CurrentResidence = in.readString();
        this.Education = in.readString();
        this.Degree = in.readString();
        this.Club = in.readString();
        this.Trains = in.readString();
        this.Coach = in.readString();
        this.Biography = in.readString();
        this.Results = in.readString();
        this.NationalTeam = (ArrayList<String>) in.readSerializable();
    }

    public static final Parcelable.Creator<DtoDiver> CREATOR = new Parcelable.Creator<DtoDiver>() {
        public DtoDiver createFromParcel(Parcel source) {
            return new DtoDiver(source);
        }

        public DtoDiver[] newArray(int size) {
            return new DtoDiver[size];
        }
    };


}
