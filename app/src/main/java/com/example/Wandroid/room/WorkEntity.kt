package com.example.Wandroid.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "xl")
class WorkEntity : Parcelable {
    constructor()
    @field:PrimaryKey(autoGenerate = true)
    var id: Int=0
    @field:ColumnInfo(name = "name")
    lateinit var name: String

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WorkEntity> {
        override fun createFromParcel(parcel: Parcel): WorkEntity {
            return WorkEntity(parcel)
        }

        override fun newArray(size: Int): Array<WorkEntity?> {
            return arrayOfNulls(size)
        }
    }
}


