package com.shrimali.eduapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private  EditProfileActivity editProfileActivity;
    @Before
    public void setup() {

        editProfileActivity = new EditProfileActivity();

    }
        @Test
        public void TestSigninbtnAnime () {

            float result = EditProfileActivity.RESULT_CANCELED;

        }
}