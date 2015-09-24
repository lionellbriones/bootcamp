package com.example.nonel.bootcamp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nonel.bootcamp.Model.Person;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by nonel on 9/6/15.
 */
public class PersonDaoSQLiteImpl implements PersonDao {
    private SQLiteDatabase db;
    private PersonDB helper;
    private final int DB_VERSION = 1;

    public PersonDaoSQLiteImpl(Context context){
        helper = new PersonDB(context);
    }
    public void open() throws SQLException {
        this.db = helper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    @Override
    public boolean savePerson(ArrayList<Person> record) {
        try {
            open();
            for (Person unit: record){
                ContentValues values = new ContentValues();

                values.put(PersonDB.COLUMN_NAME, unit.getName());
                values.put(PersonDB.COLUMN_AGE, unit.getAge());
                values.put(PersonDB.COLUMN_RELIGION, unit.getReligion());
                values.put(PersonDB.COLUMN_BIRTHDAY, unit.getBirthday());
                values.put(PersonDB.COLUMN_SCHOOL, unit.getSchool());
                values.put(PersonDB.COLUMN_FATHER, unit.getFather());
                values.put(PersonDB.COLUMN_MOTHER, unit.getMother());
                values.put(PersonDB.COLUMN_FOOD_FAVORITE, unit.getFoodFavorite());
                values.put(PersonDB.COLUMN_COLOR, unit.getColor());
                values.put(PersonDB.COLUMN_CRUSH_FIRST, unit.getCrushFirst());
                values.put(PersonDB.COLUMN_CRUSH_SECOND, unit.getCrushSecond());
                values.put(PersonDB.COLUMN_PET_NAME, unit.getPetName());
                values.put(PersonDB.COLUMN_BESTFRIEND, unit.getBestFriend());
                values.put(PersonDB.COLUMN_KISS_FIRST, unit.getKissFirst());
                values.put(PersonDB.COLUMN_KISS_SECOND, unit.getKissSecond());
                values.put(PersonDB.COLUMN_MOTTO, unit.getMotto());
                values.put(PersonDB.COLUMN_DREAM, unit.getDream());
                values.put(PersonDB.COLUMN_AGE, unit.getAge());
                values.put(PersonDB.COLUMN_GENDER, unit.getGender());
                values.put(PersonDB.COLUMN_GENDER_SURE, Boolean.toString(unit.getGenderSure()));

                //ask the dataabase object to insert new data
                try{
                    db.insert(PersonDB.TABLE_PERSON, null, values);
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
    public ArrayList<Person> getPersons() {

        ArrayList<Person> persons = new ArrayList<Person>();
        Cursor cursor;
        Person temp;

        try {
            open();

            cursor = db.query(PersonDB.TABLE_PERSON,
                    new String[]{
                            PersonDB.COLUMN_NAME,
                            PersonDB.COLUMN_AGE,
                            PersonDB.COLUMN_RELIGION,
                            PersonDB.COLUMN_CITIZENSHIP,
                            PersonDB.COLUMN_BIRTHDAY,
                            PersonDB.COLUMN_SCHOOL,
                            PersonDB.COLUMN_FATHER,
                            PersonDB.COLUMN_MOTHER,
                            PersonDB.COLUMN_FOOD_FAVORITE,
                            PersonDB.COLUMN_COLOR,
                            PersonDB.COLUMN_CRUSH_FIRST,
                            PersonDB.COLUMN_CRUSH_SECOND,
                            PersonDB.COLUMN_PET_NAME,
                            PersonDB.COLUMN_BESTFRIEND,
                            PersonDB.COLUMN_KISS_FIRST,
                            PersonDB.COLUMN_KISS_SECOND,
                            PersonDB.COLUMN_MOTTO,
                            PersonDB.COLUMN_DREAM,
                            PersonDB.COLUMN_GENDER,
                            PersonDB.COLUMN_GENDER_SURE
                    }, null, null, null, null, null, null
            );

            cursor.moveToFirst();

            if(!cursor.isAfterLast()){
                do{
                    temp = new Person();
                    temp.setName(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_NAME)));
                    temp.setAge(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_AGE)));
                    temp.setReligion(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_RELIGION)));
                    temp.setCitizenship(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_CITIZENSHIP)));
                    temp.setBirthday(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_BIRTHDAY)));
                    temp.setSchool(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_SCHOOL)));
                    temp.setFather(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_FATHER)));
                    temp.setMotto(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_MOTHER)));
                    temp.setFoodFavorite(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_FOOD_FAVORITE)));
                    temp.setColor(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_COLOR)));
                    temp.setCrushFirst(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_CRUSH_FIRST)));
                    temp.setCrushSecond(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_CRUSH_SECOND)));
                    temp.setPetName(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_PET_NAME)));
                    temp.setBestFriend(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_BESTFRIEND)));
                    temp.setKissFirst(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_KISS_FIRST)));
                    temp.setKissSecond(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_KISS_SECOND)));
                    temp.setMotto(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_MOTTO)));
                    temp.setDream(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_DREAM)));
                    temp.setGender(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_GENDER)));
                    temp.setGenderSure(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(PersonDB.COLUMN_GENDER_SURE))));

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
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public boolean updatePerson(int id, Person person) {
        try {
            open();

            ContentValues values = new ContentValues();
            values.put(PersonDB.COLUMN_NAME, person.getName());
            values.put(PersonDB.COLUMN_AGE, person.getAge());
            values.put(PersonDB.COLUMN_RELIGION, person.getReligion());
            values.put(PersonDB.COLUMN_CITIZENSHIP, person.getCitizenship());
            values.put(PersonDB.COLUMN_BIRTHDAY, person.getBirthday());
            values.put(PersonDB.COLUMN_SCHOOL, person.getSchool());
            values.put(PersonDB.COLUMN_FATHER, person.getFather());
            values.put(PersonDB.COLUMN_MOTHER, person.getMother());
            values.put(PersonDB.COLUMN_FOOD_FAVORITE, person.getFoodFavorite());
            values.put(PersonDB.COLUMN_COLOR, person.getColor());
            values.put(PersonDB.COLUMN_CRUSH_FIRST, person.getCrushFirst());
            values.put(PersonDB.COLUMN_CRUSH_SECOND, person.getCrushSecond());
            values.put(PersonDB.COLUMN_PET_NAME, person.getPetName());
            values.put(PersonDB.COLUMN_BESTFRIEND, person.getBestFriend());
            values.put(PersonDB.COLUMN_KISS_FIRST, person.getKissFirst());
            values.put(PersonDB.COLUMN_KISS_SECOND, person.getKissSecond());
            values.put(PersonDB.COLUMN_MOTTO, person.getMotto());
            values.put(PersonDB.COLUMN_DREAM, person.getDream());
            values.put(PersonDB.COLUMN_GENDER, person.getGender());
            values.put(PersonDB.COLUMN_GENDER_SURE, person.getGenderSure());

            db.update(PersonDB.TABLE_PERSON, values,
                    PersonDB.COLUMN_ID + "=?", new String[]{Integer.toString(id)});

            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getCount(){
        Cursor cursor;
        int count = 0;

        try {
            open();

            cursor = db.rawQuery("SELECT * FROM "+PersonDB.TABLE_PERSON, new String[]{} );
            count = cursor.getCount();

        }catch (SQLException e){
            e.printStackTrace();
        }
        close();

        return count;
    }

}
