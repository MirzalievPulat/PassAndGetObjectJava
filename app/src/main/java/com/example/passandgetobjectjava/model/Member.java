package com.example.passandgetobjectjava.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable {
    String company;
    String degree;
    public Member(String company, String degree){
        this.company = company;
        this.degree = degree;
    }

    protected Member(Parcel in) {
        company = in.readString();
        degree = in.readString();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    @Override
    public String toString() {
        return "Member{" +
                "company='" + company + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(company);
        dest.writeString(degree);
    }
}
