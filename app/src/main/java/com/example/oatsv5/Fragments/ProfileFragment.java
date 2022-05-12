package com.example.oatsv5.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.oatsv5.R;

public class ProfileFragment extends Fragment {
    private Context context;
    private View view;
    private SharedPreferences userPref;
    private TextView profileGuestName, profileGuestProfession, profileGuestContact, profileGuestEmail, profileGuestCompany, profileGuestCompanyAdd,
            profileStudentName, profileStudentId, profileStudentContact, profileStudentEmail, profileStudentDept, profileStudentCourse;

    public ProfileFragment (){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userPref = getContext().getSharedPreferences("user", getContext().MODE_PRIVATE);
        String role = userPref.getString("role", "");

        if(role.equals("Student")){
            view = inflater.inflate(R.layout.layout_profile_student, container, false);
            context = view.getContext();
            initStudent();
            return view;
        } else {
            view = inflater.inflate(R.layout.layout_profile_guest, container, false);
            context = view.getContext();
            initGuest();
            return view;
        }
    }

    public void initStudent(){
        String tupId = userPref.getString("id", "");
        String name = userPref.getString("name", "");
        String contact = userPref.getString("contact","");
        String email = userPref.getString("email", "");
        String deptName = userPref.getString("deptName", "");
        String course = userPref.getString("course", "");

        profileStudentName = view.findViewById(R.id.profileStudentName);
        profileStudentId = view.findViewById(R.id.profileStudentId);
        profileStudentContact = view.findViewById(R.id.profileStudentContact);
        profileStudentEmail = view.findViewById(R.id.profileStudentEmail);
        profileStudentDept = view.findViewById(R.id.profileStudentDept);
        profileStudentCourse = view.findViewById(R.id.profileStudentCourse);

        profileStudentName.setText(name);
        profileStudentId.setText(tupId);
        profileStudentContact.setText(contact);
        profileStudentEmail.setText(email);
        profileStudentDept.setText(deptName);
        profileStudentCourse.setText(course);

    }

    public void initGuest(){
        String name = userPref.getString("name", "");
        String profession = userPref.getString("profession", "");
        String contact = userPref.getString("contact", "");
        String email = userPref.getString("email", "");
        String company = userPref.getString("company", "");
        String companyAdd = userPref.getString("company_address", "");

        profileGuestName = view.findViewById(R.id.profileGuestName);
        profileGuestProfession = view.findViewById(R.id.profileGuestProfession);
        profileGuestContact = view.findViewById(R.id.profileGuestContact);
        profileGuestEmail = view.findViewById(R.id.profileGuestEmail);
        profileGuestCompany = view.findViewById(R.id.profileGuestCompany);
        profileGuestCompanyAdd = view.findViewById(R.id.profileGuestCompanyAdd);

        profileGuestName.setText(name);
        profileGuestProfession.setText(profession);
        profileGuestContact.setText(contact);
        profileGuestEmail.setText(email);
        profileGuestCompany.setText(company);
        profileGuestCompanyAdd.setText(companyAdd);
    }
}
