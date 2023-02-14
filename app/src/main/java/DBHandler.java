import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "productdb";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "mydata";

    private static final String ID_COL = "product id";

    private static final String NAME1_COL = "product name";

    // below variable is for our product name column
    private static final String PROD_COL = "product description";

    // below variable for our course description column.
    private static final String PRICE_COL = "product price";



    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PROD_COL + "TEXT,"
                + PRICE_COL + "TEXT,"
                + NAME1_COL + "TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String productID, String productname, String productdescription, String productprice) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ID_COL, productID);
        values.put(NAME1_COL, productname);
        values.put(PROD_COL, productdescription);
        values.put(PRICE_COL, productprice);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // we have created a new method for reading all the courses.
    public ArrayList<prodmodel> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorProd = (Cursor) db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<prodmodel> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorProd.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new prodmodel(cursorProd.getString(1),
                        cursorProd.getString(4),
                        cursorProd.getString(2),
                        cursorProd.getString(3)));
            } while (cursorProd.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorProd.close();
        ArrayList<prodmodel> prodmodelArrayList = null;
        return prodmodelArrayList;
    }

    // below is the method for updating our courses
    public void updateprod(int prodID, String prodName, String prodDescription,
                           String prodprice) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ID_COL, prodID);
        values.put(NAME1_COL, prodName);
        values.put(PROD_COL, prodDescription);
        values.put(PRICE_COL, prodprice);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "name=?", new String[]{prodName});
        db.close();
    }



    private class Cursor {
        public int getString(int i) {
            return 0;
        }

        public boolean moveToFirst() {
            return false;
        }

        public boolean moveToNext() {
            return false;
        }

        public void close() {
        }
    }

}

