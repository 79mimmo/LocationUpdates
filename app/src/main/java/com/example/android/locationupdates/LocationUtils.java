/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.locationupdates;

import android.content.Context;
import android.location.Location;

import com.example.android.locationupdates.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Defines app-wide constants and utilities
 */
public final class LocationUtils {

    // Debugging tag for the application
    public static final String APPTAG = "LocationSample";

    // Name of shared preferences repository that stores persistent state
    public static final String SHARED_PREFERENCES =
            "com.example.android.location.SHARED_PREFERENCES";

    // Key for storing the "updates requested" flag in shared preferences
    public static final String KEY_UPDATES_REQUESTED =
            "com.example.android.location.KEY_UPDATES_REQUESTED";

    /*
     * Define a request code to send to Google Play services
     * This code is returned in Activity.onActivityResult
     */
    public final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    /*
     * Constants for location update parameters
     */
    // Milliseconds per second
    public static final int MILLISECONDS_PER_SECOND = 1000;

    // The update interval
    public static final int UPDATE_INTERVAL_IN_SECONDS = 5;

    // A fast interval ceiling
    public static final int FAST_CEILING_IN_SECONDS = 1;

    // Update interval in milliseconds
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS =
            MILLISECONDS_PER_SECOND * UPDATE_INTERVAL_IN_SECONDS;

    // A fast ceiling of update intervals, used when the app is visible
    public static final long FAST_INTERVAL_CEILING_IN_MILLISECONDS =
            MILLISECONDS_PER_SECOND * FAST_CEILING_IN_SECONDS;

    // Create an empty string for initializing strings
    public static final String EMPTY_STRING = new String();

    /**
     * Get the latitude and longitude from the Location object returned by
     * Location Services.
     *
     * @param currentLocation A Location object containing the current location
     * @return The latitude and longitude of the current location, or null if no
     * location is available.
     */
    public static String getLatLng(Context context, Location currentLocation) {
        // If the location is valid
        if (currentLocation != null) {

            // Return the latitude and longitude as strings
            return context.getString(
                    R.string.latitude_longitude,
                    currentLocation.getLatitude(),
                    currentLocation.getLongitude());
        } else {

            // Otherwise, return the empty string
            return EMPTY_STRING;
        }
    }

    public static String getProvider(Context context, Location currentLocation) {
        // If the location is valid
        if (currentLocation != null) {

            // Return the latitude and longitude as strings
            return currentLocation.getProvider();
        } else {

            // Otherwise, return the empty string
            return context.getString(R.string.provider_unknown);
        }
    }

    public static String getLat(Context context, Location currentLocation){
        // If the location is valid
        if (currentLocation != null) {
            // Return the latitude and longitude as strings
            Double latitudine=currentLocation.getLatitude();
            return latitudine.toString();
        } else {
            // Otherwise, return the empty string
            return context.getString(R.string.unknown);
        }
    }

    public static String getLong(Context context, Location currentLocation){
        // If the location is valid
        if (currentLocation != null) {
            // Return the latitude and longitude as strings
            Double longitudine=currentLocation.getLongitude();
            return longitudine.toString();
        } else {
            // Otherwise, return the empty string
            return context.getString(R.string.unknown);
        }
    }

    public static String getTime(Context context, Location currentLocation){
        // If the location is valid
        if (currentLocation != null) {
            // Return the latitude and longitude as strings
            Long timeStamp=currentLocation.getTime();
            Date dataCampione=new Date(timeStamp);

            SimpleDateFormat sdfutc=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
            String dataUTC=sdfutc.format(dataCampione);
            return dataUTC.toString();
        } else {
            // Otherwise, return the empty string
            return context.getString(R.string.unknown);
        }
    }

    public static String getSpeed(Context context, Location currentLocation){
        // If the location is valid
        if (currentLocation != null&& currentLocation.hasSpeed()) {
            // Return the latitude and longitude as strings
            Float velocità=currentLocation.getSpeed();
            return velocità.toString();
        } else {
            // Otherwise, return the empty string
            return context.getString(R.string.unknown);
        }
    }

    public static String getBearing(Context context, Location currentLocation){
        // If the location is valid
        if (currentLocation != null&&currentLocation.hasBearing()) {
            // Return the latitude and longitude as strings
            Float bearing=currentLocation.getBearing();
            return bearing.toString();
        } else {
            // Otherwise, return the empty string
            return context.getString(R.string.unknown);
        }
    }

    public static String getAltezza(Context context, Location currentLocation){
        // If the location is valid
        if (currentLocation != null&&currentLocation.hasAltitude()) {

            // Return the latitude and longitude as strings
            Double altezza=currentLocation.getAltitude();
            return altezza.toString();
        } else {

            // Otherwise, return the empty string
            return context.getString(R.string.unknown);
        }
    }
    public static String getAccuracy(Context context, Location currentLocation){
        // If the location is valid
        if (currentLocation != null&&currentLocation.hasAccuracy()) {

            // Return the latitude and longitude as strings
            Float precisione=currentLocation.getAccuracy();
            return (precisione.toString());
        } else {

            // Otherwise, return the empty string
            return context.getString(R.string.accuracy_unknown);
        }
    }
}
