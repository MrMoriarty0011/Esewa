package com.example.esewa

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.text.Editable
import android.widget.Spinner


class DailyDatabase(context: Context) : SQLiteOpenHelper(context, dbname, factory, version){
    override fun onCreate(db: SQLiteDatabase?) {


        val myTable = "CREATE TABLE " + TABLE_NAME +
                " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_ANAME + " VARCHAR(10),"+
                COLUMN_DATE + " TEXT,"+
                COLUMN_CLIENT + " TEXT," +
                COLUMN_ACTIVITY + " TEXT," +
                COLUMN_APPROACH+ " TEXT," +
                COLUMN_PARTICIPANT +" TEXT," +
                COLUMN_REMARKS +" TEXT)"
        db?.execSQL(myTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(name: String, date: String, client: Editable, activity: String, approach: String, participant: String, remarks:String):Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_ANAME, name)
        contentValues.put(COLUMN_DATE, date)
        contentValues.put(COLUMN_CLIENT, client.toString())
        contentValues.put(COLUMN_ACTIVITY, activity)
        contentValues.put(COLUMN_APPROACH, approach)
        contentValues.put(COLUMN_PARTICIPANT, participant)
        contentValues.put(COLUMN_REMARKS, remarks)

        val ins = db.insert(TABLE_NAME,null,contentValues)
        return ins > 0
    }

    fun GetUsers(): ArrayList<HashMap<String, String>>? {
        val db = this.writableDatabase
        val userList: ArrayList<HashMap<String, String>> = ArrayList()
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)
        while (cursor.moveToNext()) {
            val user: HashMap<String, String> = HashMap()
            user["ActivityName"] = cursor.getString(cursor.getColumnIndex(COLUMN_ANAME))
            user["Date"] = cursor.getString(cursor.getColumnIndex(COLUMN_DATE))
            user["Client"] = cursor.getString(cursor.getColumnIndex(COLUMN_CLIENT))
            user["Activity"] = cursor.getString(cursor.getColumnIndex(COLUMN_ACTIVITY))
            user["Approach"] = cursor.getString(cursor.getColumnIndex(COLUMN_APPROACH))
            user["Participant"] = cursor.getString(cursor.getColumnIndex(COLUMN_PARTICIPANT))
            user["Remarks"] = cursor.getString(cursor.getColumnIndex(COLUMN_REMARKS))




            userList.add(user)
        }
        return userList
    }

    companion object{
        internal const val dbname = "dailyActivity"
        internal val factory = null
        internal const val version = 1

        private const val TABLE_NAME = "ActivityForm"
        private const val COLUMN_ID = "ID"
        private const val COLUMN_ANAME = "ActivityName"
        private const val COLUMN_DATE = "Date"
        private const val COLUMN_CLIENT = "Client"
        private const val COLUMN_ACTIVITY = "Activity"

        private const val COLUMN_APPROACH = "Approach"
        private const val COLUMN_PARTICIPANT = "Participant"
        private const val COLUMN_REMARKS = "Remarks"
    }
}






