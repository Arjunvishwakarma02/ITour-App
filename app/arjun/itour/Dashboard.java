package app.arjun.itour;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    TextView txtNama, txtEmail;
    Button checkTickets;

    AlertDialog alertDialog;
    MenuInflater inflater;
    private ArrayList<String> al_img_tour = new ArrayList<>();
    private ArrayList<String> al_name_tour = new ArrayList<>();
    private ArrayList<String> al_desc_tour = new ArrayList<>();
    private ArrayList<String> al_price_tour = new ArrayList<>();
    private ArrayList<String> al_location = new ArrayList<>();
    SharedPreferences preferences;
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_TOTAL_PRICE = "total_price";
    private static final String KEY_NAME_TOUR = "name_tour";
    private static final String KEY_COUNT_ITEMS = "count_items";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtNama = findViewById(R.id.tv_fullname);
        txtEmail = findViewById(R.id.tv_email);
        checkTickets = findViewById(R.id.check_ticket);

        preferences = getSharedPreferences("userInfo", 0);

        checkTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameView = preferences.getString(KEY_NAME, null);
                String emailView = preferences.getString(KEY_EMAIL, null);
                String phoneView = preferences.getString(KEY_PHONE, null);
                String nameTourview = preferences.getString(KEY_NAME_TOUR, null);
                String totalItemsview = preferences.getString(KEY_COUNT_ITEMS, null);
                String totalpriceview = preferences.getString(KEY_TOTAL_PRICE, null);

                if (nameView == null || emailView == null || phoneView == null || nameTourview == null || totalItemsview == null || totalpriceview == null) {
                    AlertDialog dialog = new AlertDialog.Builder(Dashboard.this)
                            .setTitle("Check Tickets")
                            .setMessage("\n Data Is Empty")
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Dashboard.this, Dashboard.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }).show();
                } else {
                    Intent intent = new Intent(Dashboard.this, Tickets.class);
                    startActivity(intent);
                }
            }
        });

        preferences = getSharedPreferences("userInfo", 0);

        String nameView = preferences.getString(KEY_NAME, null);
        String emailView = preferences.getString(KEY_EMAIL, null);

        if (nameView != null && emailView != null) {
            txtNama.setText(nameView);
            txtEmail.setText(emailView);
        }

        getData();

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
    }

    private void getData() {

        al_img_tour.add("https://i.postimg.cc/G3gGbXWP/Gatewayof-India.jpg");
        al_name_tour.add("Gate Of India");
        al_desc_tour.add("The Gateway of India is an arch monument built during the 20th century in Bombay, India. The monument was erected to commemorate the landing of King George V and Queen Mary at Apollo Bunder on their visit to India in 1911.");
        al_price_tour.add("800");
        al_location.add("Apollo Bandar, Colaba, Mumbai, Maharashtra 400001");


        al_img_tour.add("https://i.postimg.cc/ryC3bkWZ/Chhatrapati-Shivaji-Terminus.jpg");
        al_name_tour.add("Chhatrapati Shivaji Termiuns");
        al_desc_tour.add("The Chhatrapati Shivaji Terminus (formerly Victoria Terminus) is located in Mumbai on the Western Part of India touching the shores of the Arabian Sea. This building, designed by F. W. Stevens, is spread across a 2.85 hectare area. The terminal was built over a period of 10 years starting in 1878.");
        al_price_tour.add("5000");
        al_location.add("Fort, Mumbai, Maharashtra 400001, India");


        al_img_tour.add("https://i.postimg.cc/VvK3VxvV/Elephenta-Caves.jpg");
        al_name_tour.add("Elephenta Caves");
        al_desc_tour.add("The Elephanta Caves are a collection of rock-cut caves on Elephanta Island, also known as Gharapuri, in Western India. The caves are located in the Sea of Oman, about 11 kilometers from Mumbai..");
        al_price_tour.add("2000");
        al_location.add("Gharapuri, Maharashtra 400001");



        al_img_tour.add("https://i.postimg.cc/rmNmKwZR/Chota-kashmir.jpg");
        al_name_tour.add("Chota Kashmir");
        al_desc_tour.add("From Jammu, A Bowl-Shaped Valley, Bhaderwah (also called chota Kashmir, meaning Little Kashmir) is a place, geographical area, and a tehsil in the union territory of.");
        al_price_tour.add("3000");
        al_location.add("Aarey Colony, Mumbai, India");


        al_img_tour.add("https://i.postimg.cc/nz2FnwMv/Colaba-Causeway.jpg");
        al_name_tour.add("Colaba Causeway");
        al_desc_tour.add("Colaba Causeway, also known as Shahid Bhagat Singh Road, is a commercial street in Mumbai, India that connects Colaba to the Old Woman's Island. The street is known for its shopping, including roadside vendors and high-end boutiques. It also has art galleries, antique shops, and department stores.");
        al_price_tour.add("2000");
        al_location.add("South Mumbai, India i");


        al_img_tour.add("https://i.postimg.cc/tTDf7TPw/Essel-World.jpg");
        al_name_tour.add("Essel World");
        al_desc_tour.add("EsselWorld is a 65-acre amusement park in Gorai, Mumbai, India, that includes a water kingdom and bird park. It's one of India's biggest amusement parks and is popular with domestic tourists. The park has been temporarily closed since April 2022.");
        al_price_tour.add("3000");
        al_location.add("Global Pagoda Road, Gorai Island, Borivali West, Mumbai, Maharashtra 40009");


        al_img_tour.add("https://i.postimg.cc/mkDn9syD/Global-Vipassana-Pagoda.jpg");
        al_name_tour.add("Global Vipassana Pagoda");
        al_desc_tour.add("The Global Vipassana Pagoda is a meditation dome hall in Mumbai, India, that's open every day from 9 AM–7 PM. The pagoda is located on a peninsula between Gorai creek and the Arabian Sea, near Gorai in northwest Mumbai. It's the world's largest pillar-less dome, designed for meditation and painted in Thai golden paint. The pagoda is made of three hollow stone stories and has a capacity of about 8,000 Vipassana meditators..");
        al_price_tour.add("3000");
        al_location.add("Global Vipassana Pagoda Road, Gorai Village, West, Borivali, Mumbai, Maharashtra 400092");


        al_img_tour.add("https://i.postimg.cc/26yk87WM/Haji-Ali.jpg");
        al_name_tour.add("Haji Ali ");
        al_desc_tour.add("The Haji Ali Dargah is a mosque and dargah (tomb) located on an islet off the coast of Worli in the southern part of Mumbai. Near the heart of the city proper, the dargah is one of the most recognisable landmarks of Mumbai..");
        al_price_tour.add("5000");
        al_location.add("Mumbai Centre , Mumbai");


        al_img_tour.add("https://i.postimg.cc/pXbmk3zd/Juhu-Beach.jpg");
        al_name_tour.add("Juhu Beach");
        al_desc_tour.add("Juhu Beach in Mumbai is a popular tourist destination and the longest beach in the city. It's known for its lively atmosphere, street food stalls, and sunset views. Some say it's a great place to spend a romantic evening..");
        al_price_tour.add("1000");
        al_location.add(" Mumbai Suburban, Mumbai");

        al_img_tour.add("https://i.postimg.cc/TYw47H6Z/Kanheri-Caves-min.jpg");
        al_name_tour.add("Kanheri Caves");
        al_desc_tour.add("There are 129 caves in Kanheri where the Buddhist monks lived, studied, meditated, and spread the teachings of Gautama Buddha. The caves were also used as shelters during the monsoon. Kanheri constitutes a group of rock-cut monuments, the traditional art of western India..");
        al_price_tour.add("5000");
        al_location.add("Sanjay Gandhi National Park,Mumbai");

        al_img_tour.add("https://i.postimg.cc/HWP2xYqh/Marine-Drive.jpg");
        al_name_tour.add("Marine Drive");
        al_desc_tour.add("Marine Drive is a 3.6 km-long promenade in Mumbai, India that runs along the Netaji Subhash Chandra Bose Road, also known as Sonapur. It's a banana-shaped concrete road that forms a natural bay, linking Nariman Point to Babulnath in southern Mumbai. The road is often called the Queen's Necklace because its streetlights resemble gems.");
        al_price_tour.add("10000");
        al_location.add("Marine Drive ,Mumbai");


        al_img_tour.add("https://i.postimg.cc/HsXBhGNv/Nehru-Centre.jpg");
        al_name_tour.add("Nehru Centre ");
        al_desc_tour.add("Nehru Centre was conceived in 1972 in Bombay (now Mumbai), India by the late Shri Rajni Patel (an eminent criminal lawyer).[1] The foundation stone of this magnificent dream was laid by the late Indira Gandhi on 2 November 1972 on a six-acre plot leased by the Government of Maharashtra    .");
        al_price_tour.add("2500");
        al_location.add("Nehru Centre, Mumbai");

        al_img_tour.add("https://i.postimg.cc/rmqkKCrM/Red-Carpet-Wax-Museum.jpg");
        al_name_tour.add("Red Carpet Wax Museum");
        al_desc_tour.add("The Red Carpet Wax Museum in Mumbai, India, is an interactive wax museum that features life-like statues of local and international celebrities. The museum is located on the first floor of R City Mall in Ghatkopar West, and is open from 11 AM to 9 PM. Tickets cost Rs 300 on weekdays and Rs 400 on weekends..");
        al_price_tour.add("3000");
        al_location.add("Ghatkopar West, Mumbai, Maharashtra 400086");


        al_img_tour.add("https://i.postimg.cc/yxt6g3Kj/Sanjay-Gandhi-National-Park.jpg");
        al_name_tour.add("Sanjay Gandhi National Park");
        al_desc_tour.add("Sanjay Gandhi National Park (SGNP) is a 34 sq mi (87 km) protected area in Mumbai, Maharashtra, India. It's one of the most visited national parks in Asia and the world's largest park located within a city. The park is home to over 1,000 plant species and 40 mammal species, including leopards, macaques, deer, flying foxes, and lions. It also features the 2,400-year-old Kanheri caves, which were carved out of the basaltic cliffs by monks.");
        al_price_tour.add("3000");
        al_location.add("Borivali Mumbai, Maharashtra");


        al_img_tour.add("https://i.postimg.cc/Hs8kGz0h/shivaji-park.jpg");
        al_name_tour.add("Shivaji Park");
        al_desc_tour.add("Shivaji Park, officially called Chhatrapati Shivaji Maharaj Park, is a public park in Dadar, Mumbai, India. It's the largest park in the island city and is known as the birthplace of Indian cricket.");
        al_price_tour.add("2000");
        al_location.add("Dadar, Mumbai, India.");


        al_img_tour.add("https://i.postimg.cc/kG4FMzM8/Sunset-at-Bandra-Worli-Sea-Link.jpg");
        al_name_tour.add("Sunset at Bandra worli Sea ");
        al_desc_tour.add("Some say the best place to watch the sunset at Bandra Worli Sea in Mumbai is Marine Drive, where you can arrive about an hour before sunset. The sunset time varies throughout the year, but is usually between 6:30 PM and 7 PM. Clear skies can enhance the experience, and the view can be stunning with golden hues reflecting on the Arabian Sea. \n" +
                "\n" +
                "Tripadvisor\n" +
                "Beautiful Sunset Feeling. - Bandra-Worli Sea Link - Tripadvisor\n" +
                "Bandra-Worli Sea Link: Beautiful Sunset Feeling. - See 9556 traveler reviews, 1564 candid photos, and great deals for Mumbai, India, at Tripadvisor.\n" +
                "\n" +
                "Quora\n" +
                "What is the best place to watch the sunrise from the Bandra ...\n" +
                "7 Feb 2023 — However, it's a good idea to check the local sunrise time on the specific day you plan to visit. Weather conditions can also affect the visibility of the sunrise, so clear skies would enhance the experience. For sunset, you can arrive at Marine Drive approximately one hour before the scheduled sunset time. The exact time of sunset varies throughout the year. Generally, it ranges between 6:30 pm to 7:00 pm. Again, checking the local sunset time for the specific date is recommended. The sunset view from Marine Drive can be quite stunning, especially with the golden hues reflecting on the Arabian Sea.\n" +
                "Other places to watch the sunset at Bandra Worli Sea include:\n" +
                "\n" +
                "Sea Link Sunset Point\n" +
                "4.4(8)\n" +
                "Scenic spot\n" +
                "Dadar West, Shivaji Park\n" +
                "A scenic spot that some say is good for kids and doesn't require advance tickets \n" +
                "What is Bandra-Worli Sea Link famous for?\n" +
                "Why is photography not allowed on Bandra-Worli Sea Link?\n" +
                "How to visit Bandra-Worli Sea Link?\n" +
                "Ask a follow up\n" +
                "\n");
        al_price_tour.add("5000");
        al_location.add("Bandra , Mumbai");


        al_img_tour.add("https://i.postimg.cc/jSN6jzT8/sunset-chowpatty.jpg");
        al_name_tour.add("Sunset Chowpatty");
        al_desc_tour.add("It stretches along the Arabian Sea coastline, offering a scenic view of the city skyline. Marine Drive is an excellent location to witness both sunrise and sunset in Mumbai.");
        al_price_tour.add("3000");
        al_location.add(" Girgaon, Mumbai, Maharashtra");

        RecyclerViewAdapterProcess();
    }

    private void RecyclerViewAdapterProcess() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecycleViewAdapter adapter = new RecycleViewAdapter(al_img_tour, al_name_tour, al_desc_tour, al_price_tour, al_location, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.bar_call_center) {
            callCalling();
            return true;
        }
        else if(item.getItemId() == R.id.bar_email){
            emailCenter();
            return true;
        }
        else if(item.getItemId() == R.id.bar_loc){
            getLoc();
            return true;
        }
                else if(item.getItemId() == R.id.bar_edit_user){
            edituser();
            return true;
        } else if (item.getItemId()==R.id.bar_logout) {
                    logout();
                    return true;

        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void logout() {
        Intent intent=new Intent(Dashboard.this,LoginPage.class);
        startActivity(intent);
    }

    private void edituser() {
        Intent intent=new Intent(Dashboard.this, EditUser.class);
        startActivity(intent);
    }

    private void getLoc() {
        alertDialog = new AlertDialog.Builder(Dashboard.this)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle("Location")
                .setMessage("\nMumbai Maharastra ,India")
                .setNeutralButton("Go to Location", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri2=Uri.parse(""+"Mumbai Maharastra, India");
                        Intent mapIntent= new Intent(Intent.ACTION_VIEW,uri2);
                        mapIntent.setPackage("com.google.android.apps.maps");

                        if (mapIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(mapIntent);

                        }
                    }
                }).show();
    }

    private void emailCenter() {
        alertDialog = new AlertDialog.Builder(Dashboard.this)
                .setIcon(android.R.drawable.ic_dialog_email)
                .setTitle("Email")
                .setMessage("\narjunvishwakarma715@gmail.com")
                .setNeutralButton("Send Messages", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"arjunvishwakarma715@gmail.com"});
                        intent.putExtra(Intent.EXTRA_SUBJECT,"");
                        intent.putExtra(Intent.EXTRA_TEXT,"Travel App");
                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent,"Choose Your App"));
                    }
                }).show();
    }

    private void callCalling() {
        // Implement your call function here
        alertDialog = new AlertDialog.Builder(Dashboard.this)
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .setTitle("Call Center")
                .setMessage("\n7709459924")
                .setNeutralButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Uri uri= Uri.parse("7709459924");
                        Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                        intent.setData(Uri.fromParts("tel", String.valueOf(uri), null));
                        if(intent.resolveActivity(getPackageManager())!=null){
                            startActivity(intent);
                        }
                    }
                }).show();
    }


    private void showAlertDialog(String title, String message) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("OK", null)
                .create();
        dialog.show();
    }
}
