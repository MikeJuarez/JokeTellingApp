# Joke Telling Android App (Nanodegree Project #4)

In this project, I will create an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app will consist of four modules. A Java library that provides jokes, a Google Cloud Endpoints (GCE) project that serves those jokes, an Android Library containing an activity for displaying jokes, and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.
<p> 
Here were the tasks that needed to be completed: 
</p>
Step 0: Starting Point <br?
This is the starting point for the final project, which is provided to you in the course repository.</p>

It contains an activity with a banner ad and a button that purports to tell a joke, but actually just complains. The banner ad was set up following the instructions here.</p>

You may need to download the Google Repository from the Extras section of the Android SDK Manager.</p>

When you can build an deploy this starter code to an emulator, you're ready to move on.</p>

Step 1: Create a Java library<br>
Your first task is to create a Java library that provides jokes. Create a new Gradle Java project either using the Android Studio wizard, or by hand. Then introduce a project dependency between your app and the new Java Library. If you need review, check out demo 4.01 from the course code.</p>

Make the button display a toast showing a joke retrieved from your Java joke telling library.</p>

Step 2: Create an Android Library<br>
Create an Android Library containing an Activity that will display a joke passed to it as an intent extra. Wire up project dependencies so that the button can now pass the joke from the Java Library to the Android Library.</p>

For review on how to create an Android library, check out demo 4.03. For a refresher on intent extras, check out this documentation.</p>

Step 3: Create GCE Module<br>
This next task will be pretty tricky. Instead of pulling jokes directly from our Java library, we'll set up a GCE development server, and pull our jokes from there. Follow the instructions in this tutorial to add a GCE module to your project:</p>

Introduce a project dependency between your Java library and your GCE module, and modify the GCE starter code to pull jokes from your Java library. Create an Async task to retrieve jokes. Make the button kick off a task to retrieve a joke, then launch the activity from your Android Library to display it.</p>

Step 4: Add Functional Tests</br>
Add code to test that your Async task successfully retrieves a non-empty string. For a refresher on setting up Android tests, check out demo 4.09.</p>

Step 5: Add a Paid Flavor</br>
Add free and paid product flavors to your app. Remove the ad (and any dependencies you can) from the paid flavor. IMPORTANT: You do not need Google AdMob in the Manifest of the paid version of the app. Make sure to include this only with the free/ manifest. Also make sure to add Google Play Services only to the free version of the app in Gradle.</p>

Optional Tasks</br>
For extra practice to make your project stand out, complete the following tasks.</p>

Add Interstitial Ad</br>
Follow these instructions to add an interstitial ad to the free version. Display the ad after the user hits the button, and before the joke is shown.</p>

Add Loading Indicator</br>
Add a loading indicator that is shown while the joke is being retrieved, and disappears when the joke is ready. This tutorial is a good place to start.</p>

Configure Test Task</br>
To tie it all together, create a Gradle task that:</p>

Launches the GCE local development server (in Daemon mode, so it doesn't block further execution)</br>
Runs all tests</br>
Shuts the server down again</br>
NEXT</p>

## Getting Started

1.  Create a new folder to copy the project</br>
2.  Open a command line program and type: git clone https://github.com/MikeJuarez/JokeTellingApp</p>

### Screenshots

<img src="https://raw.githubusercontent.com/MikeJuarez/JokeTellingApp/master/_screenshots/1main_screen.png" width="250" />
<img src="https://raw.githubusercontent.com/MikeJuarez/JokeTellingApp/master/_screenshots/2interstitial_ad_screenshot.png" width="250"/>
<img src="https://raw.githubusercontent.com/MikeJuarez/JokeTellingApp/master/_screenshots/3the_joke.png" width="250"/>

## Built With

* Android Studio
* Java

## Authors
Michael Juarez

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details