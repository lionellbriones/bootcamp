package com.example.nonel.bootcamp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.nonel.bootcamp.Model.Person;

import java.util.ArrayList;

public class SlamBookActivity extends Activity implements View.OnClickListener {

    EditText et_name;
    EditText et_age;
    EditText et_religion;
    EditText et_citizenship;
    EditText et_birthday;
    EditText et_school;
    EditText et_father;
    EditText et_mother;
    EditText et_food_favorite;
    EditText et_color;
    EditText et_crush_first;
    EditText et_crush_second;
    EditText et_pet_name;
    EditText et_bestfriend;
    EditText et_kiss_first;
    EditText et_kiss_second;
    EditText et_motto;
    EditText et_dream;

    RadioGroup rg_gender;
    RadioButton rbtn_gender_male;
    RadioButton rbtn_gender_female;

    CheckBox cb_gender_sure;

    Button btn_submit;

    PersonDaoSQLiteImpl personDaoSQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slam_book);

        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        et_religion = (EditText) findViewById(R.id.et_religion);
        et_citizenship = (EditText) findViewById(R.id.et_citizeship);
        et_birthday = (EditText) findViewById(R.id.et_birthday);
        et_school = (EditText) findViewById(R.id.et_school);
        et_father = (EditText) findViewById(R.id.et_father);
        et_mother = (EditText) findViewById(R.id.et_mother);
        et_food_favorite = (EditText) findViewById(R.id.et_food_favorite);
        et_color = (EditText) findViewById(R.id.et_color);
        et_crush_first = (EditText) findViewById(R.id.et_crush_first);
        et_crush_second = (EditText) findViewById(R.id.et_crush_second);
        et_pet_name = (EditText) findViewById(R.id.et_pet_name);
        et_bestfriend = (EditText) findViewById(R.id.et_bestfriend);
        et_kiss_first = (EditText) findViewById(R.id.et_kiss_first);
        et_kiss_second = (EditText) findViewById(R.id.et_kiss_second);
        et_motto = (EditText) findViewById(R.id.et_motto);
        et_dream = (EditText) findViewById(R.id.et_dream);

        rg_gender = (RadioGroup) findViewById(R.id.rg_gender);
        rbtn_gender_male = (RadioButton) findViewById(R.id.rbtn_gender_male);
        rbtn_gender_female = (RadioButton) findViewById(R.id.rbtn_gender_female);

        cb_gender_sure = (CheckBox) findViewById(R.id.cb_gender_sure);

        btn_submit = (Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(this);

        rg_gender.check(rbtn_gender_male.getId());

        personDaoSQLite = new PersonDaoSQLiteImpl(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submit:
                Log.i("SlamBook", "Person Submitted");

                ArrayList<Person> persons = new ArrayList<Person>();
                Person person = new Person();

                person.setName(et_name.getText() + "");
                person.setAge(et_age.getText() + "");
                person.setReligion(et_religion.getText() + "");
                person.setCitizenship(et_citizenship.getText() + "");
                person.setBirthday(et_birthday.getText() + "");
                person.setSchool(et_school.getText() + "");
                person.setFather(et_father.getText() + "");
                person.setMother(et_mother.getText() + "");
                person.setFoodFavorite(et_food_favorite.getText() + "");
                person.setColor(et_color.getText() + "");
                person.setCrushFirst(et_crush_first.getText() + "");
                person.setCrushSecond(et_crush_second.getText() + "");
                person.setPetName(et_pet_name.getText() + "");
                person.setBestFriend(et_bestfriend.getText() + "");
                person.setKissFirst(et_kiss_first.getText() + "");
                person.setKissSecond(et_kiss_second.getText() + "");
                person.setMotto(et_motto.getText() + "");

                String gender = "male";
                if(rg_gender.getCheckedRadioButtonId() == rbtn_gender_female.getId()){
                    gender = "female";
                }

                person.setGender(gender);

                person.setGenderSure(cb_gender_sure.isChecked());

                persons.add(person);
                personDaoSQLite.savePerson(persons);

                Log.i("SlamBook", personDaoSQLite.getCount()+"");
                break;
        }
    }
}
