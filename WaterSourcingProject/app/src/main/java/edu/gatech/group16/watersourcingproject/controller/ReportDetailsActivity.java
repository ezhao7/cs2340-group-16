package edu.gatech.group16.watersourcingproject.controller;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.gatech.group16.watersourcingproject.R;
import edu.gatech.group16.watersourcingproject.model.User;
import edu.gatech.group16.watersourcingproject.model.WaterSourceReport;

public class ReportDetailsActivity extends AppCompatActivity {
    private User user;
    private TextView reportNumber;
    private TextView reportDate;
    private TextView reportLocation;
    private TextView reportWaterType;
    private TextView reportAuthor;
    private int position;
    /**
     * OnCreate method required to load activity and loads everything that
     * is needed for the page while setting the view.
     *
     *
     * @param savedInstanceState Takes in a bundle that may contain an object
     *                           for use within this class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_details);

        user = (User) getIntent().getSerializableExtra("USER");
        position =  (int) getIntent().getSerializableExtra("POSITION");

        reportNumber = (TextView) findViewById(R.id.label_reportNum);
        reportDate = (TextView) findViewById(R.id.label_reportDate);
        reportLocation = (TextView) findViewById(R.id.label_reportLoc);
        reportWaterType = (TextView) findViewById(R.id.label_reportWT);
        reportAuthor = (TextView) findViewById(R.id.label_reportAuth);

        for (WaterSourceReport item: user.getWaterSourceReport()) {
            reportDate.setText(item.getDate().toString());
            reportLocation.setText(item.getLocation().toString());
            reportWaterType.setText(item.getWaterType().toString());
        }
        reportNumber.setText(position);
        reportAuthor.setText(user.getName());
    }
}
