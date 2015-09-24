package com.example.nonel.bootcamp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nonel.bootcamp.Model.Products;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by nonel on 9/6/15.
 */
public class ProductDaoSQLiteImpl implements ProductDao {
    private SQLiteDatabase db;
    private ProductDB helper;
    private final int DB_VERSION = 1;

    public ProductDaoSQLiteImpl(Context context){
        helper = new ProductDB(context);
    }

    public void open() throws SQLException{
        this.db = helper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    @Override
    public boolean saveProduct(ArrayList<Products> record) {
        try {
            open();
            for (Products unit: record){
                ContentValues values = new ContentValues();

                values.put(ProductDB.COLUMN_NAME, unit.getName());
                values.put(ProductDB.COLUMN_DESCRIPTION, unit.getDescription());
                values.put(ProductDB.COLUMN_PRICE, unit.getPrice());

                //ask the dataabase object to insert new data
                try{
                    db.insert(ProductDB.TABLE_PRODUCT, null, values);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Products> getProducts() {

        ArrayList<Products> persons = new ArrayList<Products>();
        Cursor cursor;
        Products temp;

        try {
            open();

            cursor = db.query(ProductDB.TABLE_PRODUCT,
                    new String[]{
                            ProductDB.COLUMN_NAME,
                            ProductDB.COLUMN_DESCRIPTION,
                            ProductDB.COLUMN_PRICE
                    }, null, null, null, null, null, null
            );

            cursor.moveToFirst();

            if(!cursor.isAfterLast()){
                do{
                    temp = new Products();
                    temp.setName(cursor.getString(cursor.getColumnIndex(ProductDB.COLUMN_NAME)));
                    temp.setDescription(cursor.getString(cursor.getColumnIndex(ProductDB.COLUMN_DESCRIPTION)));
                    temp.setPrice(Float.parseFloat(cursor.getString(cursor.getColumnIndex(ProductDB.COLUMN_PRICE))));

                    persons.add(temp);
                }while (cursor.moveToNext());
            }
            cursor.close();
            close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public Products getProduct(int id) {
        return null;
    }

    @Override
    public boolean updateProduct(int id, Products products) {
        try {
            open();

            ContentValues values = new ContentValues();
            values.put(ProductDB.COLUMN_NAME, products.getName());
            values.put(ProductDB.COLUMN_DESCRIPTION, products.getDescription());
            values.put(ProductDB.COLUMN_PRICE, products.getPrice());
            db.update(ProductDB.TABLE_PRODUCT, values,
                    ProductDB.COLUMN_ID + "=?", new String[]{Integer.toString(id)});

            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
