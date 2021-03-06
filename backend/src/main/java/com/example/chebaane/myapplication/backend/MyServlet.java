/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.example.chebaane.myapplication.backend;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
    //firebase
    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mBSSIDSDatabaseReference;

    @Override
    public void doGet(HttpServletRequest req, final HttpServletResponse resp)
            throws IOException {
        InputStream input = new URL("https://wifilocator-fe294.firebaseio.com/").openStream();
        Reader reader = new InputStreamReader(input, "UTF-8");
        List<Point> points = new Gson().fromJson(reader, new TypeToken<List<Point>>(){}.getType());
        KMeans kMeans = new KMeans(points, 4);
        List<Cluster> pointsClusters = kMeans.getPointsClusters();
        for (int i = 0; i < kMeans.k; i++)
            System.out.println("Cluster " + i + ": " + pointsClusters.get(i));
        String json = new Gson().toJson(pointsClusters);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }






    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws IOException {
        InputStream input = req.getInputStream();
        Reader reader = new InputStreamReader(input, "UTF-8");
        List<AccessPoint> accessPoints = new GsonBuilder().serializeSpecialFloatingPointValues().create()
                .fromJson(reader, new TypeToken<List<AccessPoint>>(){}.getType());
        List<Point>points=new ArrayList<Point>();
        for(AccessPoint accessPoint:accessPoints){
            points.add(new Point(accessPoint.getLevel(),accessPoint.getLat(),accessPoint.getLng()));
        }
        KMeans kMeans = new KMeans(points,3);
        List<Cluster> pointsClusters = kMeans.getPointsClusters();
        for (int i = 0; i < kMeans.k ; i++)
            System.out.println("Cluster " + i + ": " + pointsClusters.get(i));
        String json = new GsonBuilder().serializeSpecialFloatingPointValues().create().toJson(pointsClusters);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
//        String region = req.getParameter("region");
//        String ssid = req.getParameter("ssid");
//        resp.setContentType("text/plain");
//        if (region == null) {
//            resp.getWriter().println("Please choose a Region");
//        }
//        if (ssid == null) {
//            resp.getWriter().println("Please select an ssid");
//        }
//    }
}
