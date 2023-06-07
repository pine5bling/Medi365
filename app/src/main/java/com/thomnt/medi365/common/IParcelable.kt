package com.thomnt.medi365.common

import android.os.Parcelable

interface IParcelable : Parcelable, Cloneable {

    override fun describeContents(): Int {
        return 0
    }

    override fun clone(): Any {
        return super.clone()
    }
}
