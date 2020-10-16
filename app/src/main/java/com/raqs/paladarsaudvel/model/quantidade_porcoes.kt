package com.raqs.paladarsaudvel.model

import android.os.Parcel
import android.os.Parcelable

class quantidade_porcoes(val quantidade_porcao: String?)  : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(quantidade_porcao)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<quantidade_porcoes> {
        override fun createFromParcel(parcel: Parcel): quantidade_porcoes {
            return quantidade_porcoes(parcel)
        }

        override fun newArray(size: Int): Array<quantidade_porcoes?> {
            return arrayOfNulls(size)
        }
    }

}
